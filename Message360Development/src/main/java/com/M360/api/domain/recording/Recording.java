package com.M360.api.domain.recording;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.M360.api.domain.BaseMessage360Object;
import com.M360.api.json.JsonDateParser;

public class Recording extends BaseMessage360Object{
	@JsonProperty(value="RecordingSid")
	private String recordingSid=null;
	@JsonProperty(value="AccountSid")
	private String accountSid=null;
	@JsonDeserialize(using = JsonDateParser.class)
	@JsonProperty(value="StartTime")
	private Date startTime=null;
	@JsonDeserialize(using = JsonDateParser.class)
	@JsonProperty(value="EndTime")
	private Date endTime=null;
	@JsonProperty(value="CallSid")
	private String callSid=null;
	@JsonProperty(value="Duration")
	private Double duration=null;
	@JsonProperty(value="StatusCallBack")
	private String statusCallBack=null;
	@JsonProperty(value="Direction")
	private String direction=null;
	@JsonProperty(value="RecordingUrl")
	private String recordingUrl=null;
	public String getRecordingSid() {
		return recordingSid;
	}
	public void setRecordingSid(String recordingSid) {
		this.recordingSid = recordingSid;
	}
	public String getAccountSid() {
		return accountSid;
	}
	public void setAccountSid(String accountSid) {
		this.accountSid = accountSid;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getCallSid() {
		return callSid;
	}
	public void setCallSid(String callSid) {
		this.callSid = callSid;
	}
	public Double getDuration() {
		return duration;
	}
	public void setDuration(Double duration) {
		this.duration = duration;
	}
	public String getStatusCallBack() {
		return statusCallBack;
	}
	public void setStatusCallBack(String statusCallBack) {
		this.statusCallBack = statusCallBack;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getRecordingUrl() {
		return recordingUrl;
	}
	public void setRecordingUrl(String recordingUrl) {
		this.recordingUrl = recordingUrl;
	}
	
}
