package de.fhm.winfo.se;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class HelloWorldServiceBean
 */
@Stateless
@Remote(HelloWorldService.class)
public class HelloWorldServiceBean implements HelloWorldService {

	@Override
	public String getHelloWorldString(String name) {
		return "Hello World from the HelloWorldServiceImpl. My name is " + name + ".";
	}

	
}
