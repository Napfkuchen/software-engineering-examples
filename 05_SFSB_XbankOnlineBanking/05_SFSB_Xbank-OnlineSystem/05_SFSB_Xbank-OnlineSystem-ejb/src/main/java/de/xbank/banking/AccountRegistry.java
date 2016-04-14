package de.xbank.banking;

import java.util.HashMap;

import de.xbank.common.Account;


/**
 * Klasse AccountRegistry als Singleton.
 * 
 * Alle vorhandenen Account-Objekte sollen hier registriert werden, damit die AccountRegistry
 * als zentrales Verzeichnis fungieren kann.
 */
public class AccountRegistry {
	
	private static AccountRegistry singleInstance = new AccountRegistry();
	
	private HashMap<Integer,Account> accounts;
	
	private AccountRegistry() {
		accounts = new HashMap<>();
	}
	
	public static AccountRegistry getInstance() {
		return singleInstance;
	}
	
	public Account findAccountById(int id) {
		return this.accounts.get(id);
	}
	
	public void addKonto(Account newAccount) {
		this.accounts.put(newAccount.getId(), newAccount);
	}
	
}
