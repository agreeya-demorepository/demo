package com.agreeya.chhs.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

import com.agreeya.chhs.bd.AESSecurityBD;
import com.agreeya.chhs.dao.UserDAO;
import com.agreeya.chhs.exception.UserException;
import com.agreeya.chhs.exception.WSException;
import com.agreeya.chhs.model.Role;
import com.agreeya.chhs.model.User;
import com.agreeya.chhs.model.UserSession;
import com.agreeya.chhs.model.Userdetail;
import com.agreeya.chhs.model.Userfamily;
import com.agreeya.chhs.model.Userinbox;
import com.agreeya.chhs.model.Userkid;
import com.agreeya.chhs.model.Userlicence;
import com.agreeya.chhs.model.Userspouse;
import com.agreeya.chhs.request.GetUserInboxRequest;
import com.agreeya.chhs.request.SaveUserRequest;
import com.agreeya.chhs.request.UserRegistrationRequest;
import com.agreeya.chhs.request.user.UserKidsDetails;
import com.agreeya.chhs.response.UserInboxResponse;
import com.agreeya.chhs.response.inbox.UserEmail;
import com.agreeya.chhs.util.Constants;
import com.agreeya.chhs.util.DateUtil;

/**
 * 
 * implementation class for UserDAO
 * @author AgreeYa Solutions
 *
 */
public class UserDAOImpl extends BaseDAOImpl implements UserDAO {

	private AESSecurityBD aESSecurityBD;

	/**
	 * @purpose: check user detail is exist or not by user name and email
	 * @param email
	 * @param userName
	 * @return String
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String checkUserDetailExist(String userName, String email) {
		String status = "";
		Query query = sessionFactory.getCurrentSession()
				.createSQLQuery("SELECT u.id FROM user u INNER JOIN userauth uth ON  u.id=uth.userId "
						+ "AND u.status='ACTIVE' AND uth.userStatus='ACTIVE' " 
						+ "AND uth.userStatus='active' AND u.userName='" + userName
						+ "' AND u.userEmailId='" + email + "' AND uth.userName='" + userName + "'");
		List<Long> listId = query.list();
		if (null != listId && !listId.isEmpty()) {
			status = Constants.EXIST;
		}
		return status;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public String registerUser(UserRegistrationRequest request)
			throws HibernateException, SQLException, UserException, WSException {
		String msg = "";
		String emailId = request.getPersonalProfile().getUseremail();
		String userName = request.getPersonalProfile().getUserName();

		List<User> userList = null;
		/*
		 * used to save the unique user : uniqueness is controlled by emailId, username
		 */
		
		Session sess = sessionFactory.openSession();
		userList = (List<User>) sessionFactory.getCurrentSession().createQuery(
				"from User as u WHERE u.userName = '" + userName + "' "
				+ "	AND u.useremail = '" + emailId + "' and STATUS IN ('ACTIVE','INCOMPLETE')").list();

