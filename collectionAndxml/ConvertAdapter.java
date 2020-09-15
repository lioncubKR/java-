/**
 * マップをXML要素として使用するためのXmlAdapter
 *
 * @author 禹　相植
 */
package collectionAndxml;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class ConvertAdapter extends XmlAdapter<Elements[], Map<String, Flights>> {

    @Override
    public Elements[] marshal(Map<String, Flights> map) throws Exception {

        Elements[] elements = new Elements[map.size()];

        int i = 0;
        for (Map.Entry<String, Flights> entry : map.entrySet()) {
            elements[i++] = new Elements(entry.getKey(), entry.getValue());
        }

        return elements;
    }

    @Override
    public Map<String, Flights> unmarshal(Elements[] elements) throws Exception {

        Map<String, Flights> map = new LinkedHashMap<String, Flights>();

        for (Elements element : elements) {
            map.put(element.company, element.flights);
        }

        return map;
    }

}
