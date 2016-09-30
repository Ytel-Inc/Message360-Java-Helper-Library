package com.M360.api.domain.directmail.areamail;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class RoutesDetails {
	
	@JsonProperty(value="ZipCode")
	private List<String> zipCode = null;
	@JsonProperty(value="Routes")
	private List<String> routes = null;
	@JsonProperty(value="Residential")
	private List<String> residential = null;
	@JsonProperty(value="Business")
	private List<String> business = null;
	
	
	public RoutesDetails(){
		zipCode = new ArrayList<String>();
		routes =  new ArrayList<String>();
		residential = new ArrayList<String>();
		business = new ArrayList<String>();
	}
	public List<String> getZipCode() {
		return zipCode;
	}
	public void setZipCode(List<String> zipCode) {
		this.zipCode = zipCode;
	}
	public List<String> getRoutes() {
		return routes;
	}
	public void setRoutes(List<String> routes) {
		this.routes = routes;
	}
	public List<String> getResidential() {
		return residential;
	}
	public void setResidential(List<String> residential) {
		this.residential = residential;
	}
	public List<String> getBusiness() {
		return business;
	}
	public void setBusiness(List<String> business) {
		this.business = business;
	}
	
}
