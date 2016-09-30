package com.M360.api.example.directmail.addressbook;

import com.M360.api.Message360Connector;
import com.M360.api.configuration.BasicM360Configuration;
import com.M360.api.configuration.M360Constants;
import com.M360.api.domain.Message360;
import com.M360.api.domain.directmail.responses.DMAddressBook;
import com.M360.api.exception.Error;
import com.M360.api.exception.M360Exception;

public class CreateAddressBook {
	public static void main(String[] args) {
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID); 
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf,M360Constants.DIRECT_MAIL);
		try {
			if(M360Constants.JSONFORMAT){
				String jsonSMSResponse=conn.createJsonAddressBook("{name}", "{email}", "{phone}", "{address}", "{state}", "{zip}", "{city}", "{country}");
				System.out.println(jsonSMSResponse);
			}else{
				Message360<DMAddressBook> createAddressBook = conn.createAddressBook("{name}", "{email}", "{phone}", "{address}", "{state}", "{zip}", "{city}", "{country}");
				if(createAddressBook.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<createAddressBook.getMessage360().getErrors().getError().size();x++){
						Error error=createAddressBook.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+".\nMessage:="+error.getMessage()+",\nMoreInfo"+error.getMoreInfo().toString());
					}
				}else{
					System.out.println("Create Address Book");
					
					System.out.println("Create Address Id:= "+createAddressBook.getMessage360().getAddress().getId()+","+createAddressBook.getMessage360().getAddress().getName());
				}
			}	
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
