package com.M360.api.domain.SMS;

import org.codehaus.jackson.annotate.JsonProperty;

public class OptIn extends Message{
	@JsonProperty(value="ReqId")
	private String reqId=null;
	@JsonProperty(value="Expires")
	private Integer expires=null;
	@JsonProperty(value="AuthBy")
	private String authBy=null;
	@JsonProperty(value="AuthHow")
	private String authHow=null;
	@JsonProperty(value="Price")
	private String price=null;
	
	public OptIn(){
		super();
	}

	public String getReqId() {
		return reqId;
	}

	public void setReqId(String reqId) {
		this.reqId = reqId;
	}

	public Integer getExpires() {
		return expires;
	}

	public void setExpires(Integer expires) {
		this.expires = expires;
	}

	public String getAuthBy() {
		return authBy;
	}

	public void setAuthBy(String authBy) {
		this.authBy = authBy;
	}

	public String getAuthHow() {
		return authHow;
	}

	public void setAuthHow(String authHow) {
		this.authHow = authHow;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
	
	
}
