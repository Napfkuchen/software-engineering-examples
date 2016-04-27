package de.xbank.client;

import java.math.BigDecimal;
import java.util.Set;
import javax.naming.InitialContext;
import de.xbank.common.Account;
import de.xbank.common.InvalidLoginException;
import de.xbank.common.NoSessionException;
import de.xbank.common.XbankOnlineService;


/**
 * @author Thoene
 * Diese Klasse realisiert einen rudimentaeren Client zum Zugriff auf das OnlineBankingSystem.
 */
public class SimpleOnlineBankingClient {

	//Testdaten:
	private static final int JOES_KONTO	 =1;
	private static final int EMMAS_KONTO =2;
	
	private static XbankOnlineService remoteSystem;
	
	/**
	 * In dieser Main-Methode werden Requests an den Onlinebanking-Server abgeschickt. Sie koennen die durchgefuehrten
	 * Szenarien nach Belieben anpassen.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			
	       InitialContext context = new InitialContext();
	       
	       //Lookup-String für eine EJB besteht aus: Name_EA/Name_EJB-Modul/Name_EJB-Klasse!Name_RemoteInterface
	       String lookupString = "java:10_WS_Xbank-OnlineSystem-ear/10_WS_Xbank-OnlineSystem-ejb/XbankOnlineServiceBean!de.xbank.common.XbankOnlineService";
 	       remoteSystem = (XbankOnlineService) context.lookup(lookupString);
 	       
 	       //Zeige, welche Referenz auf das Server-Objekt der Client erhalten hast:
 	       System.out.println("Client hat folgendes Server-Objekt nach dem Lookup erhalten:");
 	       System.out.println(remoteSystem.toString());
 	       System.out.println();
 	       
 	       //Test-Szeanarien ausfuehren:
		   szenarioEmma();
		   
		   //Bei Stateful Session Beans muss nach jedem Szenario eine neue Server-Session eröffnet werden, da die Szenarien jeweils mit einem Logout enden.
		   remoteSystem = (XbankOnlineService) context.lookup(lookupString);
		   szenarioJoe();		   	       
		   
		   //Bei Stateful Session Beans muss nach jedem Szenario eine neue Server-Session eröffnet werden, da die Szenarien jeweils mit einem Logout enden.
		   remoteSystem = (XbankOnlineService) context.lookup(lookupString);
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
		try {
		   System.out.println("============================================================");			
	       boolean loginSuccessful = remoteSystem.login("emma", "emma1");
	       if (loginSuccessful) {
			   System.out.println("Emma hat sich angemeldet, um ihren Kontostand abzufragen.");
			   BigDecimal kontostand = remoteSystem.getBalance(EMMAS_KONTO);
		       System.out.println("Auf Emmas Konto " + EMMAS_KONTO + " betraegt der Saldo: " + kontostand);
		       remoteSystem.logout();
			   System.out.println("Emma hat sich abgemeldet.");
	       }
		}
		catch (NoSessionException | InvalidLoginException e) {
			e.printStackTrace();
		}
	}

    /**
     * Test-Szenario: Joe meldet sich an, fragt seine Konten ab und überweist an Emma
     */
	private static void szenarioJoe() {
		try {
		   System.out.println("============================================================");			
		   boolean loginSuccessful = remoteSystem.login("joe", "joe1");
		   if (loginSuccessful) {
			   System.out.println("Joe hat sich angemeldet");
			   
		       Set<Account> joesKonten = remoteSystem.getMyAccounts();
		       if (joesKonten.size()>0) {
		    	   //gib Joes Konten aus:
			       System.out.println("Joe hat folgende Konten:");
			       for (Account k : joesKonten) {
			    	   System.out.println(k);
			       }
			       System.out.println();
			       remoteSystem.transfer(JOES_KONTO, EMMAS_KONTO, new BigDecimal(33));
			       System.out.println("Joe hat von Konto "+ JOES_KONTO +" 33 EUR an Konto " + EMMAS_KONTO + " ueberwiesen.");
			       BigDecimal saldo = remoteSystem.getBalance(JOES_KONTO);
			       System.out.println("Der neue Saldo von Konto "+JOES_KONTO+" betraegt: " + saldo);
		       }
			   remoteSystem.logout();
			   System.out.println("Joe hat sich abgemeldet.");
		   }
		}
		catch (NoSessionException | InvalidLoginException e) {
			e.printStackTrace();
		}
	}
	
}
