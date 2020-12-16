import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author coderblue
 * @date 2020/12/16
 */
public class Main1 {
    public static void main(String[] args) {
        boolean b = wordPattern("abba", "dog cat cat dog");
        System.out.println(b);
    }

    public static boolean wordPattern(String pattern, String s) {
        if (pattern.isEmpty() || s.isEmpty()) {
            return false;
        }
        Map<Character, Object> map = new HashMap<>();
        // 键pattern
        // 值
        String[] arr = s.split(" ");
        if (pattern.length() != arr.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            if (map.isEmpty()) {
                map.put(pattern.charAt(i), arr[i]);
                continue;
            }
            // key存在
            if (map.containsKey(pattern.charAt(i))) {
                // 值也相同, 为true；值不同，为false
                if (!Objects.equals(arr[i], map.get(pattern.charAt(i)))) {
                    return false;
                }
            } else {
                // key不存在：还有值相同为false，没值就添加
                if (map.containsValue(arr[i])) {
                    return false;
                }
                map.put(pattern.charAt(i), arr[i]);
            }

        }
        return true;
    }
}
