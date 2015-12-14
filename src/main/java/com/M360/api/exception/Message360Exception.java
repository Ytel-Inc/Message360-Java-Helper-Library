package com.M360.api.exception;

import org.codehaus.jackson.annotate.JsonProperty;

public class Message360Exception {
	
	@JsonProperty(value = "Errors")
	private Errors errors=null;
	public Message360Exception(){
		super();
		errors=new Errors();
	}
	
	
	public Errors getErrors() {
		return errors;
	}

	public void setErrors(Errors errors) {
		this.errors = errors;
	}
	
}
