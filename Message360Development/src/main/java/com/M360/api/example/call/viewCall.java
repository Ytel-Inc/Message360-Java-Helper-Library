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
				String jsonCallResponse=conn.viewJsonCall("e353e538-34a0-cedc-3082-23e08215cf0611111");
				System.out.println(jsonCallResponse);
			}else{
				Message360<CallMessages> viewCall = conn.viewCall("e353e538-34a0-cedc-3082-23e08215cf06111");
				if(viewCall.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<viewCall.getMessage360().getErrors().getError().size();x++){
						Error error=viewCall.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+".\nMessage:="+error.getMessage()+",\nMoreInfo:="+error.getMoreInfo().toString());
					}
				}else{
					System.out.println("View Call");
					int size=viewCall.getMessage360().getCall().size();
					for(int x=0;x<size;x++){
						Call curCall=viewCall.getMessage360().getCall().get(x);
						System.out.println(curCall.getCallSid());
					}
				}
				
			}
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
