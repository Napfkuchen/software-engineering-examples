package de.fhms.winfo.se;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Stateless Session Bean implementation of the HelloWorldService interface
 */
@Stateless
@Remote(HelloWorldService.class)
public class HelloWorldServiceBean implements HelloWorldService {

	public String getHelloWorldString(String name) {
		return "Hello World from the HelloWorldServiceImpl. My name is " + name + ".";
	}

}
