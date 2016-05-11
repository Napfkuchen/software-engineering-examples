package de.xbank.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.xbank.entities.Account;
import de.xbank.entities.Customer;
import de.xbank.entities.XbankSession;

/**
 * Session Bean implementation class XbankDAO
 */
@Stateless
public class XbankDAO implements XbankDAOLocal {

	@PersistenceContext
	EntityManager em;
	

	/**
     * @see XbankDAOLocal#findSessionById(int)
     */
    public XbankSession findSessionById(int id) {
    	return em.find(XbankSession.class, id);
    }

	/**
     * @see XbankDAOLocal#closeSession(int)
     */
    public void closeSession(int id) {
    	XbankSession session = em.find(XbankSession.class, id);
    	if (session != null) {
    		em.remove(session);
    	}
    }

	/**
     * @see XbankDAOLocal#findAccountById(int)
     */
    public Account findAccountById(int id) {
        return em.find(Account.class, id);
    }

	/**
     * @see XbankDAOLocal#findCustomerByName(String)
     */
    public Customer findCustomerByName(String userName) {
    	List results = em.createQuery("SELECT c FROM Customer c WHERE c.userName LIKE :custName")
    	                 .setParameter("custName", userName)
    	                 .getResultList();
    	if (results.size()==1) {
    	    return (Customer) results.get(0);
    	}
    	else {
    		return null;
    	}
    }

	/**
     * @see XbankDAOLocal#createSession(Customer)
     */
    public int createSession(Customer user) {
        XbankSession newSession = new XbankSession(user);
        em.persist(newSession);
        return newSession.getId();
    }

}
