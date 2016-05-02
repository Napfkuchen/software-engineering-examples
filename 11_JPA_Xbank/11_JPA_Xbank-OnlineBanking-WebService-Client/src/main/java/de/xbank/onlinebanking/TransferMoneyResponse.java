
package de.xbank.onlinebanking;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für transferMoneyResponse complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="transferMoneyResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://onlinebanking.xbank.de/}returncodeResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="newBalance" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transferMoneyResponse", propOrder = {
    "newBalance"
})
public class TransferMoneyResponse
    extends ReturncodeResponse
{

    protected BigDecimal newBalance;

    /**
     * Ruft den Wert der newBalance-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNewBalance() {
        return newBalance;
    }

    /**
     * Legt den Wert der newBalance-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNewBalance(BigDecimal value) {
        this.newBalance = value;
    }

}
