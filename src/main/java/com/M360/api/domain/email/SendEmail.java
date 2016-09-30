package com.M360.api.domain.email;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.M360.api.domain.BaseMessage360Object;
import com.M360.api.json.JsonDateParser;

public class SendEmail extends BaseMessage360Object{
	
	@JsonProperty(value="EmailSid")
	private String emailSid=null;
	@JsonProperty(value="SentEmails")
	private String sentEmails=null;
	@JsonProperty(value="Cc")
	private List<String> cc = null;
	@JsonProperty(value="Bcc")
	private List<String> bcc = null;
	@JsonDeserialize(using = JsonDateParser.class)
	@JsonProperty(value="Date")
	private Date date=null;
	@JsonProperty(value="Subject")
	private String subject=null;
	@JsonProperty(value="TotalEmailSent")
	private Integer totalEmailSent=null;
	@JsonProperty(value="TotalPrize")
	private Double totalPrize=null;
	
	public SendEmail(){
		cc = new ArrayList<String>();
		bcc = new ArrayList<String>();
		
	}
	
	public String getEmailSid() {
		return emailSid;
	}

	public void setEmailSid(String emailSid) {
		this.emailSid = emailSid;
	}

	public String getSentEmails() {
		return sentEmails;
	}
	public void setSentEmails(String sentEmails) {
		this.sentEmails = sentEmails;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Integer getTotalEmailSent() {
		return totalEmailSent;
	}
	public void setTotalEmailSent(Integer totalEmailSent) {
		this.totalEmailSent = totalEmailSent;
	}
	public Double getTotalPrize() {
		return totalPrize;
	}
	public void setTotalPrize(Double totalPrize) {
		this.totalPrize = totalPrize;
	}

	public List<String> getCc() {
		return cc;
	}

	public void setCc(List<String> cc) {
		this.cc = cc;
	}

	public List<String> getBcc() {
		return bcc;
	}

	public void setBcc(List<String> bcc) {
		this.bcc = bcc;
	}
	
}
