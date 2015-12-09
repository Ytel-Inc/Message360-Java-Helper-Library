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
