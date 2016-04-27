package de.xbank.onlinebanking;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import org.jboss.logging.Logger;

import de.xbank.banking.Account;
import de.xbank.banking.AccountRegistry;
import de.xbank.customer.Customer;
import de.xbank.customer.CustomerRegistry;
import de.xbank.dto.AccountBalanceResponse;
import de.xbank.dto.AccountListResponse;
import de.xbank.dto.ReturncodeResponse;
import de.xbank.dto.TransferMoneyResponse;
import de.xbank.dto.UserLoginResponse;
import de.xbank.session.SessionManager;
import de.xbank.session.XbankSession;
import de.xbank.util.DtoAssembler;

/**
 * @author Thoene
 * Diese Stateless Session Bean implementiert das fuer das OnlineBanking bereitgestellte Interface.
 *
 */

@Stateless
public class XbankOnlineIntegration {

	private static final Logger logger = Logger.getLogger(XbankOnlineIntegration.class);
	
	/**
	 * EJB zur Abfrage von Customer-Datensätzen
	 * Referenz auf die EJB wird per Dependency Injection gefüllt. 
	 */
	@EJB(beanName = "CustomerRegistry", beanInterface = de.xbank.customer.CustomerRegistry.class)
	private CustomerRegistry customerRegistry;
	
	/**
	 * EJB zur Abfrage von Account-Datensätzen
	 * Referenz auf die EJB wird per Dependency Injection gefüllt.
	 */
	@EJB
	private AccountRegistry accountRegistry;
	
	/**
	 * EJB zur Verwaltung der Sessions
	 */
	private SessionManager sessionManager;

	/**
	 * EJB zur Erzeugung von DataTransferObjects
	 */
	private DtoAssembler dtoAssembler;

	private XbankSession getSession(int sessionId) throws NoSessionException {
		XbankSession session = sessionManager.findSessionById(sessionId);
		if (session==null)
			throw new NoSessionException("Bitte zunächst ein Login durchführen.");
		else
			return session;
	}

	public UserLoginResponse login(String username, String password) {
		UserLoginResponse response = new UserLoginResponse();
		try {
			Customer user = this.customerRegistry.findCustomerByName(username);		
			if (user != null && user.getPassword().equals(password)) {
				logger.info("Login erfolgreich.");
				int sessionId = sessionManager.createSession(user);
				response.setSessionId(sessionId);
			}
			else {
				logger.info("Login fehlgeschlagen, da Kunde unbekannt oder Passwort falsch. username=" + username);
				throw new InvalidLoginException("Login fehlgeschlagen, da Kunde unbekannt oder Passwort falsch. username="+username);
			}
		}
		catch (XbankException e) {
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		}
		return response;
	}

	public ReturncodeResponse logout(int sessionId) {
		sessionManager.closeSession(sessionId);
		ReturncodeResponse response = new ReturncodeResponse();
		logger.info("Logout successful.");
		return response;
	}

	public AccountListResponse getMyAccounts(int sessionId) {
		AccountListResponse response = new AccountListResponse();
		try {
			XbankSession session = getSession(sessionId);
			List<Account> accountList = session.getUser().getAccounts();
			response.setAccountList(dtoAssembler.makeDTO(accountList));
			logger.info("Result of getMyAccounts(): "+accountList);		
		}
		catch (XbankException e) {
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		}
		return response;
	}

	public AccountBalanceResponse getBalance(int sessionId, int accountId) {
		logger.info("Method call: getBalance ("+sessionId+", "+ accountId +")");
		AccountBalanceResponse response = new AccountBalanceResponse();
		try {
			XbankSession session = getSession(sessionId);
			Account account = session.getUser().getAccountById(accountId);
			if (account!=null) {
				response.setBalance(account.getBalance());
				response.setAccountId(account.getId());
				logger.info("Balance query for account " + account.getId() + " results in: "+ account.getBalance());
			}
		}
		catch (XbankException e) {
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		}
		return response;
	}

	public TransferMoneyResponse transfer(int sessionId, int sourceAccount, int targetAccount, BigDecimal amount) {
		logger.info("Method call: transfer ("+sessionId+", "+ sourceAccount +", "+ targetAccount+", "+ amount+")");
		TransferMoneyResponse response = new TransferMoneyResponse();
		try {
			XbankSession session = getSession(sessionId);
			Account source = session.getUser().getAccountById(sourceAccount);
			Account target = this.accountRegistry.findAccountById(targetAccount);
			if (source!=null && target!=null) {
				source.decrease(amount);
				target.increase(amount);
				response.setNewBalance(source.getBalance());
				logger.info("Transfer from account " + source + " changes its balance to "+ source.getBalance());
			}
		}
		catch (XbankException e) {
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		}
		return response;
	}
	
}