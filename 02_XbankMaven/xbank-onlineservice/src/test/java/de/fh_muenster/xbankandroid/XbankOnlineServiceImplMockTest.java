package de.fh_muenster.xbankandroid;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.fh_muenster.xbank.Customer;
import de.fh_muenster.xbank.XbankOnlineService;

public class XbankOnlineServiceImplMockTest {

	private XbankOnlineService onlineService;
	
	@Before
	public void setUp() {
		onlineService = new XbankOnlineServiceImplMock();
	}
	
	@Test
	public void testLogin() throws Exception {
		Customer login = onlineService.login("user1", "password");
		assertEquals("TestBenutzer", login.getUserName());
	}
	
}
