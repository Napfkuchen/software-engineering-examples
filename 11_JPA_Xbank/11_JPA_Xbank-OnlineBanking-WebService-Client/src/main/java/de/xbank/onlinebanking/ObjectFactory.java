
package de.xbank.onlinebanking;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the de.xbank.onlinebanking package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetBalance_QNAME = new QName("http://onlinebanking.xbank.de/", "getBalance");
    private final static QName _GetBalanceResponse_QNAME = new QName("http://onlinebanking.xbank.de/", "getBalanceResponse");
    private final static QName _GetMyAccounts_QNAME = new QName("http://onlinebanking.xbank.de/", "getMyAccounts");
    private final static QName _GetMyAccountsResponse_QNAME = new QName("http://onlinebanking.xbank.de/", "getMyAccountsResponse");
    private final static QName _Login_QNAME = new QName("http://onlinebanking.xbank.de/", "login");
    private final static QName _LoginResponse_QNAME = new QName("http://onlinebanking.xbank.de/", "loginResponse");
    private final static QName _Logout_QNAME = new QName("http://onlinebanking.xbank.de/", "logout");
    private final static QName _LogoutResponse_QNAME = new QName("http://onlinebanking.xbank.de/", "logoutResponse");
    private final static QName _Transfer_QNAME = new QName("http://onlinebanking.xbank.de/", "transfer");
    private final static QName _TransferResponse_QNAME = new QName("http://onlinebanking.xbank.de/", "transferResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.xbank.onlinebanking
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CustomerTO }
     * 
     */
    public CustomerTO createCustomerTO() {
        return new CustomerTO();
    }

    /**
     * Create an instance of {@link CustomerTO.Accounts }
     * 
     */
    public CustomerTO.Accounts createCustomerTOAccounts() {
        return new CustomerTO.Accounts();
    }

    /**
     * Create an instance of {@link GetBalance }
     * 
     */
    public GetBalance createGetBalance() {
        return new GetBalance();
    }

    /**
     * Create an instance of {@link GetBalanceResponse }
     * 
     */
    public GetBalanceResponse createGetBalanceResponse() {
        return new GetBalanceResponse();
    }

    /**
     * Create an instance of {@link GetMyAccounts }
     * 
     */
    public GetMyAccounts createGetMyAccounts() {
        return new GetMyAccounts();
    }

    /**
     * Create an instance of {@link GetMyAccountsResponse }
     * 
     */
    public GetMyAccountsResponse createGetMyAccountsResponse() {
        return new GetMyAccountsResponse();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link Logout }
     * 
     */
    public Logout createLogout() {
        return new Logout();
    }

    /**
     * Create an instance of {@link LogoutResponse }
     * 
     */
    public LogoutResponse createLogoutResponse() {
        return new LogoutResponse();
    }

    /**
     * Create an instance of {@link Transfer }
     * 
     */
    public Transfer createTransfer() {
        return new Transfer();
    }

    /**
     * Create an instance of {@link TransferResponse }
     * 
     */
    public TransferResponse createTransferResponse() {
        return new TransferResponse();
    }

    /**
     * Create an instance of {@link UserLoginResponse }
     * 
     */
    public UserLoginResponse createUserLoginResponse() {
        return new UserLoginResponse();
    }

    /**
     * Create an instance of {@link ReturncodeResponse }
     * 
     */
    public ReturncodeResponse createReturncodeResponse() {
        return new ReturncodeResponse();
    }

    /**
     * Create an instance of {@link Account }
     * 
     */
    public Account createAccount() {
        return new Account();
    }

    /**
     * Create an instance of {@link AccountListResponse }
     * 
     */
    public AccountListResponse createAccountListResponse() {
        return new AccountListResponse();
    }

    /**
     * Create an instance of {@link AccountTO }
     * 
     */
    public AccountTO createAccountTO() {
        return new AccountTO();
    }

    /**
     * Create an instance of {@link AccountBalanceResponse }
     * 
     */
    public AccountBalanceResponse createAccountBalanceResponse() {
        return new AccountBalanceResponse();
    }

    /**
     * Create an instance of {@link TransferMoneyResponse }
     * 
     */
    public TransferMoneyResponse createTransferMoneyResponse() {
        return new TransferMoneyResponse();
    }

    /**
     * Create an instance of {@link CustomerTO.Accounts.Entry }
     * 
     */
    public CustomerTO.Accounts.Entry createCustomerTOAccountsEntry() {
        return new CustomerTO.Accounts.Entry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBalance }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://onlinebanking.xbank.de/", name = "getBalance")
    public JAXBElement<GetBalance> createGetBalance(GetBalance value) {
        return new JAXBElement<GetBalance>(_GetBalance_QNAME, GetBalance.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBalanceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://onlinebanking.xbank.de/", name = "getBalanceResponse")
    public JAXBElement<GetBalanceResponse> createGetBalanceResponse(GetBalanceResponse value) {
        return new JAXBElement<GetBalanceResponse>(_GetBalanceResponse_QNAME, GetBalanceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMyAccounts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://onlinebanking.xbank.de/", name = "getMyAccounts")
    public JAXBElement<GetMyAccounts> createGetMyAccounts(GetMyAccounts value) {
        return new JAXBElement<GetMyAccounts>(_GetMyAccounts_QNAME, GetMyAccounts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMyAccountsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://onlinebanking.xbank.de/", name = "getMyAccountsResponse")
    public JAXBElement<GetMyAccountsResponse> createGetMyAccountsResponse(GetMyAccountsResponse value) {
        return new JAXBElement<GetMyAccountsResponse>(_GetMyAccountsResponse_QNAME, GetMyAccountsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://onlinebanking.xbank.de/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://onlinebanking.xbank.de/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Logout }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://onlinebanking.xbank.de/", name = "logout")
    public JAXBElement<Logout> createLogout(Logout value) {
        return new JAXBElement<Logout>(_Logout_QNAME, Logout.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogoutResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://onlinebanking.xbank.de/", name = "logoutResponse")
    public JAXBElement<LogoutResponse> createLogoutResponse(LogoutResponse value) {
        return new JAXBElement<LogoutResponse>(_LogoutResponse_QNAME, LogoutResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Transfer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://onlinebanking.xbank.de/", name = "transfer")
    public JAXBElement<Transfer> createTransfer(Transfer value) {
        return new JAXBElement<Transfer>(_Transfer_QNAME, Transfer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransferResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://onlinebanking.xbank.de/", name = "transferResponse")
    public JAXBElement<TransferResponse> createTransferResponse(TransferResponse value) {
        return new JAXBElement<TransferResponse>(_TransferResponse_QNAME, TransferResponse.class, null, value);
    }

}
