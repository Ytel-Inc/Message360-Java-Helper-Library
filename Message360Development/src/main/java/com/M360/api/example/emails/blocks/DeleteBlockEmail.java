/**
 * This endpoint allows you to delete entries in the Blocks list.
 * @version v1b
 * @since 2015-11-12 12:12:13
 * @author Ytel Inc
 * 
 */
//@BUG repsonse is not same format
package com.M360.api.example.emails.blocks;


import com.M360.api.Message360Connector;
import com.M360.api.configuration.BasicM360Configuration;
import com.M360.api.configuration.M360Constants;
import com.M360.api.domain.Message360;
import com.M360.api.domain.email.Blocked;
import com.M360.api.domain.email.EmailAddress;
import com.M360.api.domain.responses.Message360Email;
import com.M360.api.exception.Error;
import com.M360.api.exception.M360Exception;

public class DeleteBlockEmail {
	public static void main(String[] args) {
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID);
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf);
		try {
			if(!M360Constants.JSONFORMAT){
				String deleteJsonBlockEmailAddr=conn.deleteJsonBlocksEmailAdress("rizwan@xoyal.com");
				System.out.println(deleteJsonBlockEmailAddr);
			}else{
				Message360<Message360Email<Blocked>> deleteBlocEmailAddr = conn.deleteBlocksEmailAdress("salaman@srk.com");
				if(deleteBlocEmailAddr.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<deleteBlocEmailAddr.getMessage360().getErrors().getError().size();x++){
						Error error=deleteBlocEmailAddr.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+",\nMessage:="+error.getMessage()+",\nMoreInfo"+error.getMoreInfo().toString());
					}
				}else{
					System.out.println("Delete Blocks Email");
					EmailAddress curBlockEmailAddres=deleteBlocEmailAddr.getMessage360().getEmail().getBlocked().get(0);
					if(curBlockEmailAddres.getDeleteStatus().toLowerCase().equals("fail")){
						System.out.println("Email:"+curBlockEmailAddres.getEmail()+",Delete Status:="+curBlockEmailAddres.getDeleteStatus()+",Reason:="+curBlockEmailAddres.getReason());
					}else{
						System.out.println("Email:"+curBlockEmailAddres.getEmail()+",Delete Status:="+curBlockEmailAddres.getDeleteStatus());
					}
				}
			}
 		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
