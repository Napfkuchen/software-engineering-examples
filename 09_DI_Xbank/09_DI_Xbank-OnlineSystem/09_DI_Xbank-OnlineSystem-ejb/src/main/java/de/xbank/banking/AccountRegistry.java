package de.xbank.banking;

import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

import de.xbank.common.Account;


/**
 * Klasse AccountRegistry als Singleton Session Bean.
 * 
 * Alle vorhandenen Account-Objekte sollen hier registriert werden, damit die AccountRegistry
 * als zentrales Verzeichnis fungieren kann.
 */
@Singleton
public class AccountRegistry {
	
	private HashMap<Integer,Account> accounts;
	
	@PostConstruct
	private void init() {
		accounts = new HashMap<>();
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
