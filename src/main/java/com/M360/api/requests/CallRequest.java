package com.M360.api.requests;

import com.M360.api.domain.enums.HttpMethod;

public class CallRequest {
	
	private String accountSid = null;
	private Integer fromCountryCode = null;
	private String from = null;
	private Integer toCountryCode = null;
	private String to = null;
	private String url = null;
	private HttpMethod method = null;
	private String statusCallback = null;
	private HttpMethod StatusCallbackMethod = null;
	private String fallbackUrl = null;
	private HttpMethod fallbackMethod = null;
	private String heartbeatUrl = null;
	private HttpMethod heartbeatMethod = null;
	private String forwardedFrom = null;
	private Long timeout = null;
	private String playDtmf = null;
	private Boolean hideCallerId = null;
	private Boolean record = null;
	private Integer recordCallback = null;
	private HttpMethod recordCallbackMethod = null;
	private Boolean transcribe = null;
	private String transcribeQuality = null;
	private String straightToVoicemail = null;
	private String ifMachine = null;
	private String ifMachineUrl = null;
	private String ifMachineMethod = null;
	
	
	public String getAccountSid() {
		return accountSid;
	}
	public void setAccountSid(String accountSid) {
		this.accountSid = accountSid;
	}
	public Integer getFromCountryCode() {
		return fromCountryCode;
	}
	public void setFromCountryCode(Integer fromCountryCode) {
		this.fromCountryCode = fromCountryCode;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public Integer getToCountryCode() {
		return toCountryCode;
	}
	public void setToCountryCode(Integer toCountryCode) {
		this.toCountryCode = toCountryCode;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public HttpMethod getMethod() {
		return method;
	}
	public void setMethod(HttpMethod method) {
		this.method = method;
	}
	public String getStatusCallback() {
		return statusCallback;
	}
	public void setStatusCallback(String statusCallback) {
		this.statusCallback = statusCallback;
	}
	public HttpMethod getStatusCallbackMethod() {
		return StatusCallbackMethod;
	}
	public void setStatusCallbackMethod(HttpMethod statusCallbackMethod) {
		StatusCallbackMethod = statusCallbackMethod;
	}
	public String getFallbackUrl() {
		return fallbackUrl;
	}
	public void setFallbackUrl(String fallbackUrl) {
		this.fallbackUrl = fallbackUrl;
	}
	public HttpMethod getFallbackMethod() {
		return fallbackMethod;
	}
	public void setFallbackMethod(HttpMethod fallbackMethod) {
		this.fallbackMethod = fallbackMethod;
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
	public String getForwardedFrom() {
		return forwardedFrom;
	}
	public void setForwardedFrom(String forwardedFrom) {
		this.forwardedFrom = forwardedFrom;
	}
	public Long getTimeout() {
		return timeout;
	}
	public void setTimeout(Long timeout) {
		this.timeout = timeout;
	}
	public String getPlayDtmf() {
		return playDtmf;
	}
	public void setPlayDtmf(String playDtmf) {
		this.playDtmf = playDtmf;
	}
	public Boolean getHideCallerId() {
		return hideCallerId;
	}
	public void setHideCallerId(Boolean hideCallerId) {
		this.hideCallerId = hideCallerId;
	}
	public Boolean getRecord() {
		return record;
	}
	public void setRecord(Boolean record) {
		this.record = record;
	}
	public Integer getRecordCallback() {
		return recordCallback;
	}
	public void setRecordCallback(Integer recordCallback) {
		this.recordCallback = recordCallback;
	}
	public HttpMethod getRecordCallbackMethod() {
		return recordCallbackMethod;
	}
	public void setRecordCallbackMethod(HttpMethod recordCallbackMethod) {
		this.recordCallbackMethod = recordCallbackMethod;
	}
	public Boolean getTranscribe() {
		return transcribe;
	}
	public void setTranscribe(Boolean transcribe) {
		this.transcribe = transcribe;
	}
	public String getTranscribeQuality() {
		return transcribeQuality;
	}
	public void setTranscribeQuality(String transcribeQuality) {
		this.transcribeQuality = transcribeQuality;
	}
	public String getStraightToVoicemail() {
		return straightToVoicemail;
	}
	public void setStraightToVoicemail(String straightToVoicemail) {
		this.straightToVoicemail = straightToVoicemail;
	}
	public String getIfMachine() {
		return ifMachine;
	}
	public void setIfMachine(String ifMachine) {
		this.ifMachine = ifMachine;
	}
	public String getIfMachineUrl() {
		return ifMachineUrl;
	}
	public void setIfMachineUrl(String ifMachineUrl) {
		this.ifMachineUrl = ifMachineUrl;
	}
	public String getIfMachineMethod() {
		return ifMachineMethod;
	}
	public void setIfMachineMethod(String ifMachineMethod) {
		this.ifMachineMethod = ifMachineMethod;
	}
	
	

}
