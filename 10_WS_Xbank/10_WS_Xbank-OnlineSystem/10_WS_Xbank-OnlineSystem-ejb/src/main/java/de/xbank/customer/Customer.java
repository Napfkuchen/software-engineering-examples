package de.xbank.customer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.xbank.banking.Account;


public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static int lastID = 0;
	
	private int id;
	private String userName;
	private String password;
	private HashMap<Integer,Account> accounts;
	
	public Customer(String userName, String password) {
		this.id = ++lastID;
		this.userName = userName;
		this.password = password;
		this.accounts = new HashMap<>();
	}
	
	public void addNewAccount(Account newAccount) {
		this.accounts.put(newAccount.getId(), newAccount);
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public Account getAccountById(int accountId) {
		return accounts.get(accountId);
	}

	public List<Account> getAccounts() {
		return new ArrayList<Account>(accounts.values());
	}

	public int getId() {
		return id;
	}

	public void setId(int customerId) {
		this.id = customerId;
	}
	
}
