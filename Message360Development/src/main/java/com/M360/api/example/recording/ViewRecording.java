/**
 * The response returned here contains all resource properties associated with the given RecordingSid.
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

public class ViewRecording {

	public static  void main(String[] args) throws Exception{
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID); 
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf);
		try {
				if(!M360Constants.JSONFORMAT){
					String viewRecordingResponse=conn.viewJsonRecording("{RecordingId}");
					System.out.println(viewRecordingResponse);
				}else{
					Message360<RecordMessage> viewRecording= conn.viewRecording("{RecordingId}");
					if(viewRecording.getMessage360().getErrors().getError().size()!=0){
						for(int x=0;x<viewRecording.getMessage360().getErrors().getError().size();x++){
							Error error=viewRecording.getMessage360().getErrors().getError().get(x);
								System.out.println("code :="+error.getCode()+".\nMessage:="+error.getMessage()+",\nMoreInfo"+error.getMoreInfo().toString());
						}
					}else{
						System.out.println("View Recording");
						for(Recording recording:viewRecording.getMessage360().getRecording()){
							System.out.println("Recording Sid:\n"+recording.getRecordingSid());		
						}
					}
				}
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
	
}
