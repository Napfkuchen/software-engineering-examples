
package de.xbank.onlinebanking;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für userLoginResponse complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="userLoginResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://onlinebanking.xbank.de/}returncodeResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="customer" type="{http://onlinebanking.xbank.de/}customerTO" minOccurs="0"/&gt;
 *         &lt;element name="sessionId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userLoginResponse", propOrder = {
    "customer",
    "sessionId"
})
public class UserLoginResponse
    extends ReturncodeResponse
{

    protected CustomerTO customer;
    protected int sessionId;

    /**
     * Ruft den Wert der customer-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CustomerTO }
     *     
     */
    public CustomerTO getCustomer() {
        return customer;
    }

    /**
     * Legt den Wert der customer-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerTO }
     *     
     */
    public void setCustomer(CustomerTO value) {
        this.customer = value;
    }

    /**
     * Ruft den Wert der sessionId-Eigenschaft ab.
     * 
     */
    public int getSessionId() {
        return sessionId;
    }

    /**
     * Legt den Wert der sessionId-Eigenschaft fest.
     * 
     */
    public void setSessionId(int value) {
        this.sessionId = value;
    }

}
