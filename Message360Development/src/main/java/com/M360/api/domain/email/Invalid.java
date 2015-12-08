/**
 * Provides a basic Invalid Email Address POJO implementation of "EMAIL" Module.
 * @see Invalid
 * @version v1b
 * @author Ytel-Inc
 * @date November 2015
 */

package com.M360.api.domain.email;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Invalid {
	
	@JsonProperty(value="InvalidEmailAddress")
	private List<EmailAddress> invalid=null;
	
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
