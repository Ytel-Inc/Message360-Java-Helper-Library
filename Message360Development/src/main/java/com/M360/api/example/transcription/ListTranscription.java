/**
 * The request response returned here contains a list of transcriptions that have occurred through your message360 account.
 * @version v1b
 * @since 2015-11-12 12:12:13
 * @author Ytel Inc
 * 
 */
package com.M360.api.example.transcription;

import com.M360.api.Message360Connector;
import com.M360.api.configuration.BasicM360Configuration;
import com.M360.api.configuration.M360Constants;
import com.M360.api.domain.Message360;
import com.M360.api.domain.responses.TranscriptionMessage;
import com.M360.api.domain.transcription.Transcription;
import com.M360.api.exception.Error;
import com.M360.api.exception.M360Exception;

public class ListTranscription {
	public static void main(String[] args) {
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID); 
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf);
		try {
			if(!M360Constants.JSONFORMAT){
				String jsonSMSResponse=conn.listJsonTranscription();
				System.out.println(jsonSMSResponse);
			}else{
				Message360<TranscriptionMessage> sendSMS = conn.listTranscription();
				if(sendSMS.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<sendSMS.getMessage360().getErrors().getError().size();x++){
						Error error=sendSMS.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+".\nMessage:="+error.getMessage()+",\nMoreInfo"+error.getMoreInfo().toString());
					}
				}else{
					System.out.println("List Transcription"+sendSMS.getMessage360().getTranscriptionCount());
					for(int x=0;x<sendSMS.getMessage360().getTranscriptionCount();x++){
						Transcription curMessage=sendSMS.getMessage360().getTranscriptions().getTranscription().get(x);
						System.out.println(x+") sid="+curMessage.getTranscriptionSid()+",status:="+curMessage.getStatus());//REMAINING  DELETE sid var in Transcription.
					}
				}
			}
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
