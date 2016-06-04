/**
 * 
 */
package com.agreeya.chhs.to;

import java.util.Date;

/**
 * 
 */
public class UserTO {

	private Long id;
	private String userName;
	private String firstName;
	private String completeName;
	private String lastName;
	private String password;
	private String userEmailId;
	private String userContactNo;
	private String designation;
	private Long userRoleId;
	private String userRoleName;
	private String customCreationDate;
	private Date createdOn;
	private Long createdBy;
	private Date upatedOn;
	private Long updatedBy;
	private String ssnNumber;
	private String userRoleDescription;
	private Long employmentType;

	// added by anil kumar
	private Long projectUserId;
	private Long projectId;
	private Boolean isUserTimesheetApproved;
	private String userActivateDate;
	private String userDeactivateDate;
	private String projectEndDate;
	private String projectName;
	private String roProjectName;
	private boolean userStatusBoolean;
	private String userStatus;
	private boolean isAdmin;
	private Long userContextId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public String getUserContactNo() {
		return userContactNo;
	}

	public void setUserContactNo(String userContactNo) {
		this.userContactNo = userContactNo;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpatedOn() {
		return upatedOn;
	}

	public void setUpatedOn(Date upatedOn) {
		this.upatedOn = upatedOn;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Long getProjectUserId() {
		return projectUserId;
	}

	public void setProjectUserId(Long projectUserId) {
		this.projectUserId = projectUserId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getCompleteName() {
		return completeName;
	}

	public void setCompleteName(String completeName) {
		this.completeName = completeName;
	}

	public String getUserRoleName() {
		return userRoleName;
	}

	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}

	public Boolean getIsUserTimesheetApproved() {
		return isUserTimesheetApproved;
	}

	public void setIsUserTimesheetApproved(Boolean isUserTimesheetApproved) {
		this.isUserTimesheetApproved = isUserTimesheetApproved;
	}

	public String getSsnNumber() {
		return ssnNumber;
	}

	public void setSsnNumber(String ssnNumber) {
		this.ssnNumber = ssnNumber;
	}

	public String getUserRoleDescription() {
		return userRoleDescription;
	}

	public void setUserRoleDescription(String userRoleDescription) {
		this.userRoleDescription = userRoleDescription;
	}

	public Long getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(Long employmentType) {
		this.employmentType = employmentType;
	}

	public String getUserActivateDate() {
		return userActivateDate;
	}

	public void setUserActivateDate(String userActivateDate) {
		this.userActivateDate = userActivateDate;
	}

	public String getUserDeactivateDate() {
		return userDeactivateDate;
	}

	public void setUserDeactivateDate(String userDeactivateDate) {
		this.userDeactivateDate = userDeactivateDate;
	}

	public String getProjectEndDate() {
		return projectEndDate;
	}

	public void setProjectEndDate(String projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public boolean isUserStatusBoolean() {
		return userStatusBoolean;
	}

	public void setUserStatusBoolean(boolean userStatusBoolean) {
		this.userStatusBoolean = userStatusBoolean;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Long getUserContextId() {
		return userContextId;
	}

	public void setUserContextId(Long userContextId) {
		this.userContextId = userContextId;
	}

	public String getRoProjectName() {
		return roProjectName;
	}

	public void setRoProjectName(String roProjectName) {
		this.roProjectName = roProjectName;
	}

	@Override
	public String toString() {
		return "UserTO [id=" + id + ", userName=" + userName + ", firstName=" + firstName 
				+ ", completeName=" + completeName + ", lastName="
				+ lastName + ", password=" + password + ", userEmailId=" + userEmailId + ", userContactNo=" + userContactNo
				+ ", designation=" + designation + ", userRoleId=" + userRoleId + ", userRoleName=" + userRoleName + ", createdOn="
				+ createdOn + ", createdBy=" + createdBy + ", upatedOn=" + upatedOn + ", updatedBy=" + updatedBy + ", ssnNumber="
				+ ssnNumber + ", projectUserId=" + projectUserId + ", projectId=" + projectId + ", isUserTimesheetApproved="
				+ isUserTimesheetApproved + ", userActivateDate=" + userActivateDate + ", userDeactivateDate=" + userDeactivateDate
				+ ", projectName=" + projectName + ", projectEndDate=" + projectEndDate + ", isAdmin=" + isAdmin + "]";
	}

	/**
	 * @return the customCreationDate
	 */
	public String getCustomCreationDate() {
		return customCreationDate;
	}

	/**
	 * @param customCreationDate the customCreationDate to set
	 */
	public void setCustomCreationDate(String customCreationDate) {
		this.customCreationDate = customCreationDate;
	}

}
