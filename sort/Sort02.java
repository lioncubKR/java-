package sort;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Comparatorによるソート
 *
 * @author 禹　相植
 */
public class Sort02 {

    public static void main(String[] args) {
        List<String> targetList = Arrays.asList("KAL12", "KAL2", "JAL23", "ANA13", "KAL5",
                "JAL1", "JAL5", "ANA3", "ANA25");

        // ソート
        Collections.sort(targetList, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String str1 = s1.substring(0,3) + String.format("%02d", Integer.valueOf(s1.substring(3)));
                String str2 = s2.substring(0,3) + String.format("%02d", Integer.valueOf(s2.substring(3)));

                return str1.compareTo(str2);
            }
        });

        // 結果出力
        int[] i = {0};
        targetList.stream().forEach(s -> {
            i[0]++; // ランダム式は外部のローカル変数に対してはfinalな場合しかアクセスできないので、添え字は配列にしている。
            if (i[0] == targetList.size()) {
                System.out.print(s);
            } else {
                System.out.print(s + ",");
            }
        });

    }

}
