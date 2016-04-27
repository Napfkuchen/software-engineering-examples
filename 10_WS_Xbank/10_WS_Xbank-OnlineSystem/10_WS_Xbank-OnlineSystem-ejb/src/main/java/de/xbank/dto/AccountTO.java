package de.xbank.dto;

import java.math.BigDecimal;

public class AccountTO extends DataTransferObject {
	
	private static final long serialVersionUID = 3440740273700082798L;
	
	private int id;
	private BigDecimal balance;
	private int ownerId;
	
	
	public AccountTO() {
	}

	public AccountTO(int id, BigDecimal balance, int ownerId) {
		super();
		this.id = id;
		this.balance = balance;
		this.ownerId = ownerId;
	}


	public String toString() {
		return "Account " + this.id + " (Balance=" + this.balance + ", Owner=" + this.getOwnerId() + ")";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public BigDecimal getBalance() {
		return balance;
	}


	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}


	public int getOwnerId() {
		return ownerId;
	}


	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	
}
