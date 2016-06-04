package com.agreeya.chhs.request;

/**
 * 
 */
public class UserLogoutRequest extends AbstractRequiresUserContext implements WSRequest {

	@Override
	public ValidationResult validate() {
		ValidationResult vr = new ValidationResult();
		return vr;
	}

}
