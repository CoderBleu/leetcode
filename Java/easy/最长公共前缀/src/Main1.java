import java.util.HashMap;

/**
 * @author coderblue
 * @date 2020/12/23
 */
public class Main1 {
    public static void main(String[] args) {
        // ["flower","flow","flight"]
        String[] strs = {"cir", "car"};
        String[] strs1 = {"ab", "a"};
        String[] strs2 = {"flower", "flow", "flight"};
        System.out.printf("输出：%s", longestCommonPrefix(strs));
        System.out.printf("输出：%s", longestCommonPrefix(strs1));
        System.out.printf("输出：%s", longestCommonPrefix(strs2));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 0; i < strs.length; i++) {
            prefix = longestCommonData(strs[i], prefix);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public static String longestCommonData(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        // 比较的和前缀要相同
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

}
