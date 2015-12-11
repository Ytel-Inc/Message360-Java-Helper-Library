package com.M360.api.domain.email;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Invalid {
	@JsonProperty(value="InvalidEmailAddress")
	private List<EmailAddress> invalid=null;//For Listing
	
	public Invalid(){
		super();
		invalid =new ArrayList<EmailAddress>();
	}

	public List<EmailAddress> getInvalid() {
		return invalid;
	}

	public void setInvalid(List<EmailAddress> invalid) {
		this.invalid = invalid;
	}
}
