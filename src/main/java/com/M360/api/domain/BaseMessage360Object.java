/**
 * A base resource object containing properties present in all of the other
 * resource objects.
 * @version v1b
 * @author Ytel-Inc
 * @date November 2015
 */

package com.M360.api.domain;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.M360.api.json.JsonDateParser;


public class BaseMessage360Object {
	@JsonProperty("MessageSid")
	private String sid;
	@JsonDeserialize(using = JsonDateParser.class)
	@JsonProperty(value="DateCreated")
	private Date dateCreated;
	@JsonDeserialize(using = JsonDateParser.class)
	@JsonProperty(value="date_updated")
	private Date dateUpdated;
	@JsonProperty(value="AccountSid")
	private String accountSid;
	@JsonProperty("ApiVersion")
	private String apiVersion;
	private String uri;
	@JsonProperty(value="Status")
	private String status =null;	
	@JsonProperty(value="Email")
	private String email =null;
	@JsonProperty(value="PhoneNumbers")
	private Long phoneNumbers =null;
	@JsonProperty(value="Address")
	private String address =null;
	@JsonDeserialize(using = JsonDateParser.class)
	@JsonProperty(value="DateUpdated")
	private Date dateAccountUpdated =null;
	@JsonProperty(value="From")
	private String from=null;
	@JsonProperty(value="To")
	private String to=null;
	
	
	/**
	 * 
	 * @return A unique identifier assigned to each resource.
	 */
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	
	/**
	 * 
	 * @return The date the resource was created.
	 */
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	/**
	 * 
	 * @return The date the resource was last updated.
	 */
	public Date getDateUpdated() {
		return dateUpdated;
	}
	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	
	/**
	 * 
	 * @return An alphanumeric string identifying the account this resource occurred in.
	 */
	public String getAccountSid() {
		return accountSid;
	}
	public void setAccountSid(String accountSid) {
		this.accountSid = accountSid;
	}
	
	/**
	 * 
	 * @return The API version being used when the resource was created.
	 */
	public String getApiVersion() {
		return apiVersion;
	}
	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}
	
	/**
	 * 
	 * @return The path appended to the base TelAPI URL, https://api.telapi.com,
	 *         where the resource is located.
	 */
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Long getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(Long phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Date getDateAccountUpdated() {
		return dateAccountUpdated;
	}
	public void setDateAccountUpdated(Date dateAccountUpdated) {
		this.dateAccountUpdated = dateAccountUpdated;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	
}
