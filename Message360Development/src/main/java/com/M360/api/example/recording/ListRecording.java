/**
 * The request response returned here contains a list of all recordings that have occurred through your Message360 account.
 * @version v1b
 * @since 2015-11-12 12:12:13
 * @author Ytel Inc
 * 
 */
package com.M360.api.example.recording;

import com.M360.api.Message360Connector;
import com.M360.api.configuration.BasicM360Configuration;
import com.M360.api.configuration.M360Constants;
import com.M360.api.domain.Message360;
import com.M360.api.domain.recording.Recording;
import com.M360.api.domain.responses.RecordMessage;
import com.M360.api.exception.Error;
import com.M360.api.exception.M360Exception;

public class ListRecording {
	public static  void main(String[] args) throws Exception{
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID); 
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf);
		try {
				if(M360Constants.JSONFORMAT){
					String listJsonResponse=conn.listJsonRecording();
					System.out.println(listJsonResponse);
				}else{
					Message360<RecordMessage> viewRecording= conn.listRecording();
					if(viewRecording.getMessage360().getErrors().getError().size()!=0){
						for(int x=0;x<viewRecording.getMessage360().getErrors().getError().size();x++){
							Error error=viewRecording.getMessage360().getErrors().getError().get(x);
								System.out.println("code :="+error.getCode()+".\nMessage:="+error.getMessage()+",\nMoreInfo"+error.getMoreInfo().toString());
						}
					}else{
						System.out.println("Recording Sid");
						for(Recording recording:viewRecording.getMessage360().getRecording()){
							System.out.println(recording.getRecordingSid());
						}
					}
				}
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
