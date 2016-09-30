package com.M360.api.domain.directmail.letters;

import org.codehaus.jackson.annotate.JsonProperty;

import com.M360.api.domain.directmail.DirectMail;

public class LettersDetails  extends DirectMail{
	
	@JsonProperty(value="File")
	private String file = null;
	@JsonProperty(value="Color")
	private String color = null;
	@JsonProperty(value="DoubleSided")
	private boolean doubleSided ;
	@JsonProperty(value="Template")
	private boolean template ;
	@JsonProperty(value="ExtraService")
	private String extraService ;
	
	public LettersDetails(){
		
	}
	
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean isDoubleSided() {
		return doubleSided;
	}
	public void setDoubleSided(boolean doubleSided) {
		this.doubleSided = doubleSided;
	}
	public boolean isTemplate() {
		return template;
	}
	public void setTemplate(boolean template) {
		this.template = template;
	}
	public String getExtraService() {
		return extraService;
	}
	public void setExtraService(String extraService) {
		this.extraService = extraService;
	}
	
}
