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
import com.M360.api.exception.M360Exception;

public class ListInBoundSms {
	public static void main(String[] args) {
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid("YT10ff38384fba9905c49ccaa487c3367f");
		conf.setAuthToken("1acff5853c8f26d269b259b79db3ebb1");
		Message360Connector conn = new Message360Connector(conf);
		try {
			if(M360Constants.JSONFORMAT){
				String jsonSMSResponse=conn.getJsonInboundSMS();
				System.out.println(jsonSMSResponse);
			}else{
				Message360<SMSMessages> inBoundSMSList = conn.getInboundSMS();
				for(Message inboundSMS : inBoundSMSList.getMessage360().getMessages().getMessage()) {
					System.out.println(inboundSMS.getSid()+",from :="+inboundSMS.getFrom()+",To :="+inboundSMS.getTo());
				}
			}
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
