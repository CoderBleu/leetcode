import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author coderblue
 * @date 2021/1/5
 */
public class Main {
    public static void main(String[] args) {
        String str = "abcdddeeeeaabbbcd";
        System.out.println(largeGroupPositions(str));
    }

    public static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> list = new ArrayList<>();
        int n = s.length();
        for (int i = 0; i < n;) {
            int j = i + 1;
            while (j != s.length() && s.charAt(i) == s.charAt(j)) {
                j++;
            }
            // 算i的偏移量：j - i已经包括：末位置 - 首位置 + 1
            if (j - i >= 3) {
                list.add(List.of(i, j - 1));
            }
            i = j;
        }

        return list;
    }
}
