import java.util.*;

/**
 * @author coderblue
 * @date 2021/1/5
 */
public class Main1 {
    public static void main(String[] args) {
        String str = "aaa";
        System.out.println(largeGroupPositions(str));
    }

    public static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> list = new ArrayList<>();
        int len = s.length();
        if (len <= 2) {
            return list;
        }
        // 就算不连续，也是单个单词至少从1开始，避免首位置就是开始连续，从而导致出现 i - countWord + 1 负数
        int countWord = 1;
        for (int i = 0; i < s.length(); i++) {
            // i为最后一位，虽然i + 1会索引越界，但是不会执行
            if (i == len - 1 || s.charAt(i) != s.charAt(i + 1)) {
                if (countWord >= 3) {
                    // 当前的字符长度 - 单词连续重复数 + 1
                    list.add(Arrays.asList(i - countWord + 1, i));
                }
                countWord = 1;
            } else {
                countWord++;
            }
        }

        return list;
    }
}
