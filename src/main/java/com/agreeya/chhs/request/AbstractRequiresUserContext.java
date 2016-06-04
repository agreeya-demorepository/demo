package com.agreeya.chhs.request;

import javax.validation.constraints.NotNull;

import com.agreeya.chhs.to.UserContextTO;


/**
 * @author amit.sharma
 *
 */
public abstract class AbstractRequiresUserContext {
	
	@NotNull
	public UserContextTO userContext;
	
	public UserContextTO getUserContext() {
		return userContext;
	}

	public void setUserContext(UserContextTO userContext) {
		this.userContext = userContext;
	}

}
