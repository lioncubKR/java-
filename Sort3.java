

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Comparableによるソート
 *
 * @author 禹　相植
 */
public class Sort3 {

    public static void main(String[] args) {
        List<String> targetList = Arrays.asList("KAL12", "KAL2", "JAL23", "ANA13", "KAL5",
                "JAL1", "JAL5", "ANA3", "ANA25");

        // Comparableインターフェースを実装しているFlightクラスを利用する
        List<Flight> list = new ArrayList<>();
        for (String str : targetList) {
            list.add(new Flight(str.substring(0,3) + String.format("%02d", Integer.valueOf(str.substring(3)))));
        }

        // ソート
        Collections.sort(list);

        // 結果出力
        String result = "";
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size()-1) {
                result = result + list.get(i).toString() + ",";
            } else {
                result = result + list.get(i).toString();
            }
        }

        System.out.println(result);

    }

}
