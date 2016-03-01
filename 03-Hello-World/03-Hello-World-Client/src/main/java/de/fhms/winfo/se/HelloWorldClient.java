package de.fhms.winfo.se;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Objects;
import java.util.Properties;

public class HelloWorldClient {

	public static void main(String[] args) {
		try {
	        Context context = new InitialContext();
	        String lookupString = "ejb:03-Hello-World-EAR/03-Hello-World-EJB/HelloWorldServiceBean!de.fhms.winfo.se.HelloWorldService";
			HelloWorldService remoteService = (HelloWorldService) context.lookup(lookupString);
	        String result = remoteService.getHelloWorldString("Joe");
	        System.out.println(result);
		} catch (NamingException e) {
			System.out.println(e);
		}
	}

}
