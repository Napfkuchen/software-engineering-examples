
package de.xbank.onlinebanking;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für accountBalanceResponse complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="accountBalanceResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://onlinebanking.xbank.de/}returncodeResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="balance" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accountBalanceResponse", propOrder = {
    "accountId",
    "balance"
})
public class AccountBalanceResponse
    extends ReturncodeResponse
{

    protected int accountId;
    protected BigDecimal balance;

    /**
     * Ruft den Wert der accountId-Eigenschaft ab.
     * 
     */
    public int getAccountId() {
        return accountId;
    }

    /**
     * Legt den Wert der accountId-Eigenschaft fest.
     * 
     */
    public void setAccountId(int value) {
        this.accountId = value;
    }

    /**
     * Ruft den Wert der balance-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * Legt den Wert der balance-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBalance(BigDecimal value) {
        this.balance = value;
    }

}
