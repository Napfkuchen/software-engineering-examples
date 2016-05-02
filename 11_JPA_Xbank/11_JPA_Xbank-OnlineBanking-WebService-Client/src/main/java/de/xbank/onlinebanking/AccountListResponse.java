
package de.xbank.onlinebanking;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für accountListResponse complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="accountListResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://onlinebanking.xbank.de/}returncodeResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="accountList" type="{http://onlinebanking.xbank.de/}accountTO" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accountListResponse", propOrder = {
    "accountList"
})
public class AccountListResponse
    extends ReturncodeResponse
{

    @XmlElement(nillable = true)
    protected List<AccountTO> accountList;

    /**
     * Gets the value of the accountList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accountList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccountList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccountTO }
     * 
     * 
     */
    public List<AccountTO> getAccountList() {
        if (accountList == null) {
            accountList = new ArrayList<AccountTO>();
        }
        return this.accountList;
    }

}
