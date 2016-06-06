package com.agreeya.chhs.request.user;

/**
 * Transfer Object class for User family Information
 * 
 * @author AgreeYa Solutions
 *
 */
public class UserLicenceDetails {

	private String agencyContact;
	private int agencyWorker;
	private String dateOfIssue;
	private String licenceNo;

	public UserLicenceDetails(String agencyContact, int agencyWorker, String dateOfIssue, String licenceNo) {
		super();
		this.agencyContact = agencyContact;
		this.agencyWorker = agencyWorker;
		this.dateOfIssue = dateOfIssue;
		this.licenceNo = licenceNo;
	}

	public String getAgencyContact() {
		return agencyContact;
	}

	public void setAgencyContact(String agencyContact) {
		this.agencyContact = agencyContact;
	}

	public int getAgencyWorker() {
		return agencyWorker;
	}

	public void setAgencyWorker(int agencyWorker) {
		this.agencyWorker = agencyWorker;
	}

	public String getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(String dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public String getLicenceNo() {
		return licenceNo;
	}

	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}

}
