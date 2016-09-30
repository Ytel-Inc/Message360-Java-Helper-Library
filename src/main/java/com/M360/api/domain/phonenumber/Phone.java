package com.M360.api.domain.phonenumber;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.M360.api.domain.BaseMessage360Object;
import com.M360.api.json.JsonDateParser;

public class Phone extends BaseMessage360Object{
	@JsonProperty(value="PhoneNumber")
	private String phoneNumber = null;
	@JsonProperty(value="FriendlyName")
	private String friendlyName = null;
	@JsonProperty(value="AreaCode")
	private String areaCode = null;
	@JsonProperty(value="MonthlyCost")
	private String monthlyCost = null;
	@JsonProperty(value="VoiceEnabled")
	private String voiceEnabled ;
	@JsonProperty(value="SmsEnabled")
	private String smsEnabled;
	@JsonProperty(value="Price")
	private Price price=null;
	@JsonProperty(value="Sid")
	private String sid=null;
	@JsonProperty(value="PerMinuteCost")
	private Double perMinuteCost=null;
	
	@JsonProperty(value="VoiceApplicationSid")
	private String voiceApplicationSid = null;
	@JsonProperty(value="VoiceUrl")
	private String voiceUrl = null;
	@JsonProperty(value="VoiceMethod")
	private String voiceMethod = null;
	@JsonProperty(value="VoiceFallbackUrl")
	private String VoiceFallbackUrl = null;
	
	@JsonProperty(value="VoiceFallbackMethod")
	private String voiceFallbackMethod = null;
	@JsonProperty(value="VoiceCallerIdLookup")
	private String voiceCallerIdLookup = null;
	@JsonDeserialize(using = JsonDateParser.class)
	@JsonProperty(value="NextRenewalDate")
	private Date nextRenewalDate = null;
	@JsonProperty(value="SMSApplicationSid")
	private String smsApplicationSid = null;
	
	@JsonProperty(value="SMSUrl")
	private String smsUrl = null;
	@JsonProperty(value="SMSMethod")
	private String smsMethod = null;
	@JsonProperty(value="SMSFallbackUrl")
	private String smsFallbackUrl = null;
	@JsonProperty(value="SMSFallbackMethod")
	private String smsFallbackMethod = null;
	
	@JsonProperty(value="HeartbeatUrl")
	private String heartbeatUrl = null;
	@JsonProperty(value="HeartbeatMethod")
	private String heartbeatMethod = null;
	@JsonProperty(value="HangupCallback")
	private String hangupCallback = null;
	@JsonProperty(value="HangupCallbackMethod")
	private String hangupCallbackMethod = null;
	
	@JsonProperty(value="StatusCallback")
	private String statusCallback = null;
	@JsonProperty(value="StatusCallbackMethod")
	private String statusCallbackMethod = null;
	
	@JsonProperty(value="VoiceEnable")//Repeated
	private String voiceEnable ;
	@JsonProperty(value="SmsEnable")//REpeated
	private String smsEnable;
	
	@JsonProperty(value="IsoState")//REpeated
	private String isoState;
	
	@JsonProperty(value="PhoneSid")//REpeated
	private String phoneSid;
	@JsonDeserialize(using = JsonDateParser.class)
	@JsonProperty(value="Date")//REpeated
	private Date date;
	
