package sort;


/**
 * Comparableによるソート用Beanクラス.
 *
 * @author 禹 相植
 *
 */
public class Flight implements Comparable<Flight> {

    private String flightName;

    public Flight(String flightName) {
        this.flightName = flightName;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    @Override
    public int compareTo(Flight o) {
        return this.flightName.compareTo(o.getFlightName());
    }

    public String toString() {
        return this.flightName;
    }

}
