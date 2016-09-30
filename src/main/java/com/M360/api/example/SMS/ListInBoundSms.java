/**
 * The request response returned here contains a list of SMS messages associated with your Message360 account.
 * 
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
import com.M360.api.domain.SMS.Message;
import com.M360.api.exception.Error;
import com.M360.api.exception.M360Exception;

public class ListInBoundSms {
	public static void main(String[] args) {
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID);
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf);
		try {
			if(M360Constants.JSONFORMAT){
				String jsonSMSResponse=conn.getJsonInboundSMS();
				System.out.println(jsonSMSResponse);
			}else{
				Message360<SMSMessages> inBoundSMSList = conn.getInboundSMS();
				if(inBoundSMSList.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<inBoundSMSList.getMessage360().getErrors().getError().size();x++){
						Error error=inBoundSMSList.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+".\nMessage:="+error.getMessage()+",\nMoreInfo"+error.getMoreInfo().toString());
					}
				}else{
					for(Message inboundSMS : inBoundSMSList.getMessage360().getMessages().getMessage()) {
						System.out.println(inboundSMS.getSid()+",From :="+inboundSMS.getFrom()+",To :="+inboundSMS.getTo());
					}
				}	
			}
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
