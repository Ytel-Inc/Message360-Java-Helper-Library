package com.M360.api.domain.responses;

import org.codehaus.jackson.annotate.JsonProperty;

import com.M360.api.domain.conference.Conferences;
import com.M360.api.exception.Message360Exception;

public class ConferenceMessages extends Message360Exception{
	@JsonProperty(value="ResponseStatus")
	private Integer responseStatus = null;
	@JsonProperty(value="Conferences")
	private Conferences conferences= null;
	
	@JsonProperty(value="Participants")
	private Conferences participants= null;
	
	
	public ConferenceMessages(){
		super();
		conferences=new Conferences();
		participants=new Conferences();
	}

	public Integer getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(Integer responseStatus) {
		this.responseStatus = responseStatus;
	}

	public Conferences getConferences() {
		return conferences;
	}

	public void setConferences(Conferences conferences) {
		this.conferences = conferences;
	}

	public Conferences getParticipants() {
		return participants;
	}

	public void setParticipants(Conferences participants) {
		this.participants = participants;
	}

}
