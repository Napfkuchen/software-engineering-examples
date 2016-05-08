package de.xbank.onlinebanking;

import javax.ejb.EJB;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
//import de.xbank.dao.XbankDAOLocal;
//import de.xbank.entities.Customer;

@RunWith(Arquillian.class)
public class XbankDAOTest {


//	@EJB
//	XbankDAOLocal dao;

	
	@Deployment
    public static WebArchive createDeployment() {
    	return ShrinkWrap.create(WebArchive.class, "test.war")
               .addPackages(true,"de/xbank")
               .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
               .addAsWebInfResource("META-INF/ejb-jar.xml", "ejb-jar.xml");
    }
 


//	@Test
//	/**
//	 * Prueft, ob nach dem Startup ein Testkunde namens Emma vom DAO gefunden wird.
//	 */
//	public void test1() throws Exception {
//		Customer emma = dao.findCustomerByName("emma");
//		assert emma!=null : "Emma nicht gefunden.";
//		assert emma.getPassword().equals("emma1") : "Emmas Passwort ist falsch.";
//		assert emma.getAccounts().size()==2 : "Emma hat nicht 2 Konten.";
//	}
	
}
