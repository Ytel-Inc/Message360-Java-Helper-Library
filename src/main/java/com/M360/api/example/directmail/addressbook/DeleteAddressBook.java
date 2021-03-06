package com.M360.api.example.directmail.addressbook;

import com.M360.api.Message360Connector;
import com.M360.api.configuration.BasicM360Configuration;
import com.M360.api.configuration.M360Constants;
import com.M360.api.domain.Message360;
import com.M360.api.domain.directmail.responses.DMAddressBook;
import com.M360.api.exception.Error;
import com.M360.api.exception.M360Exception;

public class DeleteAddressBook {
	public static void main(String[] args) {
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID); 
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf,M360Constants.DIRECT_MAIL);
		try {
			if(M360Constants.JSONFORMAT){
				String jsonSMSResponse=conn.deleteJsonAddressBook("{deleteAddressBookId}");
				System.out.println(jsonSMSResponse);
			}else{
				Message360<DMAddressBook> deleteAddressBook = conn.deleteAddressBook("{deleteAddressBookId}");
				if(deleteAddressBook.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<deleteAddressBook.getMessage360().getErrors().getError().size();x++){
						Error error=deleteAddressBook.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+".\nMessage:="+error.getMessage()+",\nMoreInfo"+error.getMoreInfo().toString());
					}
				}else{
					System.out.println("Delete Address Book");
					System.out.println("Delete Address Id:= "+deleteAddressBook.getMessage360().getAddress().getId()+","+deleteAddressBook.getMessage360().getAddress().getName());
				}
			}	
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
