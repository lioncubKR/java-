/**
 * Root要素用Beanクラス.
 *
 * @author 禹　相植
 */
package sort;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name="Root")
public class Companies {
    private  LinkedHashMap<String, Flights> flightInfo;

    public Companies() {
        flightInfo = new LinkedHashMap<String, Flights>();
    }

    @XmlJavaTypeAdapter(ConvertAdapter.class)
    public  HashMap<String, Flights> getFlightInfo() {
        return flightInfo;
    }

    public void setFlightInfo(LinkedHashMap<String, Flights> flightInfo) {
        this.flightInfo = flightInfo;
    }

}
