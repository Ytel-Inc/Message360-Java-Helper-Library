package com.M360.api.exception;

import org.codehaus.jackson.annotate.JsonProperty;

public class M360Exception extends Exception {

	private static final long serialVersionUID = -5937845116814343506L;
	
	private Long status;
	private String code;
	@JsonProperty(value="more_info")
	private String moreInfo;
	
	public M360Exception() {
		
	}
	
	public M360Exception(String message) {
		super(message);
	}
	
	public M360Exception(Long status, String message, String code, String moreInfo) {
		super(message);
		this.status = status;
		this.code = code;
		this.moreInfo = moreInfo;
	}
	
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMoreInfo() {
		return moreInfo;
	}
	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}
}
