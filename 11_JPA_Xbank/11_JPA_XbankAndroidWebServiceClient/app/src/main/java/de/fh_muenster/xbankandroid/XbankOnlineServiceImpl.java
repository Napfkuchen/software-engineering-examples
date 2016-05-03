package de.fh_muenster.xbankandroid;

import android.util.Log;

import com.Wsdl2Code.WebServices.XbankOnlineIntegrationService.XbankOnlineIntegrationService;
import com.Wsdl2Code.WebServices.XbankOnlineIntegrationService.accountBalanceResponse;
import com.Wsdl2Code.WebServices.XbankOnlineIntegrationService.accountListResponse;
import com.Wsdl2Code.WebServices.XbankOnlineIntegrationService.accountTO;
import com.Wsdl2Code.WebServices.XbankOnlineIntegrationService.returncodeResponse;
import com.Wsdl2Code.WebServices.XbankOnlineIntegrationService.transferMoneyResponse;
import com.Wsdl2Code.WebServices.XbankOnlineIntegrationService.userLoginResponse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import de.fh_muenster.xbank.Account;
import de.fh_muenster.xbank.Customer;
import de.fh_muenster.xbank.XbankOnlineService;
import de.fh_muenster.xbank.exceptions.InvalidLoginException;
import de.fh_muenster.xbank.exceptions.NoSessionException;

/**
 * This class implements the business interface using the web service.
 */
public class XbankOnlineServiceImpl implements XbankOnlineService {

    private XbankOnlineIntegrationService webservice;
    private int sessionId;

    /**
     * Constructor
     */
    public XbankOnlineServiceImpl() {
        this.webservice = new XbankOnlineIntegrationService();
    }

    @Override
    public Customer login(String username, String password) throws InvalidLoginException {
        userLoginResponse response = this.webservice.login(username, password);
        if (response.returnCodeField != 0)
            throw new InvalidLoginException("Logout not successful");
        this.sessionId = response.sessionId;
        return new Customer(response.customer.userName, response.customer.password);
    }

    @Override
    public void logout() throws NoSessionException {
        returncodeResponse response = this.webservice.logout(this.sessionId);
        if (response.returnCodeField != 0)
            throw new NoSessionException("Logout not successful");
    }

    /**
     * returns a list with all accounts of the current user
     */
    @Override
    public List<Account> getMyAccounts() throws NoSessionException {
        accountListResponse response = this.webservice.getMyAccounts(this.sessionId);
        if (response.returnCodeField != 0)
            throw new NoSessionException("GetMyAccounts not successful");

        //Umkopieren der Liste aus Response in Zielstruktur:
        List<Account> result = new ArrayList<>();
        Enumeration<accountTO> accountEnum = response.accountList.elements();
        while (accountEnum.hasMoreElements()){
            accountTO account = accountEnum.nextElement();
            result.add(new Account(account.id, new BigDecimal(account.balance)));
        }
        return result;
    }

    /**
     * returns the current balance of the given account
     */
    @Override
    public BigDecimal getBalance(int accountID) throws NoSessionException {
        accountBalanceResponse response = this.webservice.getBalance(this.sessionId, accountID);
        if (response.returnCodeField != 0)
            throw new NoSessionException("GetBalance not successful");

        BigDecimal result = new BigDecimal(response.balance);
        return result;
    }

    /**
     * initiates a money transfer between two accounts
     */
    @Override
    public BigDecimal transfer(int fromAccount, int toAccount, BigDecimal amount) throws NoSessionException {
        transferMoneyResponse response = this.webservice.transfer(this.sessionId, fromAccount, toAccount, amount.doubleValue(), true);
        if (response.returnCodeField != 0)
            throw new NoSessionException("Transfer not successful");

        BigDecimal result = new BigDecimal(response.newBalance);
        return result;
    }

}
