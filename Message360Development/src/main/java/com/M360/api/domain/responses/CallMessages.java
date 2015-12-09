package com.M360.api.domain.responses;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.M360.api.domain.call.Call;
import com.M360.api.exception.Message360Exception;

public class CallMessages extends Message360Exception{
	
	@JsonProperty(value="ResponseStatus")
	private Integer responseStatus = null;
	@JsonProperty(value="CallCount")
	private Integer callCount = null;
	@JsonProperty(value="Page")
	private Integer page = null;
	@JsonProperty(value="PageSize")
	private Integer pageSize = null;
	@JsonProperty(value="Calls")
	private Calls calls = null;
	@JsonProperty(value="Call")
	private List<Call> call = null;
	
	public CallMessages(){
		super();
		calls= new Calls();
		call=new ArrayList<Call>();
	}
	
	public Integer getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(Integer responseStatus) {
		this.responseStatus = responseStatus;
	}

	public Integer getCallCount() {
		return callCount;
	}

	public void setCallCount(Integer callCount) {
		this.callCount = callCount;
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

	public Calls getCalls() {
		return calls;
	}

	public void setCalls(Calls calls) {
		this.calls = calls;
	}

	public List<Call> getCall() {
		return call;
	}

	public void setCall(List<Call> call) {
		this.call = call;
	}

	public static class Calls{
		@JsonProperty(value="Call")
		private List<Call> call = null;
		
		public Calls(){
			super();
			call = new ArrayList<Call>();
		}
		
		public List<Call> getCall() {
			return call;
		}

		public void setCall(List<Call> call) {
			this.call = call;
		}
	}
	

	
	
	
}
