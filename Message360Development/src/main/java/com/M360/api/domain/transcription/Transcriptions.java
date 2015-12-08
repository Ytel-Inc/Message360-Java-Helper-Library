/**
 * Provides a basic transcription POJO implementation of "TRANSCRIPTION" Module.
 * 
 * @see Transcription
 * @version v1b
 * @author Ytel-Inc
 * @date November 2015
 */

package com.M360.api.domain.transcription;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Transcriptions {
	@JsonProperty(value="Transcription")
	private List<Transcription> transcription = null;

	public Transcriptions(){
		super();
	}
	
	public List<Transcription> getTranscription() {
		return transcription;
	}

	public void setTranscription(List<Transcription> transcription) {
		this.transcription = transcription;
	}
}
