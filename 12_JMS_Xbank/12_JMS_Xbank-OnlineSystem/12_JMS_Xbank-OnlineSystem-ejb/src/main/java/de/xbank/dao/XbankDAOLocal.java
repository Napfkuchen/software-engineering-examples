package de.xbank.dao;

import javax.ejb.Local;

import de.xbank.entities.Account;
import de.xbank.entities.Customer;
import de.xbank.entities.XbankSession;

@Local
public interface XbankDAOLocal {

	public Customer findCustomerByName(String userName);
	public Account findAccountById(int id);
	public XbankSession findSessionById(int id);
	public int createSession(Customer user);
	public void closeSession(int id);
}
