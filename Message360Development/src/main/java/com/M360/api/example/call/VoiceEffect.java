package com.M360.api.example.call;

import com.M360.api.Message360Connector;
import com.M360.api.configuration.BasicM360Configuration;
import com.M360.api.configuration.M360Constants;
import com.M360.api.domain.Message360;
import com.M360.api.domain.call.Call;
import com.M360.api.domain.responses.CallMessages;
import com.M360.api.exception.Error;

public class VoiceEffect {
	public static void main(String[] args) {
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID); 
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf);
		try {
			if(M360Constants.JSONFORMAT){
				String jsonCallResponse=conn.voiceJsonEffects("319acbc5-7e52-5b8b-edb9-1f20760c71c0", null,null,null,null,null,null);
				System.out.println(jsonCallResponse);
			}else{
				System.out.println("Voice Effect");
				Message360<CallMessages> voiceEffect = conn.voiceEffects("319acbc5-7e52-5b8b-edb9-1f20760c71c0", null,null,null,null,null,null);
				if(voiceEffect.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<voiceEffect.getMessage360().getErrors().getError().size();x++){
						Error error=voiceEffect.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+".\nMessage:="+error.getMessage());
					}
				}else{
					for(int x=0;x<voiceEffect.getMessage360().getCall().size();x++){
						Call curCall=voiceEffect.getMessage360().getCall().get(x);
						System.out.println("Account Sid:"+curCall.getAccountSid()+",Callsid:"+curCall.getCallSid());
					}
				}
			}
			
		} catch (Exception e) {//M360Exception
			e.printStackTrace();
		}
	}
}
