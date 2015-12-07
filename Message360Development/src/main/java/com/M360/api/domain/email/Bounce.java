package com.M360.api.domain.email;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Bounce {
	@JsonProperty(value="BouncedEmailAddress")
	private List<EmailAddress> bounce=null;
	
	public Bounce(){
		super();
		bounce =new ArrayList<EmailAddress>();
	}

	public List<EmailAddress> getBounce() {
		return bounce;
	}

	public void setBounce(List<EmailAddress> unsubscribed) {
		this.bounce = unsubscribed;
	}
}
