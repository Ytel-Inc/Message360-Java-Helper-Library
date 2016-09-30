package com.M360.api.domain.email;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Bounce {
	
	@JsonProperty(value="BouncedEmailAddresses")
	private List<EmailAddress> bouncedEmailAddresses=null;
	@JsonProperty(value="BouncedEmailAddress")
	private EmailAddress bouncedEmailAddress=null;
	
	public Bounce(){
		super();
		bouncedEmailAddress = new  EmailAddress();
		bouncedEmailAddresses = new ArrayList<EmailAddress>();
	}

	public List<EmailAddress> getBouncedEmailAddresses() {
		return bouncedEmailAddresses;
	}

	public void setBouncedEmailAddresses(List<EmailAddress> bouncedEmailAddresses) {
		this.bouncedEmailAddresses = bouncedEmailAddresses;
	}

	public EmailAddress getBouncedEmailAddress() {
		return bouncedEmailAddress;
	}
	public void setBouncedEmailAddress(EmailAddress bouncedEmailAddress) {
		this.bouncedEmailAddress = bouncedEmailAddress;
	}

	
}
