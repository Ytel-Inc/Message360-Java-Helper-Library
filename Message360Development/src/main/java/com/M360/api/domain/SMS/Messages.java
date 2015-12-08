/**
 * Provides a basic Messages Address POJO implementation of "EMAIL" Module.
 * 
 * @see Messages
 * @version v1b
 * @author Ytel-Inc
 * @date November 2015
 */

package com.M360.api.domain.SMS;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;


public class Messages {
	@JsonProperty(value="Message")
	private List<Message> message = null;

	public Messages(){
		super();
		message=new ArrayList<Message>();
	}

	public List<Message> getMessage() {
		return message;
	}

	public void setMessage(List<Message> message) {
		this.message = message;
	}
	
}
