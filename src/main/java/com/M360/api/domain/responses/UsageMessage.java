package com.M360.api.domain.responses;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.M360.api.domain.usage.Usage;
import com.M360.api.exception.Message360Exception;

public class UsageMessage extends Message360Exception{
	
	@JsonProperty(value = "ResponseStatus")
	private Integer responseStatus =null;
	
	@JsonProperty(value = "Usage")
	private List<Usage> usage=null;
	
	public UsageMessage() {
		super();
		usage =new ArrayList<Usage>();
	}

	public Integer getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(Integer responseStatus) {
		this.responseStatus = responseStatus;
	}

	public List<Usage> getUsage() {
		return usage;
	}

	public void setUsage(List<Usage> usage) {
		this.usage = usage;
	}
	
	
	
}
