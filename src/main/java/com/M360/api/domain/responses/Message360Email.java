package com.M360.api.domain.responses;

import org.codehaus.jackson.annotate.JsonProperty;

import com.M360.api.exception.Message360Exception;

public class Message360Email<T> extends Message360Exception{
	
	@JsonProperty(value="ResponseStatus")
	private Integer ResponseStatus=null;
	@JsonProperty(value="EmailCount")
	private Integer emailCount;
	@JsonProperty(value="Email")
	private T email=null;
	
	public Integer getResponseStatus() {
		return ResponseStatus;
	}

	public void setResponseStatus(Integer responseStatus) {
		ResponseStatus = responseStatus;
	}

	public T getEmail() {
		return email;
	}

	public void setEmail(T email) {
		this.email = email;
	}

	public Integer getEmailCount() {
		return emailCount;
	}

	public void setEmailCount(Integer emailCount) {
		this.emailCount = emailCount;
	}

}
