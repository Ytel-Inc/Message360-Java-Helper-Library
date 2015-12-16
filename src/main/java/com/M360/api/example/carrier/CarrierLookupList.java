package com.M360.api.example.carrier;

import com.M360.api.Message360Connector;
import com.M360.api.carrier.Carrier;
import com.M360.api.configuration.BasicM360Configuration;
import com.M360.api.configuration.M360Constants;
import com.M360.api.domain.Message360;
import com.M360.api.domain.responses.CarrierMessage;
import com.M360.api.exception.Error;
import com.M360.api.exception.M360Exception;

public class CarrierLookupList {
	public static void main(String[] args) {
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID);
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf);
		try {
			if(M360Constants.JSONFORMAT){
				String jsonEmailResponse=conn.carrierJsonLookupList();
				System.out.println(jsonEmailResponse);
			}else{
				Message360<CarrierMessage> carrierLookupList = conn.carrierLookupList();
				if(carrierLookupList.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<carrierLookupList.getMessage360().getErrors().getError().size();x++){
						Error error=carrierLookupList.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+",\nMessage:="+error.getMessage()+",\nMoreInfo"+error.getMoreInfo().toString());
					}
				}else{
					System.out.println("CarrierLookupList");
					for(Carrier curCarrier:carrierLookupList.getMessage360().getCarriers().getCarrier())
						System.out.println("Carrier Sid:="+curCarrier.getCarrierSid());
					}
					
				}
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
