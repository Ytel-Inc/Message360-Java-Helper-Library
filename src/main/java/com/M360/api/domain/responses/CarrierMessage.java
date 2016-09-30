package com.M360.api.domain.responses;


import org.codehaus.jackson.annotate.JsonProperty;

import com.M360.api.carrier.Carrier;
import com.M360.api.carrier.Carriers;
import com.M360.api.exception.Message360Exception;

public class CarrierMessage extends Message360Exception{
	@JsonProperty(value="ResponseStatus")
	private Integer responseStatus = null;
	@JsonProperty(value="NumbersCount")
	private Integer NumbersCount = null;
	@JsonProperty(value="Page")
	private Integer Page = null;
	@JsonProperty(value="PageSize")
	private Integer PageSize = null;
	
	@JsonProperty(value="Carrier")
	private Carrier carrier =null;
	
	@JsonProperty(value="Carriers")
	private Carriers carriers =null;

	public CarrierMessage(){
		carrier =new Carrier();
		carriers=new Carriers();
	}
	
	public Integer getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(Integer responseStatus) {
		this.responseStatus = responseStatus;
	}

	public Carrier getCarrier() {
		return carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

	public Carriers getCarriers() {
		return carriers;
	}

	public void setCarriers(Carriers carriers) {
		this.carriers = carriers;
	}

	public Integer getNumbersCount() {
		return NumbersCount;
	}

	public void setNumbersCount(Integer numbersCount) {
		NumbersCount = numbersCount;
	}

	public Integer getPage() {
		return Page;
	}

	public void setPage(Integer page) {
		Page = page;
	}

	public Integer getPageSize() {
		return PageSize;
	}

	public void setPageSize(Integer pageSize) {
		PageSize = pageSize;
	}
	
	
	
	
}
