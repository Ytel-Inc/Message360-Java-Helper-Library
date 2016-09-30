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
	@JsonProperty(value="Letter")
	private Integer letters =null;
	@JsonProperty(value="Objects")
	private Integer objects =null;
	@JsonProperty(value="PostCard")
	private Integer postcard =null;
	@JsonProperty(value="Transcriptions")
	private Long transcriptions =null;
	@JsonProperty(value="TimeZone")
	private String timeZone =null;
	@JsonProperty(value="OptinSMS")
	private Integer optinSMS =null;
	@JsonProperty(value="CarrierLookUp")
	private Integer carrierLookUp =null;
	@JsonProperty(value="NumberPurchased")
	private Integer numberPurchased =null;
	@JsonProperty(value="VerifiedAddresses")
	private Integer verifiedAddresses =null;
	@JsonProperty(value="Conference")
	private Integer conference =null;
	
	public Account(){
		
	}
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
	public Integer getOptinSMS() {
		return optinSMS;
	}
	public void setOptinSMS(Integer optinSMS) {
		this.optinSMS = optinSMS;
	}
	public Integer getCarrierLookUp() {
		return carrierLookUp;
	}
	public void setCarrierLookUp(Integer carrierLookUp) {
		this.carrierLookUp = carrierLookUp;
	}
	public Integer getConference() {
		return conference;
	}
	public void setConference(Integer conference) {
		this.conference = conference;
	}
	public Integer getNumberPurchased() {
		return numberPurchased;
	}
	public void setNumberPurchased(Integer numberPurchased) {
		this.numberPurchased = numberPurchased;
	}
	public Integer getVerifiedAddresses() {
		return verifiedAddresses;
	}
	public void setVerifiedAddresses(Integer verifiedAddresses) {
		this.verifiedAddresses = verifiedAddresses;
	}
	
}
