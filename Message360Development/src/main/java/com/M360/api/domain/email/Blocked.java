/**
 * Provides a basic Blocked Email Address POJO implementation of "EMAIL" Module.
 * @see Blocked
 * @version v1b
 * @author Ytel-Inc
 * @date November 2015
 */
package com.M360.api.domain.email;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Blocked {
	
	@JsonProperty(value="BlockedEmailAddress")
	private List<EmailAddress> blocked=null;
	
	public Blocked(){
		super();
		blocked =new ArrayList<EmailAddress>();
	}

	public List<EmailAddress> getBlocked() {
		return blocked;
	}

	public void setBlocked(List<EmailAddress> blocked) {
		this.blocked = blocked;
	}
}