	@JsonProperty(value="Message")//REpeated
	private String message;
	@JsonProperty(value="Region")//REpeated
	private String region;
	
	
	@JsonProperty(value="SMSRequestUrl")//REpeated
	private String smsRequestUrl;
	
	
	public Phone(){
		super();
		price=new Price();
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFriendlyName() {
		return friendlyName;
	}

	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getMonthlyCost() {
		return monthlyCost;
	}

	public void setMonthlyCost(String monthlyCost) {
		this.monthlyCost = monthlyCost;
	}

	public String getVoiceEnabled() {
		return voiceEnabled;
	}

	public void setVoiceEnabled(String voiceEnabled) {
		this.voiceEnabled = voiceEnabled;
	}

	public String getSmsEnabled() {
		return smsEnabled;
	}

	public void setSmsEnabled(String smsEnabled) {
		this.smsEnabled = smsEnabled;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public Double getPerMinuteCost() {
		return perMinuteCost;
	}

	public void setPerMinuteCost(Double perMinuteCost) {
		this.perMinuteCost = perMinuteCost;
	}

	public String getVoiceApplicationSid() {
		return voiceApplicationSid;
	}

	public void setVoiceApplicationSid(String voiceApplicationSid) {
		this.voiceApplicationSid = voiceApplicationSid;
	}

	public String getVoiceUrl() {
		return voiceUrl;
	}

	public void setVoiceUrl(String voiceUrl) {
		this.voiceUrl = voiceUrl;
	}

	public String getVoiceMethod() {
		return voiceMethod;
	}

	public void setVoiceMethod(String voiceMethod) {
		this.voiceMethod = voiceMethod;
	}

	public String getVoiceFallbackUrl() {
		return VoiceFallbackUrl;
	}

	public void setVoiceFallbackUrl(String voiceFallbackUrl) {
		VoiceFallbackUrl = voiceFallbackUrl;
	}

	public String getVoiceFallbackMethod() {
		return voiceFallbackMethod;
	}

	public void setVoiceFallbackMethod(String voiceFallbackMethod) {
		this.voiceFallbackMethod = voiceFallbackMethod;
	}

	public String getVoiceCallerIdLookup() {
		return voiceCallerIdLookup;
	}

	public void setVoiceCallerIdLookup(String voiceCallerIdLookup) {
		this.voiceCallerIdLookup = voiceCallerIdLookup;
	}

	public Date getNextRenewalDate() {
		return nextRenewalDate;
	}

	public void setNextRenewalDate(Date nextRenewalDate) {
		this.nextRenewalDate = nextRenewalDate;
	}

	public String getSmsApplicationSid() {
		return smsApplicationSid;
	}

	public void setSmsApplicationSid(String smsApplicationSid) {
		this.smsApplicationSid = smsApplicationSid;
	}

	public String getSmsUrl() {
		return smsUrl;
	}

	public void setSmsUrl(String smsUrl) {
		this.smsUrl = smsUrl;
	}

	public String getSmsMethod() {
		return smsMethod;
	}

	public void setSmsMethod(String smsMethod) {
		this.smsMethod = smsMethod;
	}

	public String getSmsFallbackUrl() {
		return smsFallbackUrl;
	}

	public void setSmsFallbackUrl(String smsFallbackUrl) {
		this.smsFallbackUrl = smsFallbackUrl;
	}

	public String getSmsFallbackMethod() {
		return smsFallbackMethod;
	}

	public void setSmsFallbackMethod(String smsFallbackMethod) {
		this.smsFallbackMethod = smsFallbackMethod;
	}

	public String getHeartbeatUrl() {
		return heartbeatUrl;
	}

	public void setHeartbeatUrl(String heartbeatUrl) {
		this.heartbeatUrl = heartbeatUrl;
	}

	public String getHeartbeatMethod() {
		return heartbeatMethod;
	}

	public void setHeartbeatMethod(String heartbeatMethod) {
		this.heartbeatMethod = heartbeatMethod;
	}

	public String getHangupCallback() {
		return hangupCallback;
	}

	public void setHangupCallback(String hangupCallback) {
		this.hangupCallback = hangupCallback;
	}

	public String getHangupCallbackMethod() {
		return hangupCallbackMethod;
	}

	public void setHangupCallbackMethod(String hangupCallbackMethod) {
		this.hangupCallbackMethod = hangupCallbackMethod;
	}

	public String getStatusCallback() {
		return statusCallback;
	}

	public void setStatusCallback(String statusCallback) {
		this.statusCallback = statusCallback;
	}

	public String getStatusCallbackMethod() {
		return statusCallbackMethod;
	}

	public void setStatusCallbackMethod(String statusCallbackMethod) {
		this.statusCallbackMethod = statusCallbackMethod;
	}

	public String getVoiceEnable() {
		return voiceEnable;
	}

	public void setVoiceEnable(String voiceEnable) {
		this.voiceEnable = voiceEnable;
	}

	public String getSmsEnable() {
		return smsEnable;
	}

	public void setSmsEnable(String smsEnable) {
		this.smsEnable = smsEnable;
	}

	public String getIsoState() {
		return isoState;
	}

	public void setIsoState(String isoState) {
		this.isoState = isoState;
	}

	public String getPhoneSid() {
		return phoneSid;
	}

	public void setPhoneSid(String phoneSid) {
		this.phoneSid = phoneSid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
	
	
}
