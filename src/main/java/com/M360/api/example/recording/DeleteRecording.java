package com.M360.api.example.recording;

import com.M360.api.Message360Connector;
import com.M360.api.configuration.BasicM360Configuration;
import com.M360.api.configuration.M360Constants;
import com.M360.api.domain.Message360;
import com.M360.api.domain.recording.Recording;
import com.M360.api.domain.responses.RecordMessage;
import com.M360.api.exception.Error;
import com.M360.api.exception.M360Exception;

public class DeleteRecording {
	public static void main(String[] args) {
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID); 
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf);
		try {
			if(M360Constants.JSONFORMAT){
				String recordingResponse=conn.deleteRecordingJson("{RecordingSid}");
				System.out.println(recordingResponse);
			}else{
				Message360<RecordMessage> deleteRecording= conn.deleteRecording("{RecordingSid}");
				if(deleteRecording.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<deleteRecording.getMessage360().getErrors().getError().size();x++){
						Error error=deleteRecording.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+".\nMessage:="+error.getMessage()+",\nMoreInfo"+error.getMoreInfo().toString());
					}
				}else{
					System.out.println("Delete Recording :\n");
					for(Recording recording:deleteRecording.getMessage360().getRecording()){
						System.out.println(recording.getRecordingSid());
					}
				}
			}
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
