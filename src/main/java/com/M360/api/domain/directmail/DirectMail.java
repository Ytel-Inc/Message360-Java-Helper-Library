package com.M360.api.domain.directmail;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.M360.api.domain.BaseMessage360Object;
import com.M360.api.json.JsonDateParser;

public class DirectMail extends BaseMessage360Object{

	@JsonProperty(value="Id")
	private String id = null;
	@JsonProperty(value="Description")
	private String description = null;
	@JsonProperty(value="Name")
	private String name = null;
	@JsonProperty(value="City")
	private String city = null;
	@JsonProperty(value="Zip")
	private String zip = null;
	@JsonProperty(value="Country")
	private String country = null;
	@JsonProperty(value="Price")
	private String price = null;
	
	@JsonDeserialize(using = JsonDateParser.class)
	@JsonProperty(value="DateModified")
	private Date dateModified = null;
	@JsonDeserialize(using = JsonDateParser.class)
	@JsonProperty(value="ExpectedDeliveryDate")
	private Date expectedDeliveryDate = null;
	
	public DirectMail(){
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	public Date getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}

	public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}
	
}
