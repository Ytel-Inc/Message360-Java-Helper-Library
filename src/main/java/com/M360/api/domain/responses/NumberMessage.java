package com.M360.api.domain.responses;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.M360.api.domain.phonenumber.Phone;
import com.M360.api.domain.phonenumber.Phones;
import com.M360.api.exception.Message360Exception;

public class NumberMessage extends Message360Exception {
	@JsonProperty(value="ResponseStatus")
	private Integer responseStatus = null;
	@JsonProperty(value="PhoneCount")
	private Integer phoneCount = null;
	@JsonProperty(value="Page")
	private Long page = null;
	@JsonProperty(value="PageSize")
	private Long pageSize = null;
	@JsonProperty(value="NumPages")
	private Integer numPages = null;
	@JsonProperty(value="Phones")
	private Phones phones = null;
	@JsonProperty(value="Phone")
	private List<Phone> phone = null;
	@JsonProperty(value="BuyNumber")
	private List<Phone> buyNumber = null;
	@JsonProperty(value="Release")
	private Phone release = null;

	public NumberMessage(){
		super();
		phones=new Phones();
		phone=new ArrayList<Phone>();
		buyNumber=new ArrayList<Phone>(); 
		release = new Phone();
	}

	public Integer getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(Integer responseStatus) {
		this.responseStatus = responseStatus;
	}

	public Integer getPhoneCount() {
		return phoneCount;
	}

	public void setPhoneCount(Integer phoneCount) {
		this.phoneCount = phoneCount;
	}

	public Long getPage() {
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public Long getPageSize() {
		return pageSize;
	}

	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getNumPages() {
		return numPages;
	}

	public void setNumPages(Integer numPages) {
		this.numPages = numPages;
	}

	public Phones getPhones() {
		return phones;
	}

	public void setPhones(Phones phones) {
		this.phones = phones;
	}

	public List<Phone> getPhone() {
		return phone;
	}

	public void setPhone(List<Phone> phone) {
		this.phone = phone;
	}
	
	public List<Phone> getBuyNumber() {
		return buyNumber;
	}

	public void setBuyNumber(List<Phone> buyNumber) {
		this.buyNumber = buyNumber;
	}

	public Phone getRelease() {
		return release;
	}

	public void setRelease(Phone release) {
		this.release = release;
	}
	
	
}
