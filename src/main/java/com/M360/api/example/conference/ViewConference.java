package com.M360.api.example.conference;

import com.M360.api.Message360Connector;
import com.M360.api.configuration.BasicM360Configuration;
import com.M360.api.configuration.M360Constants;
import com.M360.api.domain.Message360;
import com.M360.api.domain.conference.Conference;
import com.M360.api.domain.responses.ConferenceMessages;
import com.M360.api.exception.Error;
import com.M360.api.exception.M360Exception;

public class ViewConference {
	public static  void main(String[] args) throws Exception{
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID); 
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf);
		try {
			if(M360Constants.JSONFORMAT){
				String viewConference=conn.viewJsonConference("{ConferenceSid}");
				System.out.println(viewConference);
			}else{
				Message360<ConferenceMessages> viewConference= conn.viewConference("{ConferenceSid}");
				if(viewConference.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<viewConference.getMessage360().getErrors().getError().size();x++){
						Error error=viewConference.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+".\nMessage:="+error.getMessage()+",\nMoreInfo"+error.getMoreInfo().toString());
					}
				}else{
					System.out.println("Recording Sid");
					for(Conference conference:viewConference.getMessage360().getConferences().getConference()){
						System.out.println(conference.getConferenceSid()+","+conference.getAccountSid());
					}
				}
			}
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
