package de.xbank.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
public class Customer implements Serializable {
		
	private static final long serialVersionUID = 1397678269371617855L;
	
	@Id @GeneratedValue
	private int id;

    @Column(unique=true, nullable=false)
	private String userName;
    
	private String password;
	
	/**
	 * Bidirektionale Eins-zu-Viele Behiehung
	 * FetchType.LAZY = lazy loading (alternativ: FetchType.EAGER)
	 * @Mapkey benutzt die Id als Key fuer die Map
	 */
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="owner") @MapKey
	private Map<Integer,Account> accounts;

	public Customer() { }
	
	public Customer(String userName, String password) {
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
	
	public String toString() {
		return "Customer (" + this.getId() + "): " + this.getUserName() + "/" + this.getPassword();
	}
	
}
