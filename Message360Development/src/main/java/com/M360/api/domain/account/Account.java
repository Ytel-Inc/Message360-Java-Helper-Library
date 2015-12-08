/**
 * Provides a basic Account POJO implementation of Account Module.
 * @see Account
 * @version v1b
 * @author Ytel-Inc
 * @date November 2015
 */
package com.M360.api.domain.account;

import org.codehaus.jackson.annotate.JsonProperty;

import com.M360.api.domain.BaseMessage360Object;

public class Account extends BaseMessage360Object{
	
	@JsonProperty(value="AccountBalance")
	private String accountBalance =null;
	@JsonProperty(value="InboundCalls")
	private Long inboundCalls =null;
	@JsonProperty(value="OutboundCalls")
	private Long outboundCalls =null;
	@JsonProperty(value="InboundSMS")
	private Long inboundSMS =null;
	@JsonProperty(value="OutboundSMS")
	private Long outboundSMS =null;
	@JsonProperty(value="Areamail")
	private Long areamail =null;
	@JsonProperty(value="Checks")
	private Integer checks =null;
	@JsonProperty(value="Jobs")
	private Integer jobs =null;
	@JsonProperty(value="Letters")
	private Integer letters =null;
	@JsonProperty(value="Objects")
	private Integer objects =null;
	@JsonProperty(value="Postcard")
	private Integer postcard =null;
	@JsonProperty(value="Transcriptions")
	private Long transcriptions =null;
	@JsonProperty(value="TimeZone")
	private String timeZone =null;
	
	
	
	
	public String getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(String accountBalance) {
		this.accountBalance = accountBalance;
	}
	public Long getInboundCalls() {
		return inboundCalls;
	}
	public void setInboundCalls(Long inboundCalls) {
		this.inboundCalls = inboundCalls;
	}
	public Long getOutboundCalls() {
		return outboundCalls;
	}
	public void setOutboundCalls(Long outboundCalls) {
		this.outboundCalls = outboundCalls;
	}
	public Long getInboundSMS() {
		return inboundSMS;
	}
	public void setInboundSMS(Long inboundSMS) {
		this.inboundSMS = inboundSMS;
	}
	public Long getOutboundSMS() {
		return outboundSMS;
	}
	public void setOutboundSMS(Long outboundSMS) {
		this.outboundSMS = outboundSMS;
	}
	public Long getAreamail() {
		return areamail;
	}
	public void setAreamail(Long areamail) {
		this.areamail = areamail;
	}
	public Integer getChecks() {
		return checks;
	}
	public void setChecks(Integer checks) {
		this.checks = checks;
	}
	public Integer getJobs() {
		return jobs;
	}
	public void setJobs(Integer jobs) {
		this.jobs = jobs;
	}
	public Integer getLetters() {
		return letters;
	}
	public void setLetters(Integer letters) {
		this.letters = letters;
	}
	public Integer getObjects() {
		return objects;
	}
	public void setObjects(Integer objects) {
		this.objects = objects;
	}
	public Integer getPostcard() {
		return postcard;
	}
	public void setPostcard(Integer postcard) {
		this.postcard = postcard;
	}
	public Long getTranscriptions() {
		return transcriptions;
	}
	public void setTranscriptions(Long transcriptions) {
		this.transcriptions = transcriptions;
	}
	public String getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	
}
