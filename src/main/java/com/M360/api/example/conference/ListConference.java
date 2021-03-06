package com.M360.api.example.conference;

import com.M360.api.Message360Connector;
import com.M360.api.configuration.BasicM360Configuration;
import com.M360.api.configuration.M360Constants;
import com.M360.api.domain.Message360;
import com.M360.api.domain.conference.Conference;
import com.M360.api.domain.responses.ConferenceMessages;
import com.M360.api.exception.Error;
import com.M360.api.exception.M360Exception;

public class ListConference {
	public static  void main(String[] args) throws Exception{
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID); 
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf);
		try {
			if(M360Constants.JSONFORMAT){
				String listConference=conn.listJsonConference();
				System.out.println(listConference);
			}else{
				Message360<ConferenceMessages> listConference= conn.listConference();
				if(listConference.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<listConference.getMessage360().getErrors().getError().size();x++){
						Error error=listConference.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+".\nMessage:="+error.getMessage());
					}
				}else{
					System.out.println("List Conference ");
					for(Conference conference:listConference.getMessage360().getConferences().getConference()){
						System.out.println(conference.getFriendlyName()+","+conference.getAccountSid());
					}
				}
			}
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
