package com.M360.api.domain.directmail.letters;

import org.codehaus.jackson.annotate.JsonProperty;

import com.M360.api.domain.directmail.DirectMail;
import com.M360.api.domain.directmail.Tracking;

public class Letter {
	
	@JsonProperty(value="LettersDetails")
	private LettersDetails lettersDetails = null;
	@JsonProperty(value="RecipientDetails")
	private DirectMail recipientDetails = null;
	@JsonProperty(value="SenderDetails")
	private DirectMail senderDetails = null;
	@JsonProperty(value="Tracking")
	private Tracking tracking = null;
	
	public Letter(){
		lettersDetails = new LettersDetails();
		recipientDetails =  new DirectMail();
		senderDetails =  new DirectMail();
		tracking = new Tracking();
	}
	public LettersDetails getLettersDetails() {
		return lettersDetails;
	}
	public void setLettersDetails(LettersDetails lettersDetails) {
		this.lettersDetails = lettersDetails;
	}
	public DirectMail getRecipientDetails() {
		return recipientDetails;
	}
	public void setRecipientDetails(DirectMail recipientDetails) {
		this.recipientDetails = recipientDetails;
	}
	public DirectMail getSenderDetails() {
		return senderDetails;
	}
	public void setSenderDetails(DirectMail senderDetails) {
		this.senderDetails = senderDetails;
	}
	public Tracking getTracking() {
		return tracking;
	}
	public void setTracking(Tracking tracking) {
		this.tracking = tracking;
	}
	
}
