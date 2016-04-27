package de.xbank.session;

import java.util.Date;

import de.xbank.customer.Customer;

public class XbankSession {

	private static int lastID = 0;
	
	private int id;
	private Customer user;
	private Date creationTime;
	
	public XbankSession(Customer user) {
		this.id = ++lastID;
		this.user = user;
		this.creationTime = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getUser() {
		return user;
	}

	public void setUser(Customer user) {
		this.user = user;
	}

	public Date getCreationTime() {
		return creationTime;
	}

}
