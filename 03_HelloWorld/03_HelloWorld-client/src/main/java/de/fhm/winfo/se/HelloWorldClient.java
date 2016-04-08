package de.fhm.winfo.se;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class HelloWorldClient {
	
	
	public static void main(String[] args) {
		try {
			Context context = new InitialContext();
			String lookupString = "03_HelloWorld-ear/03_HelloWorld-ejb/HelloWorldServiceBean!de.fhm.winfo.se.HelloWorldService";
			HelloWorldService remoteService = (HelloWorldService) context.lookup(lookupString);
			String result = remoteService.getHelloWorldString("Joe");
			System.out.println(result);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}
