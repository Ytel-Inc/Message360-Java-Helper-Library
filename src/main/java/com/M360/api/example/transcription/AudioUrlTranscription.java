package com.M360.api.example.transcription;

import com.M360.api.Message360Connector;
import com.M360.api.configuration.BasicM360Configuration;
import com.M360.api.configuration.M360Constants;
import com.M360.api.domain.Message360;
import com.M360.api.domain.responses.TranscriptionMessage;
import com.M360.api.domain.transcription.Transcription;
import com.M360.api.exception.Error;
import com.M360.api.exception.M360Exception;

public class AudioUrlTranscription {
	public static void main(String[] args) {
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID); 
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf);
		try {
			if(M360Constants.JSONFORMAT){
				String jsonSMSResponse=conn.audioUrlJsonTranscription("{AudioUrl}");
				System.out.println(jsonSMSResponse);
			}else{
				Message360<TranscriptionMessage> audioUrlTrans = conn.audioUrlTranscription("{AudioUrl}");
				if(audioUrlTrans.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<audioUrlTrans.getMessage360().getErrors().getError().size();x++){
						Error error=audioUrlTrans.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+".\nMessage:="+error.getMessage()+",\nMoreInfo"+error.getMoreInfo().toString());
					}
				}else{
					System.out.println("AudioUrls");
					for(Transcription curMessage:audioUrlTrans.getMessage360().getTranscription()){
						System.out.println("sid="+curMessage.getTranscriptionSid()+",status:="+curMessage.getStatus());
					}
				}
			}
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
