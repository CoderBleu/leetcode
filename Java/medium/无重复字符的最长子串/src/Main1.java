import java.util.HashMap;
import java.util.Map;

/**
 * @author coderblue
 * @date 2020/12/17
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 */
public class Main1 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int left = 0, n = s.length(), res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            char chr = s.charAt(i);
            if (map.containsKey(chr)) {
                //更新左边界：比较原先的左边界 和 此刻i下的字符在map中对应的索引的后一位
                left = Math.max(left, map.get(chr) + 1);
            }
            map.put(chr, i);
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
