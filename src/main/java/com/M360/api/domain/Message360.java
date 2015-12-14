/**
 * 
 * Common Generic Message360 Responses class 
 * 
 * @version v1b
 * @author Ytel-Inc
 * @date November 2015
 * 
 */
package com.M360.api.domain;

import org.codehaus.jackson.annotate.JsonProperty;


public class Message360<T> {
	@JsonProperty(value = "Message360")
	private T message360;
	
	public Message360() {
		super();
		// TODO Auto-generated constructor stub
	}
	public T getMessage360() {
		return message360;
	}
	public void setMessage360(T message360) {
		this.message360 = message360;
	}

	@Override
	public String toString() {
		return "Message360 [message360=" + message360 + "]";
	}
	
}
