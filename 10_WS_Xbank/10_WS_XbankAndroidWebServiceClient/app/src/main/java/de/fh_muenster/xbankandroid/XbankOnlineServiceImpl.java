package de.fh_muenster.xbankandroid;

import com.Wsdl2Code.WebServices.XbankOnlineIntegrationService.XbankOnlineIntegrationService;
import com.Wsdl2Code.WebServices.XbankOnlineIntegrationService.returncodeResponse;
import com.Wsdl2Code.WebServices.XbankOnlineIntegrationService.userLoginResponse;

import java.math.BigDecimal;
import java.util.ArrayList;
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
        //TODO: implement this method using the webservice
        return new ArrayList<>();
    }

    /**
     * returns the current balance of the given account
     */
    @Override
    public BigDecimal getBalance(int accountID) throws NoSessionException {
        //TODO: implement this method using the webservice
        return null;
    }

    /**
     * initiates a money transfer between two accounts
     */
    @Override
    public BigDecimal transfer(int fromAccount, int toAccount, BigDecimal amount) throws NoSessionException {
        //TODO: implement this method using the webservice
        return null;
    }

}
