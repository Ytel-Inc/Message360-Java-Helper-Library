package com.M360.api.domain.directmail.responses;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.M360.api.domain.directmail.ListInfo;
import com.M360.api.domain.directmail.address.AddressBook;
import com.M360.api.exception.Message360Exception;

public class DMAddressBook extends Message360Exception{

	@JsonProperty(value="ResponseStatus")
	private Integer responseStatus = null;
	@JsonProperty(value="ListInfo")
	private ListInfo listInfo = null;
	@JsonProperty(value="Verify")
	private Integer verify = null;
	@JsonProperty(value="Address")
	private AddressBook address = null;
	@JsonProperty(value="Addresses")
	private List<AddressBook> addressesList = null;
	
	public DMAddressBook(){
		address= new AddressBook();
		addressesList = new ArrayList<AddressBook>();
		listInfo = new ListInfo();
	}
	
	public Integer getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(Integer responseStatus) {
		this.responseStatus = responseStatus;
	}
	public AddressBook getAddress() {
		return address;
	}
	public void setAddress(AddressBook address) {
		this.address = address;
	}

	public List<AddressBook> getAddressesList() {
		return addressesList;
	}

	public void setAddressesList(List<AddressBook> addressesList) {
		this.addressesList = addressesList;
	}

	public ListInfo getListInfo() {
		return listInfo;
	}

	public void setListInfo(ListInfo listInfo) {
		this.listInfo = listInfo;
	}

	public Integer getVerify() {
		return verify;
	}

	public void setVerify(Integer verify) {
		this.verify = verify;
	}

}
