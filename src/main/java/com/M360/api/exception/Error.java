package com.M360.api.exception;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;;

public class Error {
	
	@JsonInclude(value=Include.NON_NULL)
	@JsonProperty(value = "Code")
	private String code=null;
	@JsonProperty(value="Message")
	private String message=null;
	@JsonProperty(value = "MoreInfo")
	private List<MoreInfo> moreInfo=null;
	//private MoreInfo moreInfo=null;
	
	
	public Error(){
		super();
		moreInfo=new ArrayList<MoreInfo>();
		//moreInfo=new MoreInfo();
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	 public List<MoreInfo> getMoreInfo() {
			return moreInfo;
	}
	public void  setMoreInfo(List<MoreInfo> moreInfo) {
		this.moreInfo = moreInfo;
	}
	 
	/*
	 public List<MoreInfo> getMoreInfo() {
		return moreInfo;
	}
	public void setMoreInfo(List<MoreInfo> moreInfo) {
		this.moreInfo = moreInfo;
	}*/
	/* public MoreInfo getMoreInfo() {
		return moreInfo;
	}
	public void setMoreInfo(MoreInfo moreInfo) {
		this.moreInfo = moreInfo;
	}*/
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
