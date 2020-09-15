/**
 * 航空便名リスト用Beanクラス
 *
 * @author 禹　相植
 */
package collectionAndxml;

import java.util.Set;

public class Flights {
    private  Set<String> flightName;

    public Set<String> getFlightName() {
        return flightName;
    }

    public void setFlightName(Set<String> flightName) {
        this.flightName = flightName;
    }

    public String toString() {
        return this.flightName.toString();
    }

}