/**
 * When sending an SMS to number from a Toll Free Number it is required that the number be Opted-In beforehand.
 * Not opting in the number will result in the message not being delivered.
 * The Opt-in API allows you to Opt-In a number and allow for the delivery of the SMS.
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
import com.M360.api.exception.Error;
import com.M360.api.exception.M360Exception;


public class ViewNumberOptin {
	public static void main(String[] args) {
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID); 
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf);
		try {
			Integer toCountryCode=1,fromCountryCode=1,expires=0;
			if(M360Constants.JSONFORMAT){
				String jsonSMSResponse=conn.getJsonNumberOptins("{toNumber}", "{froNumber}", fromCountryCode, toCountryCode,expires , "{authorizedby}", "{authorizedhow}");
				System.out.println(jsonSMSResponse);
			}else{
				Message360<SMSMessages> viewOptInsSMS = conn.getNumberOptins("{toNumber}", "{froNumber}", fromCountryCode, toCountryCode,expires , "{authorizedby}", "{authorizedhow}");
				if(viewOptInsSMS.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<viewOptInsSMS.getMessage360().getErrors().getError().size();x++){
						Error error=viewOptInsSMS.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+".\nMessage:="+error.getMessage());
					}
				}else{
					System.out.println("SID:="+viewOptInsSMS.getMessage360().getOptIns().getOptIn().getSid()+",Required Id: "+viewOptInsSMS.getMessage360().getOptIns().getOptIn().getReqId());
				}
			}
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}

}
