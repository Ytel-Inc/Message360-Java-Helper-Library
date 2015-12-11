package com.M360.api.domain.email;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Unsubscribed {
	
	@JsonProperty(value="UnsubscribedEmailAddress")
	private List<EmailAddress> unsubscribed=null;
	
	public Unsubscribed(){
		super();
		unsubscribed =new ArrayList<EmailAddress>();
	}

	public List<EmailAddress> getUnsubscribed() {
		return unsubscribed;
	}

	public void setUnsubscribed(List<EmailAddress> unsubscribed) {
		this.unsubscribed = unsubscribed;
	}
	
}
