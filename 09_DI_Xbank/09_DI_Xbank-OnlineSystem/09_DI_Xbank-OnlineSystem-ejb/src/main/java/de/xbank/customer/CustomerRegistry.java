package de.xbank.customer;

import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.DependsOn;
import javax.ejb.EJB;
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
 * Klasse CustomerRegistry als Singleton Session Bean. Alle vorhandenen Customer-Objekte sollen hier registriert werden, 
 * damit die Registry als zentrales Customerverzeichnis dienen kann.
 */
@Singleton
@Startup
@DependsOn("AccountRegistry")
//Dies ist ein Eintrag im lokalen ENC für Lookups innerhalb dieser Session Bean
@EJB(name="ejb/AccountManager", beanInterface=AccountRegistry.class, beanName="AccountRegistry")
public class CustomerRegistry {
	
	private static final Logger logger = Logger.getLogger(CustomerRegistry.class);
	private HashMap<String,Customer> customers;
	
	@Resource
	private String customer1, password1, customer2, password2;
		
	@PostConstruct
	private void init() throws NamingException {
		customers = new HashMap<String, Customer>();
		//erzeuge ein paar Beispieldaten zu Kunden und Konten; die verwendeten Konstruktoren registrieren die erzeugten Objekte in 
		//zentralen Registries, sodass sie bei spaeteren Client-Requests wiedergefunden werden koennen.
		Customer joe = new Customer(customer1, password1);
		Customer emma = new Customer(customer2, password2);
		addCustomer(joe);
		addCustomer(emma);
		logger.info("Kunde angelegt: " + joe);
		logger.info("Kunde angelegt: " + emma);			

		//Konten anlegen
		Account joesAccount= new Account(joe);
		Account emmasAccount= new Account(emma);
		
		//AccountRegistry Bean nachschlagen und Konten einfügen
		AccountRegistry accountRegistry = (AccountRegistry) new InitialContext().lookup("java:comp/env/ejb/AccountManager");		
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