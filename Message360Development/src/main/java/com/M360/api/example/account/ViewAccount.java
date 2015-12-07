/**
 * 
 * An account resource provides information about a single message360 account. 
 * The resource properties representing an account are listed below. 
 * Account resources can be accessed at a resource URI beginning with the message360 base URL and ending with a unique account SID.
 * 
 * @version v1b
 * @author Ytel-Inc
 * @date November 2015
 * 
 */
package com.M360.api.example.account;

import com.M360.api.Message360Connector;
import com.M360.api.configuration.BasicM360Configuration;
import com.M360.api.configuration.M360Constants;
import com.M360.api.domain.responses.AccountMessage;
import com.M360.api.domain.Message360;
import com.M360.api.exception.Error;
import com.M360.api.exception.M360Exception;

public class ViewAccount {

	public static void main(String[] args) {
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID); 
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf);
		try {
			if(!M360Constants.JSONFORMAT){
				String accountResponse=conn.viewJsonAccount();//
				System.out.println(accountResponse);
			}else{
				Message360<AccountMessage> accountExample = conn.viewAccount();//0, 0, 0);
				if(accountExample.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<accountExample.getMessage360().getErrors().getError().size();x++){
						Error error=accountExample.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+".\nMessage:="+error.getMessage());
					}
				}else{
					System.out.println("Account Sid:="+accountExample.getMessage360().getAccountMessage().getAccountSid());
				}
			}
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
