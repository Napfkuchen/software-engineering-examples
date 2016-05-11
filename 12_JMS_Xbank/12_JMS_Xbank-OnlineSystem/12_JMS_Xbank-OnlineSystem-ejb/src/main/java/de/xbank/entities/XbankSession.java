package de.xbank.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class XbankSession {

	@Id @GeneratedValue
	private int id;
	@ManyToOne
	private Customer user;
	private Date creationTime;
	
	public XbankSession() {	}
	
	
	public XbankSession(Customer user) {
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
