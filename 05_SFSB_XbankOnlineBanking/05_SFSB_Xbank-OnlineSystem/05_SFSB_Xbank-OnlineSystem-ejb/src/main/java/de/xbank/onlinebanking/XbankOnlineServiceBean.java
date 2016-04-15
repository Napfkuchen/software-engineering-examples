package de.xbank.onlinebanking;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.jboss.logging.Logger;

import de.xbank.banking.AccountRegistry;
import de.xbank.common.Account;
import de.xbank.common.Customer;
import de.xbank.common.NoSessionException;
import de.xbank.common.XbankOnlineService;
import de.xbank.customer.CustomerRegistry;
import de.xbank.session.SessionRegistry;
import de.xbank.session.UserSession;

/**
 * @author Thoene
 * Diese Stateless Session Bean implementiert das fuer das OnlineBanking bereitgestellte Interface.
 *
 */
@Stateless
@Remote(XbankOnlineService.class)
public class XbankOnlineServiceBean implements XbankOnlineService {

	private static final Logger logger = Logger.getLogger(XbankOnlineServiceBean.class);
	
	@Override
	public String login(String username, String password) {
		String sessionID = null;
		Customer kunde = CustomerRegistry.getInstance().findCustomerByName(username);
		if (kunde != null && kunde.getPassword().equals(password)) {
			UserSession newSession = new UserSession(kunde);
			sessionID = newSession.getSessionID();
			logger.info(newSession + " Login erfolgreich.");
		}
		else {
			logger.info("Login fehlgeschlagen, da Kunde unbekannt oder Passwort falsch. username="+username);
		}
		return sessionID;
	}

	@Override
	public void logout(String sessionID) throws NoSessionException {
		UserSession session = getSession(sessionID);
		SessionRegistry.getInstance().removeSession(session);
		logger.info(session + " Logout erfolgreich.");
	}

	@Override
	public BigDecimal getBalance(String sessionID, int accountID) throws NoSessionException {
		UserSession session = getSession(sessionID);
		BigDecimal result = null;
		Account konto = session.getUser().getAccountById(accountID);
		if (konto!=null) {
			result = konto.getBalance();
		}
		logger.info(session + " Abfrage Saldo Konto " + accountID + " liefert: "+result);
		return result;
	}

	@Override
	public BigDecimal transfer(String sessionID, int fromAccount, int toAccount, BigDecimal amount) throws NoSessionException  {
		UserSession session = getSession(sessionID);
		BigDecimal result = null;
		Account source = session.getUser().getAccountById(fromAccount);
		Account target = AccountRegistry.getInstance().findAccountById(toAccount);
		if (source!=null && target!=null) {
			source.decrease(amount);
			target.increase(amount);
			result = source.getBalance();
		}
		logger.info(session + " Ueberweisung von Konto " + fromAccount + " liefert: "+result);		
		return result;
	}

	@Override
	public Set<Account> getMyAccounts(String sessionID) throws NoSessionException  {
		UserSession session = getSession(sessionID);
		Set<Account> result = new HashSet<Account>();
		Customer k = session.getUser();
		result = k.getAccounts();
		logger.info(session + " Abfrage eigener Konten liefert: "+result);		
		return result;
	}
	
	
	public String toString() {
		return "Hello, I'm an instance of XbankOnlineServiceImpl!";
	}

	private UserSession getSession(String sessionID) throws NoSessionException {
		UserSession session = SessionRegistry.getInstance().findSession(sessionID);
		if (session==null)
			throw new NoSessionException("Session-ID unbekannt.");
		else
			return session;
	}
	
}
