package de.xbank.customer;

import java.util.HashMap;

import org.jboss.logging.Logger;

import de.xbank.banking.AccountRegistry;
import de.xbank.common.Account;
import de.xbank.common.Customer;


/**
 * Klasse KundeRegistry als Singleton. Alle vorhandenen Kunde-Objekte sollen hier registriert werden, damit die KundenRegistry
 * als zentrales Kundenverzeichnis fungieren kann.
 */
public class CustomerRegistry {
	
	private static final Logger logger = Logger.getLogger(CustomerRegistry.class);
	private static CustomerRegistry singleInstance;
	
	private HashMap<String,Customer> customers;
	
	private CustomerRegistry() {
		customers = new HashMap<String, Customer>();
	}
	
	public static CustomerRegistry getInstance() {
        if (singleInstance==null) {
        	singleInstance = new CustomerRegistry();
			//erzeuge ein paar Beispieldaten zu Kunden und Konten; die verwendeten Konstruktoren registrieren die erzeugten Objekte in 
			//zentralen Registries, sodass sie bei spaeteren Client-Requests wiedergefunden werden koennen.
			Customer joe = new Customer("joe", "joe1");
			Customer emma = new Customer("emma", "emma1");
			singleInstance.addCustomer(joe);
			singleInstance.addCustomer(emma);
			logger.info("Kunde angelegt: " + joe);
			logger.info("Kunde angelegt: " + emma);			

			Account joesAccount= new Account(joe);
			Account emmasAccount= new Account(emma);
			AccountRegistry.getInstance().addKonto(joesAccount);
			AccountRegistry.getInstance().addKonto(emmasAccount);
			
			logger.info("Konto angelegt: " + joesAccount);
			logger.info("Konto angelegt: " + emmasAccount);			
        }
		return singleInstance;
	}
	
	public Customer findCustomerByName(String userName) {
		return this.customers.get(userName);
	}
	
	public void addCustomer(Customer newCustomer) {
		this.customers.put(newCustomer.getUserName(), newCustomer);
	}
	
}
