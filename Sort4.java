

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * sortのAPIを使用しない場合
 *
 * @author 禹　相植
 */
public class Sort4 {

    public static void main(String[] args) {
        // removeするために、ArrayListにシャーロットコピーする。
        ArrayList<String> targetList = new ArrayList<>(Arrays.asList("KAL12", "KAL2", "JAL23", "ANA13", "KAL5",
                "JAL1", "JAL5", "ANA3", "ANA25"));

        List<String> resultList = new ArrayList<>();

        do {
            String minValue = targetList.get(0);
            for (int i = 0; i < targetList.size(); i++) {
                if (resultList.contains(targetList.get(i))) {
                    break; // すでに最小値として決定された値は飛ばす。
                }

                // 最小値判定
                if (getZeroLeftPadding(minValue).compareTo(getZeroLeftPadding(targetList.get(i)))  > 0) {
                    minValue = targetList.get(i);
                }
            }

            // 最小値として判定された値の順でセット。
            resultList.add(minValue);
            targetList.remove(minValue);

        } while (!targetList.isEmpty());

        // 結果出力
        String result = "";
        for (int i = 0; i < resultList.size(); i++) {
            if (i != resultList.size()-1) {
                result = result + resultList.get(i).toString() + ",";
            } else {
                result = result + resultList.get(i).toString();
            }
        }
        System.out.println(result);

    }


    /**
     * 文字列ソートのため、数値においてゼロ左埋めした文字列を生成する.
     *
     * @param str　処理対象文字列
     * @return ゼロ左埋めした文字列
     */
    private static String getZeroLeftPadding(String str) {
        String result = "";

        if (str == null || str.isEmpty()) {
            return str;
        }

        if (str.matches("^[A-Z]{3}?[0-9]{1,2}?$")) {
            result = str.substring(0,3) + String.format("%02d", Integer.valueOf(str.substring(3)));
        } else {
            return str;
        }

        return result;
    }

}
