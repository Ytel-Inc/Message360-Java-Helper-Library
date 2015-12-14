package com.M360.api.domain.phonenumber;

import org.codehaus.jackson.annotate.JsonProperty;

public class Price {
	@JsonProperty(value="InboundCallPrice")
	private String inboundCallPrice = null;
	@JsonProperty(value="OutboundCallPrice")
	private String outboundCallPrice = null;
	@JsonProperty(value="InboundSMSPrice")
	private String inboundSMSPrice = null;
	@JsonProperty(value="OutboundSMSPrice")
	private String outboundSMSPrice = null;
	
	public Price(){
		super();
	}

	public String getInboundCallPrice() {
		return inboundCallPrice;
	}

	public void setInboundCallPrice(String inboundCallPrice) {
		this.inboundCallPrice = inboundCallPrice;
	}

	public String getOutboundCallPrice() {
		return outboundCallPrice;
	}

	public void setOutboundCallPrice(String outboundCallPrice) {
		this.outboundCallPrice = outboundCallPrice;
	}

	public String getInboundSMSPrice() {
		return inboundSMSPrice;
	}

	public void setInboundSMSPrice(String inboundSMSPrice) {
		this.inboundSMSPrice = inboundSMSPrice;
	}

	public String getOutboundSMSPrice() {
		return outboundSMSPrice;
	}

	public void setOutboundSMSPrice(String outboundSMSPrice) {
		this.outboundSMSPrice = outboundSMSPrice;
	}
	
	
	
}
