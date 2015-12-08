/**
 * Provides a basic Phones POJO implementation of "PhoneNumber" Module.
 * @see Phones
 * @version v1b
 * @author Ytel-Inc
 * @date November 2015
 */

package com.M360.api.domain.phonenumber;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Phones {
	
	@JsonProperty(value="Phone")
	private List<Phone> phone = null;
	
	public Phones(){
		super();
		phone=new ArrayList<Phone>();
	}

	public List<Phone> getPhone() {
		return phone;
	}

	public void setPhone(List<Phone> phone) {
		this.phone = phone;
	}
	
	
}
