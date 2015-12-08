/**
 * 
 * Here you can experiment with initiating a call through Message360 and view the request response generated when doing so.
 * 
 * @version v1b
 * @author Ytel-Inc
 * @date November 2015
 * 
 */

package com.M360.api.example.call;

import com.M360.api.Message360Connector;
import com.M360.api.configuration.BasicM360Configuration;
import com.M360.api.configuration.M360Constants;
import com.M360.api.domain.Message360;
import com.M360.api.domain.call.Call;
import com.M360.api.domain.responses.CallMessages;
import com.M360.api.exception.Error;
import com.M360.api.exception.M360Exception;
import com.M360.api.requests.CallRequest;

public class MakeCall {
	public static void main(String[] args) {
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID); 
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf);
		try {
			CallRequest cr=new CallRequest();
			cr.setFromCountryCode(1);
			cr.setFrom("{fromNumber}");
			cr.setTo("{toNumber}");
			cr.setToCountryCode(1);
			cr.setPlayDtmf("{StringPlayDTMF}");
			cr.setUrl("{URL}");
			if(M360Constants.JSONFORMAT){
				String jsonCallResponse=conn.makeJsonCall(cr);
				System.out.println(jsonCallResponse);
			}else{
				Message360<CallMessages> viewCall = conn.makeCall(cr);
				if(viewCall.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<viewCall.getMessage360().getErrors().getError().size();x++){
						Error error=viewCall.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+".\nMessage:="+error.getMessage());
					}
				}else{
					System.out.println("Make Call");
					int size=viewCall.getMessage360().getCall().size();
					for(Call curCall:viewCall.getMessage360().getCall()){
						System.out.println(curCall.getCallSid()+","+curCall.getDirection());
					}
				}
				
			}
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
