import java.util.HashMap;
import java.util.Map;

/**
 * @author coderblue
 * @date 2020/12/16
 */
public class Main {
    public static void main(String[] args) {
        boolean b = wordPattern("abbc", "dog cat cat dog");
        System.out.println(b);
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if (pattern.length() != arr.length) {
            return false;
        }
        Map map = new HashMap<>();
        // 遍历键pattern
        for (Integer i = 0; i < pattern.length(); i++) {
            // 利用map.put方法的返回值（key第一次put的时候返回null，第n次put则返回第n-1次的value）
            // 两者必须是类型相等才可以返回true
            if (map.put(pattern.charAt(i), i) != map.put(arr[i], i)) {
                // 第一次map.put(a)跟map.put(dog)都是返回null，第二次map.put(a)跟map.put(dog)都是返回0
                return false;
            }
        }
        return true;
    }
}
