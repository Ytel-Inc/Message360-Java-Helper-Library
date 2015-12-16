package com.M360.api.domain.SMS;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.M360.api.domain.BaseMessage360Object;
import com.M360.api.json.JsonDateParser;

public class Message extends BaseMessage360Object{
	
	@JsonProperty(value="Body")
	private String body=null;
	@JsonProperty(value="MessagePrice")
	private String messagePrice=null;
	@JsonDeserialize(using = JsonDateParser.class)
	@JsonProperty(value="DateSent")
	private Date dateSent=null;
	@JsonDeserialize(using = JsonDateParser.class)
	@JsonProperty(value="DateReceived")
	private Date dateReceived=null;
	@JsonProperty(value="StatusCallBackMethod")
	private String statusCallBackMethod=null;
	@JsonProperty(value="MessageStatusCallback")
	private String messageStatusCallback=null;
	@JsonDeserialize(using = JsonDateParser.class)
	@JsonProperty(value="Date")
	private Date date=null;
	
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getMessagePrice() {
		return messagePrice;
	}
	public void setMessagePrice(String messagePrice) {
		this.messagePrice = messagePrice;
	}
	public Date getDateSent() {
		return dateSent;
	}
	public void setDateSent(Date dateSent) {
		this.dateSent = dateSent;
	}
	public Date getDateReceived() {
		return dateReceived;
	}
	public void setDateReceived(Date dateReceived) {
		this.dateReceived = dateReceived;
	}
	public String getStatusCallBackMethod() {
		return statusCallBackMethod;
	}
	public void setStatusCallBackMethod(String statusCallBackMethod) {
		this.statusCallBackMethod = statusCallBackMethod;
	}
	public String getMessageStatusCallback() {
		return messageStatusCallback;
	}
	public void setMessageStatusCallback(String messageStatusCallback) {
		this.messageStatusCallback = messageStatusCallback;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
