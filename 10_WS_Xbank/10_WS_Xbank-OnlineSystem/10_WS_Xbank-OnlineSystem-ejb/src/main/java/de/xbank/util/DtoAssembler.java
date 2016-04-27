package de.xbank.util;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import de.xbank.banking.Account;
import de.xbank.customer.Customer;
import de.xbank.dto.AccountTO;
import de.xbank.dto.CustomerTO;

public class DtoAssembler {

  public AccountTO makeDTO(Account account) {
	  AccountTO dto = new AccountTO();
	  dto.setId(account.getId());
	  dto.setBalance(account.getBalance());
	  dto.setOwnerId(account.getOwner().getId());
	  return dto;
  }
	
  public List<AccountTO> makeDTO(List<Account> accounts) {
	  ArrayList<AccountTO> dtoList = new ArrayList<>();
	  for (Account a : accounts) {
		  dtoList.add(this.makeDTO(a));
	  }
	  return dtoList;
  }

  public CustomerTO makeDTO(Customer customer) {
	  CustomerTO dto = new CustomerTO();
	  dto.setId(customer.getId());
	  dto.setPassword(customer.getPassword());
	  dto.setUserName(customer.getUserName());
	  return dto;
  }

}
