package com.M360.api.example.conference;

import com.M360.api.Message360Connector;
import com.M360.api.configuration.BasicM360Configuration;
import com.M360.api.configuration.M360Constants;
import com.M360.api.domain.Message360;
import com.M360.api.domain.conference.Conference;
import com.M360.api.domain.responses.ConferenceMessages;
import com.M360.api.exception.Error;
import com.M360.api.exception.M360Exception;

public class AddParticipant {
	public static  void main(String[] args) throws Exception{
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID); 
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf);
		try {
			if(M360Constants.JSONFORMAT){
				String addParticipant=conn.addJsonParticipant("{ConferenceSid}", "{ParticipantNumber}", false, false, 1);
				System.out.println(addParticipant);
			}else{
				Message360<ConferenceMessages> addParticipant= conn.addParticipant("{ConferenceSid}", "{ParticipantNumber}", false, false, 1);
				if(addParticipant.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<addParticipant.getMessage360().getErrors().getError().size();x++){
						Error error=addParticipant.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+".\nMessage:="+error.getMessage());
					}
				}else{
					System.out.println("Add Participant");
					for(Conference conference:addParticipant.getMessage360().getConferences().getConference()){
						System.out.println(conference.getConferenceSid()+","+conference.getParticipantSid());
					}
				}
			}
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
