import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
public class Main {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int pointer = -1, res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                set.remove(s.charAt(i - 1));
            }
            // 指针小于字符的长度 且 set集合不包含指针右移一位的值
            while (pointer + 1 < s.length() && !set.contains(s.charAt(pointer + 1))) {
                // 不断地移动右指针
                set.add(s.charAt(pointer + 1));
                ++pointer;
            }
            res = Math.max(res, pointer - i + 1);
        }
        return res;
    }
}
