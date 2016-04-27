package de.xbank.onlinebanking;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;

import org.jboss.logging.Logger;

import de.xbank.banking.Account;
import de.xbank.banking.AccountRegistry;
import de.xbank.customer.Customer;
import de.xbank.customer.CustomerRegistry;

/**
 * @author Thoene
 * Diese Session Bean implementiert das fuer das OnlineBanking bereitgestellte Interface.
 * 
 * Als Stateful Session Bean lässt sich diese Bean nicht als Web Service bereitstellen.
 * Sie könnte daher aus dieser Anwendung eigentlich auch mit samt dem Interface entfernt werden.
 * Für einen Java-Client wäre dieser alternative Zugang auf die Daten aber weiterhin interessant.
 */
@Stateful
@Remote(XbankOnlineService.class)
public class XbankOnlineServiceBean implements XbankOnlineService {

	private static final Logger logger = Logger.getLogger(XbankOnlineServiceBean.class);
	/**
	 * Hier wird der angemeldete User einer Session gespeichert.
	 */
	private Customer user;
	
	/**
	 * EJB zur Abfrage von Customer-Datensätzen
	 * Referenz auf die EJB wird per Dependency Injection gefüllt.
	 * Der hier angegebene Name könnte später über einen Deployment Deskriptor geändert werden. 
	 */
	@EJB(beanName = "CustomerRegistry", beanInterface = de.xbank.customer.CustomerRegistry.class)
	private CustomerRegistry customerRegistry;
	
	/**
	 * EJB zur Abfrage von Account-Datensätzen
	 * Referenz auf die EJB wird per Dependency Injection gefüllt.
	 * Wenn wie hier kein Bean-Name angegeben ist, sucht der Container eine passende EJB anhand des angegebenen Typs
	 */
	@EJB
	private AccountRegistry accountRegistry;
	
//	Die folgende Initialisierungsmethode kann entfallen, da wir nun mit Dependency Injection arbeiten.
//	/**
//	 * Anstelle eines Konstruktors wird diese Methode vom Container aufgerufen, um die Initialisierung
//	 * durchzuführen. Sie holt sich Referenzen auf benötigte andere EJBs.
//	 * @throws NamingException
//	 */
//	@PostConstruct
//	private void init() throws NamingException {
//	  Context context = new InitialContext();	
//	  this.customerRegistry = (CustomerRegistry) context.lookup(CUSTOMER_REGISTRY);
//	  this.accountRegistry = (AccountRegistry) context.lookup(ACCOUNT_REGISTRY);
//	}
	
	@Override
	public boolean login(String username, String password) throws InvalidLoginException {
		Customer customer = this.customerRegistry.findCustomerByName(username);
		if (customer != null && customer.getPassword().equals(password)) {
			this.user = customer;
			logger.info("Login erfolgreich.");
			return true;
		}
		else {
			logger.info("Login fehlgeschlagen, da Kunde unbekannt oder Passwort falsch. username="+username);
			throw new InvalidLoginException("Login fehlgeschlagen, da Kunde unbekannt oder Passwort falsch. username="+username);
		}
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
		Account konto = this.user.getAccountById(accountID);
		if (konto!=null) {
			result = konto.getBalance();
		}
		logger.info("Abfrage Saldo Konto " + accountID + " liefert: "+result);
		return result;
	}

	@Override
	public BigDecimal transfer(int fromAccount, int toAccount, BigDecimal amount) throws NoSessionException {
		validateLogin();		
		BigDecimal result = null;
		Account source = this.user.getAccountById(fromAccount);
		Account target = this.accountRegistry.findAccountById(toAccount);
		if (source!=null && target!=null) {
			source.decrease(amount);
			target.increase(amount);
			result = source.getBalance();
		}
		logger.info("Ueberweisung von Konto " + fromAccount + " liefert: "+result);		
		return result;
	}

	@Override
	public List<Account> getMyAccounts() throws NoSessionException {
		validateLogin();
		List<Account> result = this.user.getAccounts();
		logger.info("Abfrage eigener Konten liefert: "+result);		
		return result;
	}
	
	
	public String toString() {
		return "Hello, I'm an instance of XbankOnlineServiceImpl!";
	}

	private void validateLogin() throws NoSessionException {
		if (this.user==null) throw new NoSessionException("Bitte zunächst ein Login durchführen.");
	}
	
}
