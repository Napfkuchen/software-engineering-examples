package de.xbank.dto;

public class UserLoginResponse extends ReturncodeResponse {

	private static final long serialVersionUID = -3173158310918408228L;

	private int sessionId;
	private CustomerTO customer;
	
	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

	public CustomerTO getCustomer() {
		return this.customer;
	}

	public void setCustomer(CustomerTO customer) {
		this.customer = customer;
	}

}
