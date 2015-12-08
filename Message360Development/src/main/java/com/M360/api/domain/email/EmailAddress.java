/**
 * Provides a basic Email Address POJO implementation of "EMAIL" Module.
 * @see Conference
 * @version v1b
 * @author Ytel-Inc
 * @date November 2015
 */

package com.M360.api.domain.email;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.M360.api.domain.BaseMessage360Object;
import com.M360.api.json.JsonDateParser;

public class EmailAddress extends BaseMessage360Object{
	
	@JsonDeserialize(using = JsonDateParser.class)
	@JsonProperty(value="Created")
	private Date created=null;
	@JsonProperty(value="Reason")
	private String reason=null;
	@JsonProperty(value="DeleteStatus")
	private String deleteStatus=null;
	@JsonProperty(value="AddStatus")
	private String addStatus=null;

	
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getDeleteStatus() {
		return deleteStatus;
	}
	public void setDeleteStatus(String deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public String getAddStatus() {
		return addStatus;
	}
	public void setAddStatus(String addStatus) {
		this.addStatus = addStatus;
	}
	
}
