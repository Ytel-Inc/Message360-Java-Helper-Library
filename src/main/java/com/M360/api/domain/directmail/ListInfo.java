package com.M360.api.domain.directmail;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListInfo {

	@JsonProperty(value="TotalAddresses")
	private Integer totalAddresses = null;
	@JsonProperty(value="PageSize")
	private Integer pageSize = null;
	@JsonProperty(value="TotalPages")
	private Integer totalPage = null;
	@JsonProperty(value="PageNumber")
	private Integer pageNumber =null;
	
	
	@JsonProperty(value="TotalPostcards")
	private Integer totalPostcards = null;
	@JsonProperty(value="TotalLetters")
	private Integer totalLetters = null;
	@JsonProperty(value="TotalAreamails")
	private Integer totalAreamails = null;
	
	public ListInfo(){
		
	}
	public Integer getTotalAddresses() {
		return totalAddresses;
	}
	public void setTotalAddresses(Integer totalAddresses) {
		this.totalAddresses = totalAddresses;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	public Integer getTotalPostcards() {
		return totalPostcards;
	}
	public void setTotalPostcards(Integer totalPostcards) {
		this.totalPostcards = totalPostcards;
	}
	public Integer getTotalLetters() {
		return totalLetters;
	}
	public void setTotalLetters(Integer totalLetters) {
		this.totalLetters = totalLetters;
	}
	public Integer getTotalAreamails() {
		return totalAreamails;
	}
	public void setTotalAreamails(Integer totalAreamails) {
		this.totalAreamails = totalAreamails;
	}
	
	
}
