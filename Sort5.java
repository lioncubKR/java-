
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * 自動ソートされるTreeSetを利用したソート
 *
 * @author 禹　相植
 */
public class Sort5 {

    public static void main(String[] args) {
        List<String> targetList = Arrays.asList("KAL12", "KAL2", "JAL23", "ANA13", "KAL5",
                "JAL1", "JAL5", "ANA3", "ANA25");

        // 1.リストの値に対して、文字列ソートのため、ゼロ左埋めする
        // 2.リストをセットに変換する.
        // -> TreeSetにより自動ソートされる。
        Set<String> sortSet = new TreeSet<>(
                targetList.stream().map(s -> getZeroLeftPadding(s)).collect(Collectors.toList()));

        // 結果出力
        int[] i = {0};
        sortSet.stream().forEach(s -> {
            i[0]++;
            if (i[0] == targetList.size()) {
                System.out.print(s.replaceAll("0", ""));
            } else {
                System.out.print(s.replaceAll("0", "") + ",");
            }
        });

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
