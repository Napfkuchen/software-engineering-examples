package de.xbank.banking;

import java.io.Serializable;
import java.math.BigDecimal;

import de.xbank.customer.Customer;

public class Account implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static int lastID=0;
	
	private int id;
	private BigDecimal balance;
	private Customer owner;
	
	public Account(Customer owner) {
		this.id = ++lastID;
		this.balance = BigDecimal.ZERO;
		this.owner = owner;
		this.owner.addNewAccount(this);
	}
	
	public int getId() {
		return id;
	}
	
	public BigDecimal getBalance() {
		return balance;
	}
	
	public Customer getOwner() {
		return owner;
	}
	
	public void increase(BigDecimal amount) {
		this.balance = this.balance.add(amount);
	}
	
	public void decrease(BigDecimal amount) {
		this.balance = this.balance.subtract(amount);
	}
	
	public String toString() {
		return "Account " + this.id + " (Balance=" + this.balance + ", Owner=" + this.getOwner().getUserName() + ")";
	}
	
}
