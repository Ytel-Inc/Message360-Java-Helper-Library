package com.M360.api.domain.email;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Invalid {
	@JsonProperty(value="InvalidEmailAddresses")
	private List<EmailAddress> invalidEmailAddresses=null;
	@JsonProperty(value="InvalidEmailAddress")
	private EmailAddress invalidEmailAddress=null;
	
	public Invalid(){
		super();
		invalidEmailAddress = new EmailAddress();
		invalidEmailAddresses =  new ArrayList<EmailAddress>();
	}

	public List<EmailAddress> getInvalidEmailAddresses() {
		return invalidEmailAddresses;
	}
	public void setInvalidEmailAddresses(List<EmailAddress> invalidEmailAddresses) {
		this.invalidEmailAddresses = invalidEmailAddresses;
	}

	public EmailAddress getInvalidEmailAddress() {
		return invalidEmailAddress;
	}
	public void setInvalidEmailAddress(EmailAddress invalidEmailAddress) {
		this.invalidEmailAddress = invalidEmailAddress;
	}

	

	
}
