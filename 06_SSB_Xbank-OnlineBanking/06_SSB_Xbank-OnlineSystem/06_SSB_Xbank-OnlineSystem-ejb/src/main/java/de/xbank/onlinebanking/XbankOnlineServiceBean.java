package de.xbank.onlinebanking;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;

import org.jboss.logging.Logger;

import de.xbank.banking.AccountRegistry;
import de.xbank.common.Account;
import de.xbank.common.Customer;
import de.xbank.common.NoSessionException;
import de.xbank.common.XbankOnlineService;
import de.xbank.customer.CustomerRegistry;

/**
 * @author Thoene
 * Diese Stateful Session Bean implementiert das fuer das OnlineBanking bereitgestellte Interface.
 *
 */
@Stateful
@Remote(XbankOnlineService.class)
public class XbankOnlineServiceBean implements XbankOnlineService {

	private static final Logger logger = Logger.getLogger(XbankOnlineServiceBean.class);
	
	private Customer user;
	
	@Override
	public boolean login(String username, String password) {
		boolean success = false;
		this.user = CustomerRegistry.getInstance().findCustomerByName(username);
		if (user != null && user.getPassword().equals(password)) {
			success = true;
			logger.info("Login erfolgreich.");
		}
		else {
			logger.info("Login fehlgeschlagen, da Kunde unbekannt oder Passwort falsch. username="+username);
		}
		return success;
	}

	@Override
	@Remove
	public void logout() throws NoSessionException {
		validateLogin();
		logger.info("Logout erfolgreich.");
	}

	@Override
	public BigDecimal getBalance(int accountID) throws NoSessionException {
		validateLogin();
		BigDecimal result = null;
		Account konto = user.getAccountById(accountID);
		if (konto!=null) {
			result = konto.getBalance();
		}
		logger.info("Abfrage Saldo Konto " + accountID + " liefert: "+result);
		return result;
	}

	@Override
	public BigDecimal transfer(int fromAccount, int toAccount, BigDecimal amount) throws NoSessionException  {
		validateLogin();
		BigDecimal result = null;
		Account source = user.getAccountById(fromAccount);
		Account target = AccountRegistry.getInstance().findAccountById(toAccount);
		if (source!=null && target!=null) {
			source.decrease(amount);
			target.increase(amount);
			result = source.getBalance();
		}
		logger.info(" Ueberweisung von Konto " + fromAccount + " liefert: "+result);		
		return result;
	}

	@Override
	public Set<Account> getMyAccounts() throws NoSessionException  {
		validateLogin();
		Set<Account> result = user.getAccounts();
		logger.info(" Abfrage eigener Konten liefert: "+result);		
		return result;
	}
	
	
	public String toString() {
		return "Hello, I'm an instance of XbankOnlineServiceBean!";
	}

	/**
	 * Checks if attribute "user" is set as done during login().
	 * @throws NoSessionException
	 */
	private void validateLogin() throws NoSessionException {
		if (user == null) {
			throw new NoSessionException("Bitte zunächst einen Login durchführen");
		}
	}
	
}
