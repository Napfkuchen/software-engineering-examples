package de.xbank.client;

import java.math.BigDecimal;
import java.util.List;

import de.xbank.onlinebanking.AccountBalanceResponse;
import de.xbank.onlinebanking.AccountListResponse;
import de.xbank.onlinebanking.AccountTO;
import de.xbank.onlinebanking.TransferMoneyResponse;
import de.xbank.onlinebanking.UserLoginResponse;
import de.xbank.onlinebanking.XbankOnlineIntegration;
import de.xbank.onlinebanking.XbankOnlineIntegrationService;


/**
 * @author Thoene
 * Diese Klasse realisiert einen rudimentaeren Client zum Zugriff auf das OnlineBankingSystem.
 */
public class SimpleOnlineBankingClient {

	//Testdaten:
	private static final int JOES_KONTO	=1;
	private static final int EMMAS_KONTO=3;
	
	private static XbankOnlineIntegration remoteSystem;
	
	/**
	 * In dieser Main-Methode werden Requests an den Onlinebanking-Server abgeschickt. Sie koennen die durchgefuehrten
	 * Szenarien nach Belieben anpassen.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
		   XbankOnlineIntegrationService service = new XbankOnlineIntegrationService();
		   remoteSystem = service.getXbankOnlineIntegrationPort();
 	       
 	       //Zeige, welche Referenz auf das Server-Objekt der Client erhalten hast:
 	       System.out.println("Client hat folgendes Server-Objekt erhalten:");
 	       System.out.println(remoteSystem.toString());
 	       System.out.println();
 	       
 	       //Test-Szeanarien ausfuehren:
		   szenarioEmma();
		   szenarioJoe();		   	       
		   szenarioEmma();
		   
		}
		catch (Exception ex) {
		   	System.out.println(ex);
		   	ex.printStackTrace();
		}
	}
	
    /**
     * Test-Szenario: Emma meldet sich an und fragt ihren Kontostand ab.
     */
	private static void szenarioEmma() {
	   System.out.println("============================================================");
       UserLoginResponse loginResponse = remoteSystem.login("emma", "emma1");
       if (loginResponse.getReturnCode()==0) {
    	   int sessionId = loginResponse.getSessionId();
		   System.out.println("Emma hat sich angemeldet, um ihren Kontostand abzufragen.");
		   
		   AccountBalanceResponse accountBalanceResponse = remoteSystem.getBalance(sessionId, EMMAS_KONTO);
		   System.out.println("Auf Emmas Konto " + EMMAS_KONTO + " betraegt der Saldo: " + accountBalanceResponse.getBalance());
		   
	       remoteSystem.logout(sessionId);
		   System.out.println("Emma hat sich abgemeldet.");
       }
       else {
    	   System.out.println(loginResponse.getMessage());
       }
	}

    /**
     * Test-Szenario: Joe meldet sich an, fragt seine Konten ab und überweist an Emma
     */
	private static void szenarioJoe() {
       UserLoginResponse loginResponse = remoteSystem.login("joe", "joe1");
       if (loginResponse.getReturnCode()==0) {
    	   int sessionId = loginResponse.getSessionId();
		   System.out.println("Joe hat sich angemeldet, um eine Ueberweisung aufzugeben.");

		   AccountListResponse accountListResponse = remoteSystem.getMyAccounts(sessionId); 
	       List<AccountTO> joesKonten = accountListResponse.getAccountList();
	       if (joesKonten.size()>0) {
	    	   //gib Joes Konten aus:
		       System.out.println("Joe hat folgende Konten:");
		       for (AccountTO k : joesKonten) {
		    	   System.out.println("Konto-Nr: " + k.getId() + " Saldo: " + k.getBalance());
		       }
		       System.out.println();
		       
		       TransferMoneyResponse transferResponse = remoteSystem.transfer(sessionId, JOES_KONTO, EMMAS_KONTO, new BigDecimal(33));
		       System.out.println("Joe hat von Konto "+ JOES_KONTO +" 33 EUR an Konto " + EMMAS_KONTO + " ueberwiesen.");
		       System.out.println("Der neue Saldo von Konto "+JOES_KONTO+" betraegt: " + transferResponse.getNewBalance());
	       }
	       remoteSystem.logout(sessionId);
		   System.out.println("Joe hat sich abgemeldet.");
	   }
       else {
    	   System.out.println(loginResponse.getMessage());
       }       
	}
	
}
