package de.xbank.customer;

import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.logging.Logger;

import de.xbank.banking.AccountRegistry;
import de.xbank.common.Account;
import de.xbank.common.Customer;

/**
 * Klasse KundeRegistry als Singleton. Alle vorhandenen Kunde-Objekte sollen
 * hier registriert werden, damit die KundenRegistry als zentrales
 * Kundenverzeichnis fungieren kann.
 */
@Singleton
@Startup
@DependsOn("AccountRegistry")
public class CustomerRegistry {

	private static final Logger logger = Logger.getLogger(CustomerRegistry.class);

	private HashMap<String, Customer> customers;

	@PostConstruct
	public void init() throws NamingException {
		this.customers = new HashMap<String, Customer>();

		Customer joe = new Customer("joe", "joe1");
		Customer emma = new Customer("emma", "emma1");
		this.addCustomer(joe);
		this.addCustomer(emma);
		logger.info("Kunde angelegt: " + joe);
		logger.info("Kunde angelegt: " + emma);

		Account joesAccount = new Account(joe);
		Account emmasAccount = new Account(emma);
		AccountRegistry accountRegistry = (AccountRegistry) new InitialContext().lookup(
				"java:global/06_SSB_Xbank-OnlineSystem-ear/06_SSB_Xbank-OnlineSystem-ejb/AccountRegistry!de.xbank.banking.AccountRegistry");
		accountRegistry.addKonto(joesAccount);
		accountRegistry.addKonto(emmasAccount);

		logger.info("Konto angelegt: " + joesAccount);
		logger.info("Konto angelegt: " + emmasAccount);
	}

	@Lock(LockType.READ)
	public Customer findCustomerByName(String userName) {
		return this.customers.get(userName);
	}

	@Lock(LockType.WRITE)
	public void addCustomer(Customer newCustomer) {
		this.customers.put(newCustomer.getUserName(), newCustomer);
	}

}
