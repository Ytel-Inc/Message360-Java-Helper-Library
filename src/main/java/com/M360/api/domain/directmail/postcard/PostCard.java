package com.M360.api.domain.directmail.postcard;

import org.codehaus.jackson.annotate.JsonProperty;

import com.M360.api.domain.directmail.DirectMail;
import com.M360.api.domain.directmail.Tracking;

public class PostCard {
	@JsonProperty(value="PostcardDetails")
	private PostCardDetails postCardDetails = null;
	@JsonProperty(value="RecipientDetails")
	private DirectMail recipientDetails = null;
	@JsonProperty(value="SenderDetails")
	private DirectMail senderDetails = null;
	@JsonProperty(value="Tracking")
	private Tracking tracking = null;
	
	public PostCard(){
		postCardDetails = new PostCardDetails();
		recipientDetails = new DirectMail();
		senderDetails = new DirectMail();
		tracking = new Tracking();
	}

	public PostCardDetails getPostCardDetails() {
		return postCardDetails;
	}

	public void setPostCardDetails(PostCardDetails postCardDetails) {
		this.postCardDetails = postCardDetails;
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
