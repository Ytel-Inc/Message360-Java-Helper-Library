/**
 * The request response returned here contains a list of usages resources associated with your message360 account.
 * @version v1b
 * @since 2015-11-12 12:12:13
 * @author Yel Inc
 * 
 */
package com.M360.api.example.usage;

import com.M360.api.Message360Connector;
import com.M360.api.configuration.BasicM360Configuration;
import com.M360.api.configuration.M360Constants;
import com.M360.api.domain.Message360;
import com.M360.api.domain.enums.ProductType;
import com.M360.api.domain.responses.UsageMessage;
import com.M360.api.domain.usage.Usage;
import com.M360.api.exception.Error;
import com.M360.api.exception.M360Exception;

public class ListUsageExample {
	public static void main(String[] args) {
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID); 
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf);
		try {
			
			if(M360Constants.JSONFORMAT){
				String listJsonUsage=conn.listJsonUsage(ProductType.OUTBOUND_CALL,null,null);
				System.out.println(listJsonUsage);
			}else{
				Message360<UsageMessage> listUsageExample = conn.listUsage(ProductType.OUTBOUND_CALL, null, null);
				if(listUsageExample.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<listUsageExample.getMessage360().getErrors().getError().size();x++){
						Error error=listUsageExample.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+".\nMessage:="+error.getMessage()+",\nMoreInfo"+error.getMoreInfo().toString());
					}
				}else{
					for(Usage usage:listUsageExample.getMessage360().getUsage()){
						System.out.println(usage.getProduct()+",total cost:="+usage.getTotalCost());
					}
				}
			}
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
