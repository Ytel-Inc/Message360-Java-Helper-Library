package com.M360.api.requests;


import com.M360.api.domain.enums.HttpMethod;


public class IncomingPhoneNumberRequest {
	private String accountSid;
	private String incomingPhoneNumberSid;
	private String friendlyName;
	private String voiceUrl;
	private HttpMethod voiceMethod;
	private String voiceFallbackUrl;
	private HttpMethod voiceFallbackMethod;
	private String smsUrl;
	private HttpMethod smsMethod;
	private String smsFallbackUrl;
	private HttpMethod smsFallbackMethod;
	private String hangupCallback;
	private HttpMethod hangupCallbackMethod;
	private String heartbeatUrl;
	private HttpMethod heartbeatMethod;
	private String phoneNumber = null;
	
	public String getAccountSid() {
		return accountSid;
	}
	public void setAccountSid(String accountSid) {
		this.accountSid = accountSid;
	}
	public String getIncomingPhoneNumberSid() {
		return incomingPhoneNumberSid;
	}
	public void setIncomingPhoneNumberSid(String incomingPhoneNumberSid) {
		this.incomingPhoneNumberSid = incomingPhoneNumberSid;
	}
	public String getFriendlyName() {
		return friendlyName;
	}
	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}
	public String getVoiceUrl() {
		return voiceUrl;
	}
	public void setVoiceUrl(String voiceUrl) {
		this.voiceUrl = voiceUrl;
	}
	public HttpMethod getVoiceMethod() {
		return voiceMethod;
	}
	public void setVoiceMethod(HttpMethod voiceMethod) {
		this.voiceMethod = voiceMethod;
	}
	public String getVoiceFallbackUrl() {
		return voiceFallbackUrl;
	}
	public void setVoiceFallbackUrl(String voiceFallbackUrl) {
		this.voiceFallbackUrl = voiceFallbackUrl;
	}
	public HttpMethod getVoiceFallbackMethod() {
		return voiceFallbackMethod;
	}
	public void setVoiceFallbackMethod(HttpMethod voiceFallbackMethod) {
		this.voiceFallbackMethod = voiceFallbackMethod;
	}
	
	public String getSmsUrl() {
		return smsUrl;
	}
	public void setSmsUrl(String smsUrl) {
		this.smsUrl = smsUrl;
	}
	public HttpMethod getSmsMethod() {
		return smsMethod;
	}
	public void setSmsMethod(HttpMethod smsMethod) {
		this.smsMethod = smsMethod;
	}
	public String getSmsFallbackUrl() {
		return smsFallbackUrl;
	}
	public void setSmsFallbackUrl(String smsFallbackUrl) {
		this.smsFallbackUrl = smsFallbackUrl;
	}
	public HttpMethod getSmsFallbackMethod() {
		return smsFallbackMethod;
	}
	public void setSmsFallbackMethod(HttpMethod smsFallbackMethod) {
		this.smsFallbackMethod = smsFallbackMethod;
	}
	public String getHangupCallback() {
		return hangupCallback;
	}
	public void setHangupCallback(String hangupCallback) {
		this.hangupCallback = hangupCallback;
	}
	public HttpMethod getHangupCallbackMethod() {
		return hangupCallbackMethod;
	}
	public void setHangupCallbackMethod(HttpMethod hangupCallbackMethod) {
		this.hangupCallbackMethod = hangupCallbackMethod;
	}
	public String getHeartbeatUrl() {
		return heartbeatUrl;
	}
	public void setHeartbeatUrl(String heartbeatUrl) {
		this.heartbeatUrl = heartbeatUrl;
	}
	public HttpMethod getHeartbeatMethod() {
		return heartbeatMethod;
	}
	public void setHeartbeatMethod(HttpMethod heartbeatMethod) {
		this.heartbeatMethod = heartbeatMethod;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
