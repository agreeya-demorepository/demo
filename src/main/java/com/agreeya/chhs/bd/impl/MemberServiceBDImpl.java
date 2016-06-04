package com.agreeya.chhs.bd.impl;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.agreeya.chhs.bd.AESSecurityBD;
import com.agreeya.chhs.bd.MemberServiceBD;
import com.agreeya.chhs.exception.MembershipException;
import com.agreeya.chhs.exception.UserException;
import com.agreeya.chhs.exception.WSException;
import com.agreeya.chhs.model.User;
import com.agreeya.chhs.model.UserSession;
import com.agreeya.chhs.request.GetUserInboxRequest;
import com.agreeya.chhs.request.SaveUserRequest;
import com.agreeya.chhs.request.UserLogoutRequest;
import com.agreeya.chhs.request.UserRegistrationRequest;
import com.agreeya.chhs.response.SaveUserResponse;
import com.agreeya.chhs.response.UserInboxResponse;
import com.agreeya.chhs.response.UserLogoutResponse;
import com.agreeya.chhs.response.UserRegistrationResponse;
import com.agreeya.chhs.service.MemberService;
import com.agreeya.chhs.to.UserContextTO;
import com.agreeya.chhs.util.CHHSErrorCodes;
import com.agreeya.chhs.util.Constants;

/**
 * Business delegate class for the Membership-related services
 *
 */
/**
 * 
 */
public class MemberServiceBDImpl implements MemberServiceBD {

	private MemberService memberService;
	private AESSecurityBD aESSecurityBD;
	private static Logger log = Logger.getLogger(MemberServiceBDImpl.class);

