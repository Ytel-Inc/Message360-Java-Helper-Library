package com.M360.api.domain.directmail.postcard;

import org.codehaus.jackson.annotate.JsonProperty;

import com.M360.api.domain.directmail.DirectMail;

public class PostCardDetails extends DirectMail{
	
	@JsonProperty(value="Front")
	private String front = null;
	@JsonProperty(value="Back")
	private String back = null;
	@JsonProperty(value="Message")
	private String message = null;
	
	public PostCardDetails(){
		
	}

	public String getFront() {
		return front;
	}

	public void setFront(String front) {
		this.front = front;
	}

	public String getBack() {
		return back;
	}

	public void setBack(String back) {
		this.back = back;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
