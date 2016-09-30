package com.M360.api.carrier;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.M360.api.domain.BaseMessage360Object;
import com.M360.api.json.JsonDateParser;

public class Carrier extends BaseMessage360Object{
	@JsonProperty(value="CarrierSid")
	private String carrierSid=null;
	@JsonProperty(value="Network")
	private String network=null;
	@JsonProperty(value="Wireless")
	private String wireless=null;
	@JsonProperty(value="ZipCode")
	private String zipCode=null;
	@JsonProperty(value="City")
	private String city=null;
	@JsonProperty(value="Price")
	private Double price=null;
	@JsonDeserialize(using = JsonDateParser.class)//REMOVE once done on production
	@JsonProperty(value="CreatedDate")
	private Date CreatedDate=null;
	@JsonProperty(value="PhoneNumber")
	private String phoneNumber =null;
	
	
	
	public String getCarrierSid() {
		return carrierSid;
	}
	public void setCarrierSid(String carrierSid) {
		this.carrierSid = carrierSid;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	public String getWireless() {
		return wireless;
	}
	public void setWireless(String wireless) {
		this.wireless = wireless;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getCreatedDate() {
		return CreatedDate;
	}
	public void setCreatedDate(Date createdDate) {
		CreatedDate = createdDate;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
}
