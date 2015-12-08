/**
 * Provides a basic Transcription POJO implementation of "TRANSCRIPTION" Module.
 * @see Blocked
 * @version v1b
 * @author Ytel-Inc
 * @date November 2015
 */

package com.M360.api.domain.transcription;

import org.codehaus.jackson.annotate.JsonProperty;

import com.M360.api.domain.BaseMessage360Object;

public class Transcription extends BaseMessage360Object{
	
	@JsonProperty(value="TranscriptionSid")
	private String transcriptionSid = null;
	@JsonProperty(value="Callsid")
	private String callSid = null;
	@JsonProperty(value="Recordingsid")
	private String recordingSid = null;
	@JsonProperty(value="Duration")
	private Integer duration = null;
	@JsonProperty(value="Price")
	private Double price = null;
	@JsonProperty(value="AudioUrl")
	private String audioUrl = null;
	@JsonProperty(value="MediaId")
	private String mediaId = null;
	@JsonProperty(value="Sid")
	private String sid = null;
	@JsonProperty(value="TranscriptionText")
	private String transcriptionText = null;
	public String getTranscriptionSid() {
		return transcriptionSid;
	}
	public void setTranscriptionSid(String transcriptionSid) {
		this.transcriptionSid = transcriptionSid;
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
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getAudioUrl() {
		return audioUrl;
	}
	public void setAudioUrl(String audioUrl) {
		this.audioUrl = audioUrl;
	}
	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	public String getTranscriptionText() {
		return transcriptionText;
	}
	public void setTranscriptionText(String transcriptionText) {
		this.transcriptionText = transcriptionText;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	
	
	
	
}
