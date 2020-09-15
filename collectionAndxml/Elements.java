/**
 * XML要素クラス
 *
 * @author 禹　相植
 */
package collectionAndxml;

import javax.xml.bind.annotation.XmlElement;

public class Elements {

    @XmlElement
    public String  company;

    @XmlElement
    public Flights flights;

    @SuppressWarnings("unused")
    private Elements() {
    }

    public Elements(String company, Flights flights) {
        this.company   = company;
        this.flights = flights;
    }

}
