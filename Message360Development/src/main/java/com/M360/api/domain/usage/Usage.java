package com.M360.api.domain.usage;

import org.codehaus.jackson.annotate.JsonProperty;

import com.M360.api.domain.BaseMessage360Object;

public class Usage extends BaseMessage360Object{
	@JsonProperty(value="Product")
	private String product=null;
	@JsonProperty(value="TotalCost")
	private Double totalCost=null;
	@JsonProperty(value="Total")
	private Integer total=null;
	
	
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public Double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}

	
	
}
