/**
 * 
 * Message360 Account Response Structure.
 * 
 * @version v1b
 * @author Ytel-Inc
 * @date November 2015
 * 
 */

package com.M360.api.domain.responses;

import org.codehaus.jackson.annotate.JsonProperty;

import com.M360.api.domain.account.Account;
import com.M360.api.exception.Message360Exception;

public class AccountMessage extends Message360Exception{
	
	@JsonProperty(value="ResponseStatus")
	private Integer responseStatus=null;
	
	@JsonProperty(value="Message")
	private Account message = null;
	
	public AccountMessage(){
		super();
		message = new Account();
	}
	
	public Account getAccountMessage() {
		return message;
	}

	public void setAccountMessage(Account message) {
		this.message = message;
	}

	public Integer getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(Integer responseStatus) {
		this.responseStatus = responseStatus;
	}
	
}
