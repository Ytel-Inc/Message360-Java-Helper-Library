/**
 * 
 * Message360 Transcription Response Structure.
 * 
 * @version v1b
 * @author Ytel-Inc
 * @date November 2015
 * 
 */

package com.M360.api.domain.responses;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.M360.api.domain.transcription.Transcription;
import com.M360.api.domain.transcription.Transcriptions;
import com.M360.api.exception.Message360Exception;

public class TranscriptionMessage extends Message360Exception{
	
	@JsonProperty(value="ResponseStatus")
	private Integer responseStatus = null;
	@JsonProperty(value="TranscriptionCount")
	private Integer transcriptionCount = null;
	@JsonProperty(value="Page")
	private Long page = null;
	@JsonProperty(value="PageSize")
	private Long pageSize = null;
	@JsonProperty(value="Transcriptions")
	private Transcriptions transcriptions = null;
	
	
	@JsonProperty(value="Transcription")
	private List<Transcription> transcription = null;
	
	
	public TranscriptionMessage(){
		super();
		transcription = new ArrayList<Transcription>();
		transcriptions =new Transcriptions();
	}
	public Integer getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(Integer responseStatus) {
		this.responseStatus = responseStatus;
	}
	public List<Transcription> getTranscription() {
		return transcription;
	}
	public void setTranscription(List<Transcription> transcription) {
		this.transcription = transcription;
	}
	public Integer getTranscriptionCount() {
		return transcriptionCount;
	}
	public void setTranscriptionCount(Integer transcriptionCount) {
		this.transcriptionCount = transcriptionCount;
	}
	public Long getPage() {
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	public Long getPageSize() {
		return pageSize;
	}
	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}
	public Transcriptions getTranscriptions() {
		return transcriptions;
	}
	public void setTranscriptions(Transcriptions transcriptions) {
		this.transcriptions = transcriptions;
	}
	
	
	
}
