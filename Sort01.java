

/**
 * Stream.sortedによるソート
 *
 * @author 禹　相植
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sort01 {

    public static void main(String[] args) {
        List<String> targetList = Arrays.asList("KAL12", "KAL2", "JAL23", "ANA13", "KAL5",
                "JAL1", "JAL5", "ANA3", "ANA25");
        
        // ソート
        String result = targetList.stream()
                .sorted(Comparator.comparing(
                        s -> s.substring(0,3) + String.format("%02d", Integer.valueOf(s.substring(3)))))
                .collect(Collectors.joining(","));
        
        // 結果出力
        System.out.println(result);
        
		
    }

}
