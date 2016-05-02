package de.fh_muenster.xbankandroid;

import android.app.Application;
import de.fh_muenster.xbank.Customer;
import de.fh_muenster.xbank.XbankOnlineService;

public class XbankAndroidApplication extends Application{

    /**
     * holds the user
     */
    private Customer user;


    private XbankOnlineService xbankOnlineService;

    /**
     * Constructor
     * Sets the implementation of the ServerInterface to our mock class.
     * The user attribute is set after successful login only.
     */
    public XbankAndroidApplication() {
        //TODO: replace mock implementation of the interface by the web serivce based implementation
        this.xbankOnlineService = new XbankOnlineServiceImplMock();
    }

    /**
     *
     * @return the user logged in
     */
    public Customer getUser() {
        return this.user;
    }

    /**
     * Allows to set the user after successful login.
     * @param user
     */
    public void setUser(Customer user) {
        this.user = user;
    }

    /**
     * Get the implementation of the Server Interface.
     * @return an object which implements the server interface
     */
    public XbankOnlineService getXbankOnlineService() {
        return this.xbankOnlineService;
    }
}







