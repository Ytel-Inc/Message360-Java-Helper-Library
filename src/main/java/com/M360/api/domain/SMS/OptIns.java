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
