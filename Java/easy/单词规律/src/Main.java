import java.util.HashMap;
import java.util.Map;

/**
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。   
 *
 * 链接：https://leetcode-cn.com/problems/word-pattern
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
            if (map.put(pattern.charAt(i), i) != map.put(arr[i], i)) {
                // 第一次map.put(a)跟map.put(dog)都是返回null，第二次map.put(a)跟map.put(dog)都是返回0
                return false;
            }
        }
        return true;
    }
}
