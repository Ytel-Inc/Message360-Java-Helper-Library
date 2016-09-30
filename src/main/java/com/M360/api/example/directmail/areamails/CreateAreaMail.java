package com.M360.api.example.directmail.areamails;

import com.M360.api.Message360Connector;
import com.M360.api.configuration.BasicM360Configuration;
import com.M360.api.configuration.M360Constants;
import com.M360.api.domain.Message360;
import com.M360.api.domain.directmail.responses.DMAreaMail;
import com.M360.api.domain.enums.TargetType;
import com.M360.api.exception.Error;
import com.M360.api.exception.M360Exception;

public class CreateAreaMail {
	public static void main(String[] args) {
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID);
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf);
		try {
			if(M360Constants.JSONFORMAT){
				String jsonSMSResponse=conn.createJsonAreaMail("{attache_by_id}", "@{url/pdf_filepath}", "@{url/pdf_filepath}", "{description}", "{Route}", TargetType.BUSINESS_AND_RESIDENTIAL, "{htmldata}");
				System.out.println(jsonSMSResponse);
			}else{
				Message360<DMAreaMail> createAreaMail = conn.createAreaMail("{attache_by_id}", "@{url/pdf_filepath}", "@{url/pdf_filepath}", "{description}", "{Route}", TargetType.BUSINESS_AND_RESIDENTIAL, "{htmldata}");
				if(createAreaMail.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<createAreaMail.getMessage360().getErrors().getError().size();x++){
						Error error=createAreaMail.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+".\nMessage:="+error.getMessage()+",\nMoreInfo"+error.getMoreInfo().toString());
					}
				}else{
					System.out.println("Create AreaMail Detail");
					System.out.println("Creaet Area Mail := "+createAreaMail.getMessage360().getAreaMail().getAreaMailDetails().getId()+",Route Detail:="+createAreaMail.getMessage360().getAreaMail().getRoutesDetails().getZipCode()+",Tracking ID:="+createAreaMail.getMessage360().getAreaMail().getTracking().getId());
				}
			}	
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
