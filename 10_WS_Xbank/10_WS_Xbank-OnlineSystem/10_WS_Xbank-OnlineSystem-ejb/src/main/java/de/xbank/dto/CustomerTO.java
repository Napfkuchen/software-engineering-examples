package de.xbank.dto;

import java.io.Serializable;
import java.util.HashMap;

import de.xbank.banking.Account;


public class CustomerTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String userName;
	private String password;
	private HashMap<Integer,Account> accounts;
	
	public CustomerTO() {
	}
	
	public CustomerTO(int id, String userName, String password,
			HashMap<Integer, Account> accounts) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.accounts = accounts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public HashMap<Integer, Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(HashMap<Integer, Account> accounts) {
		this.accounts = accounts;
	}
	
	
	
}
