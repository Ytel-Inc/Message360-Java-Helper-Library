package com.M360.api.domain.email;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Spam {
	
	@JsonProperty(value="SpamReports")
	private List<EmailAddress> spamReports=null;
	@JsonProperty(value="SpamReport")
	private EmailAddress spamReport=null;
	
	public Spam(){
		super();
		spamReports = new ArrayList<EmailAddress>();
		spamReport = new EmailAddress();
	}

	public List<EmailAddress> getSpamReports() {
		return spamReports;
	}

	public void setSpamReports(List<EmailAddress> spamReports) {
		this.spamReports = spamReports;
	}

	public EmailAddress getSpamReport() {
		return spamReport;
	}

	public void setSpamReport(EmailAddress spamReport) {
		this.spamReport = spamReport;
	}

	
}
