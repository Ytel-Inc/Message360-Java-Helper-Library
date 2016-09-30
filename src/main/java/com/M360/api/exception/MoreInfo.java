package com.M360.api.exception;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class MoreInfo {
	@JsonProperty(value = "Invalid")
	private List<String> invalid=null;
	@JsonProperty(value = "InvalidateSid")
	private String invalidateSid=null;
	@JsonProperty(value = "BccInvalideEmail")
	private List<String> bccInvalideEmail=null;
	
	public MoreInfo(){
		super();
		invalid =new ArrayList<String>();
		bccInvalideEmail = new ArrayList<String>();
	}

	public List<String> getToInvalideEmail() {
		return invalid;
	}

	public void setToInvalideEmail(List<String> invalid) {
		this.invalid = invalid;
	}

	

	public String getInvalidateSid() {
		return invalidateSid;
	}

	public void setInvalidateSid(String invalidateSid) {
		this.invalidateSid = invalidateSid;
	}

	@Override
	public String toString() {
		return "[Invalid=" + invalid + "]";
	}

	public List<String> getBccInvalideEmail() {
		return bccInvalideEmail;
	}

	public void setBccInvalideEmail(List<String> bccInvalideEmail) {
		this.bccInvalideEmail = bccInvalideEmail;
	}
	
}
