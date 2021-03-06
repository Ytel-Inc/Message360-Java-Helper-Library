package com.M360.api.domain.conference;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Conferences /*extends Conference*/{
	
	@JsonProperty(value="Conference")
	private List<Conference> conference = null;
	
	@JsonProperty(value="Participant")
	private List<Conference> participant = null;
	
	public Conferences(){
		super();
		conference=new ArrayList<Conference>();
		participant=new ArrayList<Conference>();
	}
	
	public List<Conference> getConference() {
		return conference;
	}

	public void setConference(List<Conference> conference) {
		this.conference = conference;
	}

	public List<Conference> getParticipant() {
		return participant;
	}

	public void setParticipant(List<Conference> participant) {
		this.participant = participant;
	}
	
	
}
