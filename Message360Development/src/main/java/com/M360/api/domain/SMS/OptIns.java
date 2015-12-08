/**
 * Provides a basic Optins Email Address POJO implementation of "EMAIL" Module.
 * @see Blocked
 * @version v1b
 * @author Ytel-Inc
 * @date November 2015
 */

package com.M360.api.domain.SMS;

import org.codehaus.jackson.annotate.JsonProperty;

public class OptIns {
	
	@JsonProperty(value="OptIn")
	private OptIn optIn=null;
	
	public OptIns(){
		super();
		optIn = new OptIn();
	}

	public OptIn getOptIn() {
		return optIn;
	}

	public void setOptIn(OptIn optIn) {
		this.optIn = optIn;
	}
}
