package com.M360.api.domain.directmail.responses;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.M360.api.domain.directmail.ListInfo;
import com.M360.api.domain.directmail.postcard.PostCard;
import com.M360.api.exception.Message360Exception;

public class DMPostCard extends Message360Exception{

	@JsonProperty(value="ResponseStatus")
	private Integer responseStatus = null;
	@JsonProperty(value="Postcard")
	private PostCard postcard = null;
	@JsonProperty(value="ListInfo")
	private ListInfo listInfo = null;
	@JsonProperty(value="Postcards")
	private  List<PostCard> postcards = null;
	
	public DMPostCard(){
		postcard = new PostCard();
		listInfo = new ListInfo(); 
		postcards = new ArrayList<PostCard>();
	}

	public Integer getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(Integer responseStatus) {
		this.responseStatus = responseStatus;
	}

	public PostCard getPostcard() {
		return postcard;
	}

	public void setPostcard(PostCard postcard) {
		this.postcard = postcard;
	}

	public ListInfo getListInfo() {
		return listInfo;
	}

	public void setListInfo(ListInfo listInfo) {
		this.listInfo = listInfo;
	}

	public List<PostCard> getPostcards() {
		return postcards;
	}

	public void setPostcards(List<PostCard> postcards) {
		this.postcards = postcards;
	}
	

}
