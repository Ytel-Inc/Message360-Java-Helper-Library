package com.M360.api.example.directmail.areamails;

import com.M360.api.Message360Connector;
import com.M360.api.configuration.BasicM360Configuration;
import com.M360.api.configuration.M360Constants;
import com.M360.api.domain.Message360;
import com.M360.api.domain.directmail.responses.DMAreaMail;
import com.M360.api.exception.Error;
import com.M360.api.exception.M360Exception;

public class ViewAreaMail {
	public static void main(String[] args) {
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID);
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf);
		try {
			if(M360Constants.JSONFORMAT){
				String jsonSMSResponse=conn.viewJsonAreaMail("{areaMailId}");
				System.out.println(jsonSMSResponse);
			}else{
				Message360<DMAreaMail> veiwAreaMail = conn.viewAreaMail("{areaMailId}");
				if(veiwAreaMail.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<veiwAreaMail.getMessage360().getErrors().getError().size();x++){
						Error error=veiwAreaMail.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+".\nMessage:="+error.getMessage()+",\nMoreInfo"+error.getMoreInfo().toString());
					}
				}else{
					System.out.println("View AreaMail Detail");
					System.out.println("Area Mail ID:= "+veiwAreaMail.getMessage360().getAreaMail().getAreaMailDetails().getId()+",Route Detail:="+veiwAreaMail.getMessage360().getAreaMail().getRoutesDetails().getZipCode()+",Tracking ID:="+veiwAreaMail.getMessage360().getAreaMail().getTracking().getId());
				}
			}	
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
