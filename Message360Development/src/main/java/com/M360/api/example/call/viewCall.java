/**
 * 
 * A call resource provides information about an individual call that has occurred through Message360. 
 * Both inbound and outbound voice communication through Message360 are categorized as calls. 
 * The resource properties representing a call are listed below. 
 * Call resources can be accessed at a resource URI made up of the Message360 base URL and a unique call SID
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

public class viewCall {
	public static void main(String[] args) {
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID); 
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf);
		try {
			
			if(!M360Constants.JSONFORMAT){
				String jsonCallResponse=conn.viewJsonCall("{CallSid}");
				System.out.println(jsonCallResponse);
			}else{
				Message360<CallMessages> viewCall = conn.viewCall("{CallSid}");
				if(viewCall.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<viewCall.getMessage360().getErrors().getError().size();x++){
						Error error=viewCall.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+".\nMessage:="+error.getMessage()+",\nMoreInfo:="+error.getMoreInfo().toString());
					}
				}else{
					System.out.println("View Call");
					for(Call curCall:viewCall.getMessage360().getCall()){
						System.out.println(curCall.getCallSid());
					}
				}
				
			}
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
