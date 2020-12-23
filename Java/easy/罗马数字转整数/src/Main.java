import java.util.HashMap;
import java.util.Map;

/**
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * @author coderblue
 * @date 2020/12/22
 */
public class Main {

    private static Map<String, Integer> map = new HashMap<String, Integer>();

    static {
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
    }

    public static void main(String[] args) {
        // XX + V + II = 27
        System.out.printf("%d", romanToInt("IV"));
    }

    public static int romanToInt(String s) {
        int result = 0;
        char curVal;

        for (int i = 0; i < s.length(); i++) {
            curVal = s.charAt(i);
            switch (curVal) {
                case 'I':
                    result += 1;
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'X':
                    result += 10;
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'C':
                    result += 100;
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'M':
                    result += 1000;
                    break;
                default: break;
            }

            if (i != 0) {
                char preVal = s.charAt(i - 1);
                // 乘二为了：抵去上面满足以下条件的 本应该减 反而自加的
                if ((curVal == 'V' || curVal == 'X') && preVal == 'I') {
                    // I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
                    result = result - 1 * 2;
                } else if ((curVal == 'L' || curVal == 'C') && preVal == 'X') {
                    // X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90
                    result = result - 10 * 2;
                } else if ((curVal == 'D' || curVal == 'M') && preVal == 'C') {
                    // C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900
                    result = result - 100 * 2;
                }
            }
        }
        return result;
    }
}
