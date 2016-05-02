
package de.xbank.onlinebanking;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für accountTO complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="accountTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://onlinebanking.xbank.de/}dataTransferObject"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="balance" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="ownerId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accountTO", propOrder = {
    "balance",
    "id",
    "ownerId"
})
public class AccountTO
    extends DataTransferObject
{

    protected BigDecimal balance;
    protected int id;
    protected int ownerId;

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

    /**
     * Ruft den Wert der id-Eigenschaft ab.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Legt den Wert der id-Eigenschaft fest.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Ruft den Wert der ownerId-Eigenschaft ab.
     * 
     */
    public int getOwnerId() {
        return ownerId;
    }

    /**
     * Legt den Wert der ownerId-Eigenschaft fest.
     * 
     */
    public void setOwnerId(int value) {
        this.ownerId = value;
    }

}
