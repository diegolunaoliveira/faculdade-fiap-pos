
package br.com.sulamerica;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOf_tns1_ServicoAutorizador complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOf_tns1_ServicoAutorizador">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="item" type="{http://to.autorizador.portalws.susis.sulamerica.com.br}ServicoAutorizador" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOf_tns1_ServicoAutorizador", propOrder = {
    "item"
})
public class ArrayOfTns1ServicoAutorizador {

    protected List<ServicoAutorizador> item;

    /**
     * Gets the value of the item property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the item property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServicoAutorizador }
     * 
     * 
     */
    public List<ServicoAutorizador> getItem() {
        if (item == null) {
            item = new ArrayList<ServicoAutorizador>();
        }
        return this.item;
    }

    /**
     * Sets the value of the item property.
     * 
     * @param item
     *     allowed object is
     *     {@link ServicoAutorizador }
     *     
     */
    public void setItem(List<ServicoAutorizador> item) {
        this.item = item;
    }

}
