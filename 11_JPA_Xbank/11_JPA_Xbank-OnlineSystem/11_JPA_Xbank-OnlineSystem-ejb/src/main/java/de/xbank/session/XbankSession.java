package de.xbank.session;

import java.util.Date;
import java.util.Random;

import de.xbank.customer.Customer;

public class XbankSession {

	private int id;
	private Customer user;
	private Date creationTime;
	
	public XbankSession(Customer user) {
		this.id = new Random().nextInt(Integer.MAX_VALUE);
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
