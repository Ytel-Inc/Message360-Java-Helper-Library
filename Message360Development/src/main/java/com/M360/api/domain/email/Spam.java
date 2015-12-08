/**
 * Provides a basic Spam Email Address POJO implementation of "EMAIL" Module.
 * @see spam
 * @version v1b
 * @author Ytel-Inc
 * @date November 2015
 */

package com.M360.api.domain.email;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Spam {
	@JsonProperty(value="SpamReport")
	private List<EmailAddress> spam=null;//for listUnsubscribe
	
	public Spam(){
		super();
		spam =new ArrayList<EmailAddress>();
	}

	public List<EmailAddress> getSpam() {
		return spam;
	}

	public void setSpam(List<EmailAddress> spam) {
		this.spam = spam;
	}
}
