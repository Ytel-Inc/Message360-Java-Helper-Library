package com.M360.api.domain.directmail;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.M360.api.json.JsonDateParser;

public class Tracking extends DirectMail{
	
	@JsonProperty(value="TrackingNumber")
	private String trackingNumber = null;
	@JsonProperty(value="Carrier")
	private String carrier = null;
	@JsonProperty(value="Event")
	private String event = null;
	@JsonDeserialize(using = JsonDateParser.class)
	@JsonProperty(value="Date")
	private Date date = null;
	
	public Tracking(){
		
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}
	
	
	
	
}
