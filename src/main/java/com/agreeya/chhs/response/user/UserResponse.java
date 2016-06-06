/**
 * 
 */
package com.agreeya.chhs.response.user;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.agreeya.chhs.response.WSResponse;
import com.agreeya.chhs.to.UserTO;

/**
 * Response object for User Response 
 * @author AgreeYa Solutions
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UserResponse extends WSResponse {

	private Long id;
	private UserTO userTO;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserTO getUserTO() {
		return userTO;
	}

	public void setUserTO(UserTO userTO) {
		this.userTO = userTO;
	}

}
