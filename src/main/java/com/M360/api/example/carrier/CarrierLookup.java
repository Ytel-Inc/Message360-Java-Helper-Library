package com.M360.api.example.carrier;

import com.M360.api.Message360Connector;
import com.M360.api.configuration.BasicM360Configuration;
import com.M360.api.configuration.M360Constants;
import com.M360.api.domain.Message360;
import com.M360.api.domain.responses.CarrierMessage;
import com.M360.api.exception.Error;
import com.M360.api.exception.M360Exception;

public class CarrierLookup {
	public static void main(String[] args) {
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID);
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf);
		try {
			if(M360Constants.JSONFORMAT){
				String jsonEmailResponse=conn.carrierJsonLookup("{phoneNumber}");
				System.out.println(jsonEmailResponse);
			}else{
				Message360<CarrierMessage> carrierLookup = conn.carrierLookup("{phoneNumber}");
				if(carrierLookup.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<carrierLookup.getMessage360().getErrors().getError().size();x++){
						Error error=carrierLookup.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+",\nMessage:="+error.getMessage()+",\nMoreInfo"+error.getMoreInfo().toString());
					}
				}else{
					System.out.println("CarrierLookup");
					System.out.println("Carrier Sid:="+carrierLookup.getMessage360().getCarrier().getCarrierSid()+",Account Sid:="+carrierLookup.getMessage360().getCarrier().getAccountSid());
				}
			}
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
