package de.xbank.onlinebanking;

public class XbankException extends Exception {

	private static final long serialVersionUID = -1658425297634781761L;

	private int errorCode;
	
	public XbankException(int errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

}
