package com.M360.api.domain.directmail.responses;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.M360.api.domain.directmail.ListInfo;
import com.M360.api.domain.directmail.letters.Letter;
import com.M360.api.exception.Message360Exception;

public class DMLetter extends Message360Exception{

	@JsonProperty(value="ResponseStatus")
	private Integer responseStatus = null;
	@JsonProperty(value="Letter")
	private Letter letter = null;
	@JsonProperty(value="ListInfo")
	private ListInfo listInfo = null;
	@JsonProperty(value="Letters")
	private  List<Letter> letters = null;
	
	public DMLetter(){
		letter =  new Letter();
		listInfo = new ListInfo();
		letters =  new ArrayList<Letter>();
	}

	public Integer getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(Integer responseStatus) {
		this.responseStatus = responseStatus;
	}

	public Letter getLetter() {
		return letter;
	}
	public void setLetter(Letter letter) {
		this.letter = letter;
	}

	public ListInfo getListInfo() {
		return listInfo;
	}
	public void setListInfo(ListInfo listInfo) {
		this.listInfo = listInfo;
	}

	public List<Letter> getLetters() {
		return letters;
	}
	public void setLetters(List<Letter> letters) {
		this.letters = letters;
	}
	
}
