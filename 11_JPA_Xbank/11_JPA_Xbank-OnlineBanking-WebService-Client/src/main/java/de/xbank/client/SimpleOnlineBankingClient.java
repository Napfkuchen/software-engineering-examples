package de.xbank.client;

import java.math.BigDecimal;
import java.util.List;

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
	private static int joesKonto;
	private static int emmasKonto;
	
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

		   AccountListResponse accountListResponse = remoteSystem.getMyAccounts(sessionId); 
	       List<AccountTO> emmasKonten = accountListResponse.getAccountList();
	       if (emmasKonten.size()>0) {
	    	   //gib Emmas Konten aus:
		       System.out.println("Emma hat folgende Konten:");
		       for (AccountTO k : emmasKonten) {
		    	   System.out.println("Konto-Nr: " + k.getId() + " Saldo: " + k.getBalance());
		    	   emmasKonto = k.getId();
		       }
		       System.out.println();
	       }
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
	   System.out.println("============================================================");
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
		    	   joesKonto = k.getId();
		       }
		       System.out.println();
		       
		       TransferMoneyResponse transferResponse = remoteSystem.transfer(sessionId, joesKonto, emmasKonto, new BigDecimal(33));
		       System.out.println("Joe hat von Konto "+ joesKonto +" 33 EUR an Konto " + emmasKonto + " ueberwiesen.");
		       System.out.println("Der neue Saldo von Konto "+joesKonto+" betraegt: " + transferResponse.getNewBalance());
	       }
	       remoteSystem.logout(sessionId);
		   System.out.println("Joe hat sich abgemeldet.");
	   }
       else {
    	   System.out.println(loginResponse.getMessage());
       }       
	}
	
}
