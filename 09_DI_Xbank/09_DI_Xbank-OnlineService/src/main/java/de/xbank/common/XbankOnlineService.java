package de.xbank.common;

import java.math.BigDecimal;
import java.util.Set;

/**
 * Dieses Business Interface definiert die Schnittstelle zwischen zum OnlinebankingSystem der Xbank.
 * 
 * @author Thoene  
 */
public interface XbankOnlineService {
	
	/**
	 * Operation zum Einloggen mit Username und Password.
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean login(String username, String password) throws InvalidLoginException;
	
	/**
	 * Operation zum Ausloggen. Schliesst die Session des Nutzers.
	 * @throws NoSessionException
	 */
	public void logout() throws NoSessionException;
	
	
	/**
	 * Operation zum Auslesen aller eigenen Konten
	 * @return
	 */
	public Set<Account> getMyAccounts() throws NoSessionException;
	
	/**
	 * Operation zur Abfrage eines Kontostandes
	 * @param accountID
	 * @return
	 * @throws NoSessionException
	 */
	public BigDecimal getBalance(int accountID) throws NoSessionException;
	
	/**
	 * Operation zur Ueberweisung eines Geldbetrags von einem Quell- zu einem Zielkonto
	 * @param fromAccount
	 * @param toAccount
	 * @param amount
	 * @return
	 * @throws NoSessionException
	 */
	public BigDecimal transfer(int fromAccount, int toAccount, BigDecimal amount) throws NoSessionException;
	
}
