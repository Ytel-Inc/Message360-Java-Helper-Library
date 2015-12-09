package com.M360.api.domain.responses;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.M360.api.domain.recording.Recording;
import com.M360.api.exception.Message360Exception;

public class RecordMessage extends Message360Exception{
	@JsonProperty(value="ResponseStatus")
	private Integer responseStatus=null;
	@JsonProperty(value="RecordCount")
	private Integer recordCount=null;
	@JsonProperty(value="Page")
	private Integer page=null;
	@JsonProperty(value="PageSize")
	private Integer pageSize=null;
	
	@JsonProperty(value="Recording")
	private List<Recording> recording=null;
	
	public RecordMessage(){
		super();
		recording = new ArrayList<Recording>(); 
	}

	public Integer getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(Integer responseStatus) {
		this.responseStatus = responseStatus;
	}

	public List<Recording> getRecording() {
		return recording;
	}

	public void setRecording(List<Recording> recording) {
		this.recording = recording;
	}

	public Integer getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(Integer recordCount) {
		this.recordCount = recordCount;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	
	@Override
	public String toString() {
		return "RecordMessage [responseStatus=" + responseStatus + ", recording=" + recording + "]";
	}

	
	
	
	
}
