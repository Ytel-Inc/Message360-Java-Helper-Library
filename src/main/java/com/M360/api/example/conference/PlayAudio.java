package com.M360.api.example.conference;

import com.M360.api.Message360Connector;
import com.M360.api.configuration.BasicM360Configuration;
import com.M360.api.configuration.M360Constants;
import com.M360.api.domain.Message360;
import com.M360.api.domain.conference.Conference;
import com.M360.api.domain.responses.ConferenceMessages;
import com.M360.api.exception.Error;
import com.M360.api.exception.M360Exception;

public class PlayAudio {
	public static  void main(String[] args) throws Exception{
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID); 
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf);
		try {
				if(!M360Constants.JSONFORMAT){
					String listJsonResponse=conn.playJsonAudio("CF7eba209c-9aaf-42c6-805a-3c3eb623138d", "ef533163-3f15-70c1-cc34-49264dc5b5d5","https://storage.googleapis.com/m360-102504/2015-12-04/1449212759_9492080471.mp3");
					System.out.println(listJsonResponse);
				}else{
					Message360<ConferenceMessages> viewConference= conn.playAudio("CF7eba209c-9aaf-42c6-805a-3c3eb623138d", "ef533163-3f15-70c1-cc34-49264dc5b5d5","https://storage.googleapis.com/m360-102504/2015-12-04/1449212759_9492080471.mp3");
					if(viewConference.getMessage360().getErrors().getError().size()!=0){
						for(int x=0;x<viewConference.getMessage360().getErrors().getError().size();x++){
							Error error=viewConference.getMessage360().getErrors().getError().get(x);
								System.out.println("code :="+error.getCode()+".\nMessage:="+error.getMessage()+",\nMoreInfo"+error.getMoreInfo().toString());
						}
					}else{
						System.out.println("Deaf Mute Participant");
						for(Conference conference:viewConference.getMessage360().getConferences().getConference()){
							System.out.println("Participant Sid:="+conference.getParticipantSid());
						}
					}
				}
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}