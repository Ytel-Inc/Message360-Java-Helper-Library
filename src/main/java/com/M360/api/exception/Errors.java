package com.M360.api.exception;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Errors {
	@JsonProperty(value = "Error")
	private List<Error> error=null;

	public Errors(){
		super();
		error = new ArrayList<Error>();
	}
	public List<Error> getError() {
		return error;
	}

	public void setError(List<Error> error) {
		this.error = error;
	}
}
