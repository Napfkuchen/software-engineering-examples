package de.xbank.onlinebanking;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.xbank.common.NoSessionException;
import de.xbank.common.XbankOnlineService;

@RunWith(Arquillian.class)
public class XbankOnlineServiceBeanTest {

	@EJB
	XbankOnlineService bean;

	
	@Deployment
    public static WebArchive createDeployment() {
    	return ShrinkWrap.create(WebArchive.class, "test.war")
               .addPackages(true,"de/xbank")
               .addAsWebInfResource("META-INF/ejb-jar.xml", "ejb-jar.xml");
    }
 

	@Test
	/**
	 * Prueft, ob Login für Emma funktioniert.
	 */
	public void test1() throws Exception {
		boolean success = bean.login("emma", "emma1");
		assert success;
	}

	@Test
	/**
	 * Prueft, ob nach Login für Emma 1 Konto abgerufen wird.
	 * @throws NoSessionException
	 */
	public void test2() throws Exception {
		bean.login("emma", "emma1");
		int size = bean.getMyAccounts().size();
		assert size==1;
	}

	@Test
	/**
	 * Prueft, ob bei Abfrage ohne Login eine NoSessionException kommt.
	 * @throws NoSessionException
	 */
	public void test3() {
		try {
			bean.getMyAccounts();
		} catch (NoSessionException e) {
			assert true;
		}
		assert false;
	}
	
}
