package de.xbank.banking;

import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import de.xbank.common.Account;


/**
 * Klasse AccountRegistry als Singleton.
 * 
 * Alle vorhandenen Account-Objekte sollen hier registriert werden, damit die AccountRegistry
 * als zentrales Verzeichnis fungieren kann.
 */
@Singleton
@Startup
public class AccountRegistry {
	
	private static AccountRegistry singleInstance = new AccountRegistry();
	
	private HashMap<Integer,Account> accounts;
	
	@PostConstruct
	private void init() {
		accounts = new HashMap<Integer, Account>();
	}
	
	@Lock(LockType.READ)
	public Account findAccountById(int id) {
		return this.accounts.get(id);
	}
	
	@Lock(LockType.WRITE)
	public void addKonto(Account newAccount) {
		this.accounts.put(newAccount.getId(), newAccount);
	}
	
}
