/**
 * Here you can experiment with sending an sms through Message360 and view the request response generated when doing so.
 * 
 * @version v1b
 * @since 2015-11-12 12:12:13
 * @author Yel Inc
 * 
 */
package com.M360.api.example.SMS;

import java.util.Date;

import com.M360.api.Message360Connector;
import com.M360.api.configuration.BasicM360Configuration;
import com.M360.api.configuration.M360Constants;
import com.M360.api.domain.Message360;
import com.M360.api.domain.responses.SMSMessages;
import com.M360.api.domain.SMS.Message;
import com.M360.api.exception.Error;
import com.M360.api.exception.M360Exception;
public class SendSmsExample {

	public static void main(String[] args) {
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID); 
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf);
		try {
			if(M360Constants.JSONFORMAT){
				String jsonSMSResponse=conn.sendJsonSmsMessage("9495350301","9493961707","This is an SMS message sent from the Message360-API Java wrapper! Easy as 1, 2, 3!"+new Date(),"Post",1,1,null);
				System.out.println(jsonSMSResponse);
			}else{
				Message360<SMSMessages> sendSMS = conn.sendSmsMessage("9495350301","9493961707","This is an SMS message sent from the Message360-API Java wrapper! Easy as 1, 2, 3!"+new Date(),"Post",1,1,null);
				if(sendSMS.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<sendSMS.getMessage360().getErrors().getError().size();x++){
						Error error=sendSMS.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+".\nMessage:="+error.getMessage()+",\nMoreInfo"+error.getMoreInfo().toString());
					}
				}else{
					for(int x=0;x<sendSMS.getMessage360().getMsgCount();x++){
						Message curMessage=sendSMS.getMessage360().getMessages().getMessage().get(x);
						System.out.println(x+") sid="+curMessage.getSid()+",status:="+curMessage.getStatus());
					}
				}
			}	
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
