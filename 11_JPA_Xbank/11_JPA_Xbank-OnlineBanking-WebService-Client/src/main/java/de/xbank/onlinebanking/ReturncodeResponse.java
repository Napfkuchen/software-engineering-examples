
package de.xbank.onlinebanking;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für returncodeResponse complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="returncodeResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://onlinebanking.xbank.de/}dataTransferObject"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="returnCode" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "returncodeResponse", propOrder = {
    "message",
    "returnCode"
})
@XmlSeeAlso({
    UserLoginResponse.class,
    AccountListResponse.class,
    AccountBalanceResponse.class,
    TransferMoneyResponse.class
})
public class ReturncodeResponse
    extends DataTransferObject
{

    protected String message;
    protected int returnCode;

    /**
     * Ruft den Wert der message-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Legt den Wert der message-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Ruft den Wert der returnCode-Eigenschaft ab.
     * 
     */
    public int getReturnCode() {
        return returnCode;
    }

    /**
     * Legt den Wert der returnCode-Eigenschaft fest.
     * 
     */
    public void setReturnCode(int value) {
        this.returnCode = value;
    }

}
