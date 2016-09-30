package com.M360.api.domain.directmail.responses;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.M360.api.domain.directmail.ListInfo;
import com.M360.api.domain.directmail.areamail.AreaMail;
import com.M360.api.exception.Message360Exception;

public class DMAreaMail extends Message360Exception{
	
	@JsonProperty(value="ResponseStatus")
	private Integer responseStatus = null;
	@JsonProperty(value="AreaMail")
	private AreaMail areaMail = null;
	@JsonProperty(value="ListInfo")
	private ListInfo listInfo = null;
	@JsonProperty(value="AreaMails")
	private  List<AreaMail> areaMails = null;
	
	public DMAreaMail(){
		areaMail = new AreaMail();
		listInfo = new ListInfo();
		areaMails = new ArrayList<AreaMail>();
	}

	public Integer getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(Integer responseStatus) {
		this.responseStatus = responseStatus;
	}

	public AreaMail getAreaMail() {
		return areaMail;
	}

	public void setAreaMail(AreaMail areaMail) {
		this.areaMail = areaMail;
	}

	public ListInfo getListInfo() {
		return listInfo;
	}

	public void setListInfo(ListInfo listInfo) {
		this.listInfo = listInfo;
	}

	public List<AreaMail> getAreaMails() {
		return areaMails;
	}

	public void setAreaMails(List<AreaMail> areaMails) {
		this.areaMails = areaMails;
	}
	
}
