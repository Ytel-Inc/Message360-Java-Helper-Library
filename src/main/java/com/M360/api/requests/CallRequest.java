package com.M360.api.requests;

import com.M360.api.domain.enums.HttpMethod;
import com.M360.api.domain.enums.IfMachineStatus;

public class CallRequest {
	
	private String accountSid = null;
	private Integer fromCountryCode = null;
	private String from = null;
	private Integer toCountryCode = null;
	private String to = null;
	private String url = null;
	private HttpMethod method = null;
	private String statusCallbackUrl = null;
	private HttpMethod StatusCallbackMethod = null;
	private String fallbackUrl = null;
	private HttpMethod fallbackUrlMethod = null;
	private String heartbeatUrl = null;
	private HttpMethod heartbeatMethod = null;
	private Long timeout = null;
	private String playDtmf = null;
	private Boolean hideCallerId = null;
	private Boolean record = null;
	private Integer recordCallbackUrl = null;
	private HttpMethod recordCallbackMethod = null;
	private Boolean transcribe = null;
	private String transcribeCallbackUrl = null;
	private IfMachineStatus ifMachine = null;
	
	
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
	public String getStatusCallbackUrl() {
		return statusCallbackUrl;
	}
	public void setStatusCallbackUrl(String statusCallbackUrl) {
		this.statusCallbackUrl = statusCallbackUrl;
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
	public HttpMethod getFallbackUrlMethod() {
		return fallbackUrlMethod;
	}
	public void setFallbackUrlMethod(HttpMethod fallbackUrlMethod) {
		this.fallbackUrlMethod = fallbackUrlMethod;
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
	public Integer getRecordCallbackUrl() {
		return recordCallbackUrl;
	}
	public void setRecordCallbackUrl(Integer recordCallbackUrl) {
		this.recordCallbackUrl = recordCallbackUrl;
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
	public String getTranscribeCallbackUrl() {
		return transcribeCallbackUrl;
	}
	public void setTranscribeCallbackUrl(String transcribeCallbackUrl) {
		this.transcribeCallbackUrl = transcribeCallbackUrl;
	}
	public IfMachineStatus getIfMachine() {
		return ifMachine;
	}
	public void setIfMachine(IfMachineStatus ifMachine) {
		this.ifMachine = ifMachine;
	}
	

}
