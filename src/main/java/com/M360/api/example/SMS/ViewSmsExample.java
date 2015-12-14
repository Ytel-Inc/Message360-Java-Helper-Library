/**
 * The response returned here contains all resource properties associated with the given SMSMessageSid.
 * @version v1b
 * @since 2015-11-12 12:12:13
 * @author Yel Inc
 * 
 */
package com.M360.api.example.SMS;

import com.M360.api.Message360Connector;
import com.M360.api.configuration.BasicM360Configuration;
import com.M360.api.configuration.M360Constants;
import com.M360.api.domain.Message360;
import com.M360.api.domain.responses.SMSMessages;
import com.M360.api.exception.Error;
import com.M360.api.exception.M360Exception;

public class ViewSmsExample {

	public static void main(String[] args) {
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID); 
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf);
		try {
			if(M360Constants.JSONFORMAT){
				String jsonSMSResponse=conn.viewJsonSmsMessage("{smsMessageSid}");
				System.out.println(jsonSMSResponse);
			}else{
				Message360<SMSMessages> viewSMS = conn.viewSmsMessage("{smsMessageSid}");
				if(viewSMS.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<viewSMS.getMessage360().getErrors().getError().size();x++){
						Error error=viewSMS.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+".\nMessage:="+error.getMessage()+",\nMoreInfo"+error.getMoreInfo().toString());
					}
				}else{
					System.out.println("View SMS.");
					System.out.println("Message Sid:= "+viewSMS.getMessage360().getMessage().getSid()+",Body:="+viewSMS.getMessage360().getMessage().getBody());
				}
			}	
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
