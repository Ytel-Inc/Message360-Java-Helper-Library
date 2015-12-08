/**
 * Provides a basic Conference POJO implementation of "CONFERENCE" Module.
 * @see Conference
 * @version v1b
 * @author Ytel-Inc
 * @date November 2015
 */

package com.M360.api.domain.conference;

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.M360.api.domain.BaseMessage360Object;
import com.M360.api.json.JsonDateParser;

public class Conference extends BaseMessage360Object{
	
	@JsonProperty(value="ConferenceSid")
	private String conferenceSid = null;
	@JsonProperty(value="FriendlyName")
	private String friendlyName = null;
	@JsonProperty(value="ParticipantCount")
	private Integer participantCount = null;
	@JsonProperty(value="Duration")
	private Integer duration = null;
	@JsonDeserialize(using = JsonDateParser.class)
	@JsonProperty(value="StartTime")
	private Date startrTime = null;
	@JsonDeserialize(using = JsonDateParser.class)
	@JsonProperty(value="EndTime")
	private Date endTime = null;
	
	@JsonProperty(value="Participant")
	private List<String> participant = null;
	
	
	
	
	@JsonProperty(value="ParticipantSid")
	private String participantSid = null;
	@JsonProperty(value="BridgeNumber")
	private String BridgeNumber = null;
	@JsonProperty(value="Muted")
	private Boolean muted = null;
	@JsonProperty(value="Deaf")
	private Boolean deaf = null;
	@JsonProperty(value="Number")
	private String number = null;

	
	
	
	public Conference(){
		super();
		
	}
	public String getFriendlyName() {
		return friendlyName;
	}
	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}
	public Integer getParticipantCount() {
		return participantCount;
	}
	public void setParticipantCount(Integer participantCount) {
		this.participantCount = participantCount;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
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
	public String getConferenceSid() {
		return conferenceSid;
	}
	public void setConferenceSid(String conferenceSid) {
		this.conferenceSid = conferenceSid;
	}
	
	
	public String getBridgeNumber() {
		return BridgeNumber;
	}
	public void setBridgeNumber(String bridgeNumber) {
		BridgeNumber = bridgeNumber;
	}
	public Boolean getMuted() {
		return muted;
	}
	public void setMuted(Boolean muted) {
		this.muted = muted;
	}
	public Boolean getDeaf() {
		return deaf;
	}
	public void setDeaf(Boolean deaf) {
		this.deaf = deaf;
	}
	public List<String> getParticipant() {
		return participant;
	}
	public void setParticipant(List<String> participant) {
		this.participant = participant;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public void setParticipantSid(String participantSid) {
		this.participantSid = participantSid;
	}
	
	public String getParticipantSid() {
		return participantSid;
	}
	
	
	
	
}
