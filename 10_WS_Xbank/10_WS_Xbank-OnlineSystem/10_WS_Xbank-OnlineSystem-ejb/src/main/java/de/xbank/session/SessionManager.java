package de.xbank.session;

import java.util.HashMap;
import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import de.xbank.customer.Customer;


/**
 * Klasse SessionManager als Singleton Session Bean zur Verwaltung von Sessions.
 * Übergangslösung, so lange noch keine Sessions in der DB verwaltet werden.
 */
public class SessionManager {
	
	private HashMap<Integer,XbankSession> sessions;
	
	private void init() {
		sessions = new HashMap<>();
	}
	
	public XbankSession findSessionById(int id) {
		return this.sessions.get(id);
	}
	
	public int createSession(Customer user) {
		XbankSession newSession = new XbankSession(user);
		this.sessions.put(newSession.getId(), newSession);
		return newSession.getId();
	}

	public void closeSession(int id) {
		this.sessions.remove(id);
	}

}
