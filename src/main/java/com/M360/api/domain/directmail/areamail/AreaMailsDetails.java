package com.M360.api.domain.directmail.areamail;

import org.codehaus.jackson.annotate.JsonProperty;

import com.M360.api.domain.directmail.DirectMail;

public class AreaMailsDetails  extends DirectMail{
	
	@JsonProperty(value="TargetType")
	private String targetType = null;
	
	public AreaMailsDetails(){
	}

	public String getTargetType() {
		return targetType;
	}

	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}
	
}
