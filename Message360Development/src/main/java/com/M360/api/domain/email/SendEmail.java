/**
 * Provides a basic Send Email Address POJO implementation of "EMAIL" Module.
 * @see SendEmail
 * @version v1b
 * @author Ytel-Inc
 * @date November 2015
 */

package com.M360.api.domain.email;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.M360.api.domain.BaseMessage360Object;
import com.M360.api.json.JsonDateParser;

public class SendEmail extends BaseMessage360Object{
	
	@JsonProperty(value="Sid")
	private String sid=null;
	@JsonProperty(value="SentEmails")
	private String sentEmails=null;
	@JsonDeserialize(using = JsonDateParser.class)
	@JsonProperty(value="Date")
	private Date date=null;
	@JsonProperty(value="Subject")
	private String subject=null;
	@JsonProperty(value="TotalEmailSent")
	private Integer totalEmailSent=null;
	@JsonProperty(value="TotalPrize")
	private Double totalPrize=null;
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
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	
}
