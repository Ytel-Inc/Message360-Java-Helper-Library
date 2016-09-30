package com.M360.api.domain.email;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Blocked {
	
	@JsonProperty(value="BlockedEmailAddresses")
	private List<EmailAddress> blockedEmailAddresses=null;
	@JsonProperty(value="BlockedEmailAddress")
	private EmailAddress blockedEmailAddres=null;
	
	public Blocked(){
		super();
		blockedEmailAddresses = new ArrayList<EmailAddress>();
		blockedEmailAddres =  new EmailAddress();
	}

	public List<EmailAddress> getBlockedEmailAddresses() {
		return blockedEmailAddresses;
	}

	public void setBlockedEmailAddresses(List<EmailAddress> blockedEmailAddresses) {
		this.blockedEmailAddresses = blockedEmailAddresses;
	}

	public EmailAddress getBlockedEmailAddres() {
		return blockedEmailAddres;
	}

	public void setBlockedEmailAddres(EmailAddress blockedEmailAddres) {
		this.blockedEmailAddres = blockedEmailAddres;
	}
	
}