	/*
	 * @param userName
	 * 
	 * @param password
	 * com.agreeya.tta.bd.MemberServiceBD#authenticateUser(java.lang.String,
	 * java.lang.String)
	 * 
	 * @return UserContextTO
	 */
	@Override
	@Transactional
	public UserContextTO authenticateUser(String userName, String password) {
		log.info("enter into MemberServiceBDImpl authenticateUser() ....................");
		if (userName == null || userName.isEmpty()) {
			if (log.isDebugEnabled()) {
				log.debug("user name is invalid");
			}
			return null;
		}
		if (password == null || password.isEmpty()) {
			if (log.isDebugEnabled()) {
				log.debug("password is invalid");
			}
			return null;
		}
		// this method used to get password by username and decript
		// password.when user active..
		String decryptPassword = "";
		try {
			decryptPassword = decryptAESPassword(userName, Constants.UserStatusType.ACTIVE.toString());
		} catch (WSException e) {
			log.error(CHHSErrorCodes.DECRYPT_DATA_ERROR_MESSAGE, e);
		}

		if (password.equals(decryptPassword)) {
			// if user name and password are not null then check in database
			User user = memberService.authenticateUser(userName, password);
			if (log.isInfoEnabled()) {
				log.info("user is authenticated");
			}
			// if user authenticated then create session
			if (user != null) {
				UserSession userSession = new UserSession();
				String sessionId = RandomStringUtils.randomAlphanumeric(Constants.SUBSCRIBER_SESSIONID_LENGTH);
				userSession.setSessionId(sessionId);
				userSession.setUser(user);

				Calendar now = Calendar.getInstance();
				now.add(Calendar.MINUTE, 720); // session valid for the next 720
				// mins.
				Date expiryDate = now.getTime();
				userSession.setExpiryDate(expiryDate);
				userSession.setCreatedOn(new Date());
				userSession.setCreatedBy(user.getUserID());
				userSession.setUpdatedBy(user.getUserID());
				userSession.setUpdatedOn(new Date());

				// now all set to create new session, update user session if
				// user
				// already present insert new row if user is not found

				UserSession prevUserSession = memberService.findPrevUserSession(user);

				if (prevUserSession != null) {
					userSession.setId(prevUserSession.getId());
					userSession.setCreatedOn(prevUserSession.getCreatedOn());
					userSession.setCreatedBy(prevUserSession.getCreatedBy());
				}

				memberService.createOrUpdateUserSession(userSession);

				// session is created, now set role to user
				// Map<String, Boolean> roleComponentMap =
				// roleComponentService.getcomponentByRoleId(user.getUserRoleId().getId());
				UserContextTO userContext = new UserContextTO();
				userContext.setSessionId(sessionId);
				userContext.setUserId(user.getUserID());
				if (user.getUserdetails().size()  > 0) {
					userContext.setFirstName(user.getUserdetails().get(0).getFirstName());
					userContext.setLastName(user.getUserdetails().get(0).getLastName());
				} else {
					userContext.setFirstName("");
					userContext.setLastName("");
				}
				userContext.setUserName(user.getUserName());
				userContext.setProfileStage(user.getStage());
				userContext.setUserStatus(user.getStatus());
				// TODO ---------
				// userContext.setRoleName(user.getUserRoleId().getName());
				//userContext.setUserRoleMap(new HashMap<String, Boolean>()); // (roleComponentMap);
				Date date = new Date();
				// dd-MMM-yyyy HH:mm:SS
				String loggedInDate = DateFormatUtils.format(date, "MM/dd/yyyy HH:mm");
				userContext.setLoggedInDate(loggedInDate);
				log.info("exit from MemberServiceBDImpl authenticateUser API ....................");
				return userContext;

			} else {
				throw new MembershipException(CHHSErrorCodes.INVALID_USERNAME_PASSWORD,
						CHHSErrorCodes.INVALID_USERNAME_PASSWORD_MESSAGE);
			}
		} else {
			throw new MembershipException(CHHSErrorCodes.INVALID_USERNAME_PASSWORD,
					CHHSErrorCodes.INVALID_USERNAME_PASSWORD_MESSAGE);
		}
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public boolean isUserSessionValid(String sessionId, int userId) {
		log.info("enter into MemberServiceBDImpl isUserSessionValid() ....................");
		if (log.isInfoEnabled()) {
			log.info("Started isUserSessionValid() method with userId id: " + userId + " Session Id:" + sessionId);
		}
		if (sessionId == null) {
			log.error("Session Id is not provided!");
			throw new MembershipException("Session Id is not provided!");
		}
		if (userId <= 0) {
			log.error("userId Id is not provided!");
			throw new MembershipException("user Id  is not provided!");
		}
		boolean valid = false;
		UserSession userSession = memberService.findUserSession(sessionId, userId);
		if (userSession != null && userSession.getExpiryDate() != null
				&& new Date().compareTo(userSession.getExpiryDate()) <= 0) {
			if (log.isDebugEnabled()) {
				log.debug("Current date: " + new Date() + " Session expiry date:" + userSession.getExpiryDate());
			}
			valid = true;
		}
		if (log.isInfoEnabled()) {
			log.info("exit from MemberServiceBDImpl isUserSessionValid() with status as ...................." + valid);
		}
		return valid;
	}

	/*
	 * @purpose : This method is used check user detail is exist
	 * 
	 * @param : userName
	 * 
	 * @param : email
	 * 
	 * @return msg
	 */
	@Override
	public String checkUserDetailExist(String userName, String email) {
		log.info("enter into MemberServiceBDImpl checkUserDetailExist() method....................");
		if (userName == null || userName.isEmpty()) {
			if (log.isDebugEnabled()) {
				log.error("userName Id is not provided!");
			}
			throw new MembershipException("User name is not provided!");
		}
		if (email == null || email.isEmpty()) {
			if (log.isDebugEnabled()) {
				log.debug("email is invalid");
			}
			throw new MembershipException("Email id is not provided!");
		}

		String msg = memberService.checkUserDetailExist(userName, email);
		log.info("enter into MemberServiceBDImpl checkUserDetailExist() method...................." + msg);
		return msg;
	}

	// get encrypted password from user table and decrypted by AES encryption.
	public String decryptAESPassword(String userName, String userStatus) throws WSException {
		log.info("enter into MemberServiceBDImpl decryptAESPassword() method....................");
		String decryptPassword = "";
		try {
			String encryptPass = memberService.getEncryptPassword(userName, userStatus);
			// aESSecurityBD.encryptAES("firstTime");
			decryptPassword = aESSecurityBD.decryptData(encryptPass);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(CHHSErrorCodes.DECRYPT_DATA_ERROR_MESSAGE, e);
		}
		log.info("enter from MemberServiceBDImpl decryptAESPassword() method....................");
		return decryptPassword;
	}

	@Override
	public void logoutUser(UserLogoutRequest userLogoutRequest, UserLogoutResponse userLogoutResponse) {
		log.info("enter into MemberServiceBDImpl logoutUser() ....................");
		UserContextTO userContext = userLogoutRequest.getUserContext();
		int userId = userContext.getUserId();
		memberService.logoutUser(userId);
		log.info("exit from MemberServiceBDImpl logoutUser() ....................");
		userLogoutResponse.setMessage("logout successfully");
	}
	
	
	@Override
	public UserRegistrationResponse registerUser(UserRegistrationRequest request, UserRegistrationResponse response)
			throws HibernateException, SQLException, UserException, WSException {
		 String message = memberService.registerUser(request);
		 response.setMessage(message);
		 
		 return response;
	}
	
	@Override
	public SaveUserResponse saveUser(SaveUserRequest request, SaveUserResponse response)
			throws HibernateException, SQLException, UserException, WSException {
		 String message = memberService.saveUser(request);
		 response.setMessage(message);
		 
		 return response;
	}
	
	@Override
	public UserInboxResponse getUserInbox(GetUserInboxRequest request, UserInboxResponse response) {
		memberService.getUserInbox(request, response);
		if (response.getEmails().size() <= 0) {
			response.setMessage("NO Emails found");
		}
		return response;
	}
	
	/*************************
	 * Spring Getter/Setter
	 *******************************/

	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public AESSecurityBD getaESSecurityBD() {
		return aESSecurityBD;
	}

	public void setaESSecurityBD(AESSecurityBD aESSecurityBD) {
		this.aESSecurityBD = aESSecurityBD;
	}

}