		if (userList != null) {
			if (userList.isEmpty()) {
				User user = new User();

				user.setUserName(request.getPersonalProfile().getUserName());
				user.setPassword(aESSecurityBD.encryptAES(request.getPersonalProfile().getPassword()));

				user.setUseremail(request.getPersonalProfile().getUseremail());
				user.setHomestudy(request.getPersonalProfile().getHomestudy());
				user.setTraining(request.getPersonalProfile().getTraining());
				Role role = getById(Role.class, 1);
				user.setRole(role);
				if (request.getRegistrationStage() < 4) {
					user.setStatus(Constants.UserStatusType.INCOMPLETE.toString());
				} else {
					user.setStatus(Constants.UserStatusType.ACTIVE.toString());
				}
				String caseID = getUniqueCaseID(sess);
				user.setCaseID(caseID);
				user.setStage(request.getRegistrationStage());
				user.setCreatedOn(new Date());
				user.setModifiedOn(new Date());

				int userId = (Integer) sess.save(user);

				user.setCreatedBy(userId);
				user.setModifiedBy(userId);

				sess.update(user);
				List<User> usrList = new ArrayList();
				usrList.add(user);
				
				if (request.getRegistrationStage() >= 2) {
					Userdetail userDtls = new Userdetail();

					
					userDtls.setUser(user);
					userDtls.setFirstName(request.getPersonalDetails().getFirstName());
					userDtls.setLastName(request.getPersonalDetails().getLastName());
					userDtls.setContactNo(request.getPersonalDetails().getContactNo());
					userDtls.setDob(DateUtil.getDateFromString(request.getPersonalDetails().getDob(), "MM/dd/yyyy"));
					userDtls.setGender(request.getPersonalDetails().getGender());
					userDtls.setMaritalStatus(request.getPersonalDetails().getMaritalStatus());
					userDtls.setRace(request.getPersonalDetails().getRace());
					userDtls.setFirstName(request.getPersonalDetails().getFirstName());
					userDtls.setReligion(request.getPersonalDetails().getReligion());
					userDtls.setOccupation(request.getPersonalDetails().getOccupation());
					userDtls.setPreference(request.getPersonalDetails().getPreference());
					userDtls.setHobbies(request.getPersonalDetails().getHobbies());
					userDtls.setIncome(request.getPersonalDetails().getIncome());
					userDtls.setCreatedBy(userId);
					userDtls.setCreatedOn(new Date());
					userDtls.setModifiedBy(userId);
					userDtls.setModifiedOn(new Date());
					

					sess.saveOrUpdate(userDtls);

					Userspouse spouseDtls = new Userspouse();

					spouseDtls.setUser(user);
					spouseDtls.setFirstName(request.getPersonalDetails().getSpouseDetails().getFirstName());
					spouseDtls.setContactNo(request.getPersonalDetails().getSpouseDetails().getContactNo());
					spouseDtls.setDob(DateUtil.getDateFromString(request.getPersonalDetails()
							.getSpouseDetails().getDob(), "MM/dd/yyyy"));
					spouseDtls.setGender(request.getPersonalDetails().getSpouseDetails().getGender());
					spouseDtls.setRace(request.getPersonalDetails().getSpouseDetails().getRace());
					spouseDtls.setFirstName(request.getPersonalDetails().getSpouseDetails().getFirstName());
					spouseDtls.setReligion(request.getPersonalDetails().getSpouseDetails().getReligion());
					spouseDtls.setOccupation(request.getPersonalDetails().getSpouseDetails().getOccupation());
					spouseDtls.setPreference(request.getPersonalDetails().getSpouseDetails().getPreference());
					spouseDtls.setHobbies(request.getPersonalDetails().getSpouseDetails().getHobbies());
					spouseDtls.setIncome(request.getPersonalDetails().getSpouseDetails().getIncome());
					spouseDtls.setCreatedBy(userId);
					spouseDtls.setCreatedOn(new Date());
					spouseDtls.setModifiedBy(userId);
					spouseDtls.setModifiedOn(new Date());

					sess.saveOrUpdate(spouseDtls);

				}

				if (request.getRegistrationStage() >= 3) {
					Userfamily famDtls = new Userfamily();

					famDtls.setDescription(request.getFamilyDetails().getDescription());
					famDtls.setHaveKids(request.getFamilyDetails().getHaveKids());
					famDtls.setKid(request.getFamilyDetails().getNumberOfKids());
					famDtls.setKidsInfo(request.getFamilyDetails().getKidsPref());

					famDtls.setUser(user);
					famDtls.setCreatedBy(userId);
					famDtls.setModifiedBy(userId);
					famDtls.setCreatedOn(new Date());
					famDtls.setModifiedOn(new Date());
					
					sess.saveOrUpdate(famDtls);
					
					for (UserKidsDetails kid : request.getFamilyDetails().getKids()) {
						Userkid uKid = new Userkid();
						uKid.setName(kid.getKidName());
						uKid.setAgeGroup(kid.getAge());
						uKid.setHobbies(kid.getHobbies());
						uKid.setUserfamily(famDtls);
						sess.saveOrUpdate(uKid);
					}
					
				}
				if (request.getRegistrationStage() >= 4) {
					Userlicence lic = new Userlicence();

					lic.setAgencyContact(request.getLicenceDetails().getAgencyContact());
					lic.setAgencyWorker(100);
					lic.setLicenceNo(request.getLicenceDetails().getLicenceNo());
					lic.setDateOfIssue(DateUtil.getDateFromString(request.getLicenceDetails().getDateOfIssue(), "MM/dd/yyyy"));

					lic.setUser(user);
					lic.setCreatedBy(userId);
					lic.setModifiedBy(userId);
					lic.setCreatedon(new Date());
					lic.setModifiedOn(new Date());

					sess.saveOrUpdate(lic);
					
				}
				
				sess.flush();
				sess.close();
				
				msg = "User Registered successfully";
			} else {
				msg = "User already Exist with provided username and email";
			}

		}
		return msg;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public String saveUser(SaveUserRequest request)
			throws HibernateException, SQLException, UserException, WSException {
		String msg = "";
		String emailId = request.getPersonalProfile().getUseremail();
		String userName = request.getPersonalProfile().getUserName();

		List<User> userList = null;
		
		Session sess = sessionFactory.openSession();
		userList = (List<User>) sessionFactory.getCurrentSession().createQuery(
				"from User as u WHERE u.userName = '" + userName + "' "
				+ "	AND u.useremail = '" + emailId + "' and status ='ACTIVE' or  status ='INCOMPLETE'").list();

		if (userList != null) {
			if (!userList.isEmpty()) {
				User user = userList.get(0);

				user.setUserName(user.getUserName());
				user.setPassword(aESSecurityBD.encryptAES(request.getPersonalProfile().getPassword()));

				user.setUseremail(request.getPersonalProfile().getUseremail());
				user.setHomestudy(request.getPersonalProfile().getHomestudy());
				user.setTraining(request.getPersonalProfile().getTraining());
				Role role = getById(Role.class, 1);
				user.setRole(role);
				if (request.getRegistrationStage() < 4) {
					user.setStatus(Constants.UserStatusType.INCOMPLETE.toString());
				} else {
					user.setStatus(Constants.UserStatusType.ACTIVE.toString());
				}
				
				user.setStage(request.getRegistrationStage());
				user.setCreatedOn(new Date());
				user.setModifiedOn(new Date());

				int userId = user.getUserID();

				user.setCreatedBy(userId);
				user.setModifiedBy(userId);

				sess.merge(user);
				
				List<User> usrList = new ArrayList();
				usrList.add(user);
				
				if (request.getRegistrationStage() >= 2) {
					
					Query query = sess.createSQLQuery("SELECT id FROM userdetail ud WHERE ud.UserID = " + user.getUserID());
					
					int userDetailID = 0;	
					List<Integer> idList =  query.list();
					if (idList.size() > 0) {
						userDetailID = idList.get(0);
					}
					
					Userdetail userDtls = new Userdetail();
					if (userDetailID > 0) {
						userDtls = getById(Userdetail.class, userDetailID);
					}
					
					userDtls.setUser(user);
					userDtls.setFirstName(request.getPersonalDetails().getFirstName());
					userDtls.setLastName(request.getPersonalDetails().getLastName());
					userDtls.setContactNo(request.getPersonalDetails().getContactNo());
					userDtls.setDob(DateUtil.getDateFromString(request.getPersonalDetails().getDob(), "MM/dd/yyyy"));
					userDtls.setGender(request.getPersonalDetails().getGender());
					userDtls.setMaritalStatus(request.getPersonalDetails().getMaritalStatus());
					userDtls.setRace(request.getPersonalDetails().getRace());
					userDtls.setFirstName(request.getPersonalDetails().getFirstName());
					userDtls.setReligion(request.getPersonalDetails().getReligion());
					userDtls.setOccupation(request.getPersonalDetails().getOccupation());
					userDtls.setPreference(request.getPersonalDetails().getPreference());
					userDtls.setHobbies(request.getPersonalDetails().getHobbies());
					userDtls.setIncome(request.getPersonalDetails().getIncome());
					userDtls.setCreatedBy(userId);
					userDtls.setCreatedOn(new Date());
					userDtls.setModifiedBy(userId);
					userDtls.setModifiedOn(new Date());
					

					sess.saveOrUpdate(userDtls);

					Query spouseQuery = sess.createSQLQuery("SELECT userSpouseID FROM userspouse us "
							+ "WHERE us.UserID = " + user.getUserID());
					
					int userSpouseID = 0;	
					List<Integer> idListspouse =  spouseQuery.list();
					if (idListspouse.size() > 0) {
						userSpouseID = idListspouse.get(0);
					}
					
					Userspouse spouseDtls = new Userspouse();
					if (userSpouseID > 0) {
						spouseDtls = getById(Userspouse.class, userSpouseID);
					}

					spouseDtls.setUser(user);
					spouseDtls.setFirstName(request.getPersonalDetails().getSpouseDetails().getFirstName());
					spouseDtls.setContactNo(request.getPersonalDetails().getSpouseDetails().getContactNo());
					spouseDtls.setDob(DateUtil.getDateFromString(request.getPersonalDetails()
							.getSpouseDetails().getDob(), "MM/dd/yyyy"));
					spouseDtls.setGender(request.getPersonalDetails().getSpouseDetails().getGender());
					spouseDtls.setRace(request.getPersonalDetails().getSpouseDetails().getRace());
					spouseDtls.setFirstName(request.getPersonalDetails().getSpouseDetails().getFirstName());
					spouseDtls.setReligion(request.getPersonalDetails().getSpouseDetails().getReligion());
					spouseDtls.setOccupation(request.getPersonalDetails().getSpouseDetails().getOccupation());
					spouseDtls.setPreference(request.getPersonalDetails().getSpouseDetails().getPreference());
					spouseDtls.setHobbies(request.getPersonalDetails().getSpouseDetails().getHobbies());
					spouseDtls.setIncome(request.getPersonalDetails().getSpouseDetails().getIncome());
					spouseDtls.setCreatedBy(userId);
					spouseDtls.setCreatedOn(new Date());
					spouseDtls.setModifiedBy(userId);
					spouseDtls.setModifiedOn(new Date());

					sess.saveOrUpdate(spouseDtls);

				}

				if (request.getRegistrationStage() >= 3) {
					
					
					Query familyQuery = sess.createSQLQuery("SELECT id FROM userfamily uf "
							+ "WHERE uf.UserID = " + user.getUserID());
					
					int userFamilyID = 0;	
					List<Integer> idListfam =  familyQuery.list();
					if (idListfam.size() > 0) {
						userFamilyID = idListfam.get(0);
					}
					
					Userfamily famDtls = new Userfamily();
					if (userFamilyID > 0) {
						famDtls = getById(Userfamily.class, userFamilyID);
					}
					

					famDtls.setDescription(request.getFamilyDetails().getDescription());
					famDtls.setHaveKids(request.getFamilyDetails().getHaveKids());
					famDtls.setKid(request.getFamilyDetails().getNumberOfKids());
					famDtls.setKidsInfo(request.getFamilyDetails().getKidsPref());

					famDtls.setUser(user);
					famDtls.setCreatedBy(userId);
					famDtls.setModifiedBy(userId);
					famDtls.setCreatedOn(new Date());
					famDtls.setModifiedOn(new Date());
					
					sess.saveOrUpdate(famDtls);
					
					
					Query kidsQuery = sess.createSQLQuery("SELECT userKidID FROM userkids uk "
							+ "WHERE uk.familyID = " + userFamilyID);
					
					List<Integer> idListkids =  kidsQuery.list();
					if (idListkids.size() > 0) {
						for (int kid : idListkids) {
							Userkid uKid = getById(Userkid.class, kid);
							for (UserKidsDetails reqKid : request.getFamilyDetails().getKids()) {
								uKid.setName(reqKid.getKidName());
								uKid.setAgeGroup(reqKid.getAge());
								uKid.setHobbies(reqKid.getHobbies());
								uKid.setUserfamily(famDtls);
								sess.saveOrUpdate(uKid);
							}
						}

					} else {
						for (UserKidsDetails kid : request.getFamilyDetails().getKids()) {
							Userkid uKid = new Userkid();
							uKid.setName(kid.getKidName());
							uKid.setAgeGroup(kid.getAge());
							uKid.setHobbies(kid.getHobbies());
							uKid.setUserfamily(famDtls);
							sess.saveOrUpdate(uKid);
						}
					}
					
				}
				if (request.getRegistrationStage() >= 4) {
					Userlicence lic = new Userlicence();
					Query licQuery = sess.createSQLQuery("SELECT id FROM userlicence l "
							+ "WHERE l.UserID = " + user.getUserID());
					
					int userLicID = 0;	
					List<Integer> idListLic =  licQuery.list();
					if (idListLic.size() > 0) {
						userLicID = idListLic.get(0);
					}
					
					if (userLicID > 0) {
						lic = getById(Userlicence.class, userLicID);
					}

					lic.setAgencyContact(request.getLicenceDetails().getAgencyContact());
					lic.setAgencyWorker(100);
					lic.setLicenceNo(request.getLicenceDetails().getLicenceNo());
					lic.setDateOfIssue(DateUtil.getDateFromString(request.getLicenceDetails().getDateOfIssue(), "MM/dd/yyyy"));

					lic.setUser(user);
					lic.setCreatedBy(userId);
					lic.setModifiedBy(userId);
					lic.setCreatedon(new Date());
					lic.setModifiedOn(new Date());

					sess.saveOrUpdate(lic);
				}
				
				sess.flush();
				sess.close();
				
				msg = "User Saved successfully";
			} else {
				msg = "User Details not Found";
			}

		}
		return msg;
	}
	
