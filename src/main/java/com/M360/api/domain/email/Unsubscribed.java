package com.M360.api.domain.email;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Unsubscribed {
	
	@JsonProperty(value="UnsubscribedEmailAddresses")
	private List<EmailAddress> unsubscribedEmailAddresses=null;
	@JsonProperty(value="UnsubscribedEmailAddress")
	private EmailAddress unsubscribedEmailAddress=null;
	
	public Unsubscribed(){
		super();
		unsubscribedEmailAddresses =new ArrayList<EmailAddress>();
		unsubscribedEmailAddress =new EmailAddress();
	}

	public List<EmailAddress> getUnsubscribedEmailAddresses() {
		return unsubscribedEmailAddresses;
	}

	public void setUnsubscribedEmailAddresses(List<EmailAddress> unsubscribedEmailAddresses) {
		this.unsubscribedEmailAddresses = unsubscribedEmailAddresses;
	}

	public EmailAddress getUnsubscribedEmailAddress() {
		return unsubscribedEmailAddress;
	}

	public void setUnsubscribedEmailAddress(EmailAddress unsubscribedEmailAddress) {
		this.unsubscribedEmailAddress = unsubscribedEmailAddress;
	}

}
