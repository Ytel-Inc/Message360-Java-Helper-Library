package com.M360.api.domain.responses;

import org.codehaus.jackson.annotate.JsonProperty;

import com.M360.api.domain.SMS.Message;
import com.M360.api.domain.SMS.Messages;
import com.M360.api.domain.SMS.OptIns;
import com.M360.api.exception.Message360Exception;


public class SMSMessages extends Message360Exception{
	@JsonProperty(value = "ResponseStatus")
	private Integer responseStatus =null;
	@JsonProperty(value = "MessageCount")
	private Integer msgCount=null;
	@JsonProperty(value = "Page")
	private Integer page=null;
	@JsonProperty(value = "PageSize")
	private Integer pageSize=null;
	@JsonProperty(value = "AddCount")
	private Integer addCount=null;
	@JsonProperty(value = "UpdateCount")
	private Integer updateCount=null;
	@JsonProperty(value = "FailureCount")
	private Integer failureCount=null;
	
	@JsonProperty(value = "Messages")
	private Messages messages=null;

	@JsonProperty(value = "Message")
	private Message message=null;
	
	@JsonProperty(value = "OptIns")
	private OptIns optIns=null;
	
	
	
	public SMSMessages(){
		super();
		//messages = new Messages();
	}



	public Integer getResponseStatus() {
		return responseStatus;
	}



	public void setResponseStatus(Integer responseStatus) {
		this.responseStatus = responseStatus;
	}



	public Integer getMsgCount() {
		return msgCount;
	}



	public void setMsgCount(Integer msgCount) {
		this.msgCount = msgCount;
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



	public Integer getAddCount() {
		return addCount;
	}



	public void setAddCount(Integer addCount) {
		this.addCount = addCount;
	}



	public Integer getUpdateCount() {
		return updateCount;
	}



	public void setUpdateCount(Integer updateCount) {
		this.updateCount = updateCount;
	}



	public Integer getFailureCount() {
		return failureCount;
	}



	public void setFailureCount(Integer failureCount) {
		this.failureCount = failureCount;
	}



	public Messages getMessages() {
		return messages;
	}



	public void setMessages(Messages messages) {
		this.messages = messages;
	}



	public Message getMessage() {
		return message;
	}



	public void setMessage(Message message) {
		this.message = message;
	}



	public OptIns getOptIns() {
		return optIns;
	}



	public void setOptIns(OptIns optIns) {
		this.optIns = optIns;
	}
	
	
	
	
	
	
}
