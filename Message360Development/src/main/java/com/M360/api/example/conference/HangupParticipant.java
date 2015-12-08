/**
 * 
 * The HTTP GET method is used to request this resource. The format of this resources URI is below.
 * 
 * @version v1b
 * @author Ytel-Inc
 * @date November 2015
 * 
 */

package com.M360.api.example.conference;

import com.M360.api.Message360Connector;
import com.M360.api.configuration.BasicM360Configuration;
import com.M360.api.configuration.M360Constants;
import com.M360.api.domain.Message360;
import com.M360.api.domain.conference.Conference;
import com.M360.api.domain.responses.ConferenceMessages;
import com.M360.api.exception.Error;
import com.M360.api.exception.M360Exception;

public class HangupParticipant {
	public static  void main(String[] args) throws Exception{
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID); 
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf);
		try {
			if(M360Constants.JSONFORMAT){
				String listJsonResponse=conn.hangupJsonParticipant("{ConferenceSid}", "{ParticipantSid}");
				System.out.println(listJsonResponse);
			}else{
				Message360<ConferenceMessages> hangupParticipant= conn.hangupParticipant("{ConferenceSid}", "{ParticipantSid}");
				if(hangupParticipant.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<hangupParticipant.getMessage360().getErrors().getError().size();x++){
						Error error=hangupParticipant.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+".\nMessage:="+error.getMessage()+"\nMoreInfo:="+error.getMoreInfo().toString());
					}
				}else{
					System.out.println("Hangup Participant");
					for(Conference conference:hangupParticipant.getMessage360().getParticipants().getParticipant()){
						System.out.println(conference.getParticipantSid());
					}
				}
			}
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