	@Override
	@Transactional
	public UserInboxResponse getUserInbox(GetUserInboxRequest request, UserInboxResponse response) {
		Query query = sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM userinbox ib WHERE ib.UserID = "
					+ request.getUserContext().getUserId()).addEntity(Userinbox.class);
		
		List<Userinbox> inboxes = query.list();
		
		List<UserEmail> emailList = new ArrayList();
		for (Object  userinbox : inboxes) {
			UserEmail email = new UserEmail();
			BeanUtils.copyProperties(userinbox, email);
			emailList.add(email);
		}
		response.setEmails(emailList);
		return response;
	}
	
	public AESSecurityBD getaESSecurityBD() {
		return aESSecurityBD;
	}

	public void setaESSecurityBD(AESSecurityBD aESSecurityBD) {
		this.aESSecurityBD = aESSecurityBD;
	}
	
	
	
	private String getUniqueCaseID(Session sess) {
		boolean flag = false;
		String unqCaseId;
		do {
			unqCaseId = generateUniqueCaseID();
			List<User> userList = (List<User>) sess.createQuery("from User as u WHERE u.caseID ='" + unqCaseId + "'").list();
			if (!(userList.size() > 0)) {
				flag = true;
			}

		} while (!flag);

		return unqCaseId;

	}
	
	
	
	private String generateUniqueCaseID() {

		String prefix = Constants.CASEID;
		String middle = Long.toHexString(Double.doubleToLongBits(Math.random())).substring(0, 5).toUpperCase();

		List<Integer> numbers = new ArrayList();
		for (int i = 0; i < 10; i++) {
			numbers.add(i);
		}

		Collections.shuffle(numbers);

		String result = "";
		for (int i = 0; i < 4; i++) {
			result += numbers.get(i).toString();
		}

		return prefix + middle + "-" + result;
	}
	
	@Override
	@Transactional
	public String getUserSessionForTest() {
		Query query = sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM usersession ss WHERE ss.UserId = 397")
				.addEntity(UserSession.class);

		List<UserSession> list = query.list();
		String sess = list.get(0).getSessionId();
		return sess;
	}
	
}
