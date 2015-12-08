/**
 * Provides a basic Call POJO implementation of "CALL" Module.
 * @see Call
 * @version v1b
 * @author Ytel-Inc
 * @date November 2015
 */

package com.M360.api.domain.call;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.M360.api.domain.BaseMessage360Object;
import com.M360.api.json.JsonDateParser;

public class Call extends BaseMessage360Object {
	
	@JsonProperty(value="Sid")
	private String sid = null;
	@JsonDeserialize(using = JsonDateParser.class)
	@JsonProperty(value="StartTime")
	private Date startrTime = null;
	@JsonDeserialize(using = JsonDateParser.class)
	@JsonProperty(value="EndTime")
	private Date endTime = null;
	@JsonProperty(value="Duration")
	private Double duration = null;
	@JsonProperty(value="Price")
	private Double price= null;
	@JsonProperty(value="StatusCallBack")
	private String statusCallBack= null;
	@JsonProperty(value="Direction")
	private String direction = null;
	
	@JsonProperty(value="CallSid")
	private String callSid =null;
	
	@JsonProperty(value="RecordingSid")
	private String recordingSid =null;
	@JsonDeserialize(using = JsonDateParser.class)
	@JsonProperty(value="CreatedTime")
	private Date createdTime = null;
	
	
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public Date getStartrTime() {
		return startrTime;
	}
	public void setStartrTime(Date startrTime) {
		this.startrTime = startrTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Double getDuration() {
		return duration;
	}
	public void setDuration(Double duration) {
		this.duration = duration;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
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
	public String getCallSid() {
		return callSid;
	}
	public void setCallSid(String callSid) {
		this.callSid = callSid;
	}
	public String getRecordingSid() {
		return recordingSid;
	}
	public void setRecordingSid(String recordingSid) {
		this.recordingSid = recordingSid;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	
	
	
	
	
	
	
}
