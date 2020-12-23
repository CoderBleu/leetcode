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
public class Main1 {

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
        System.out.printf("%d", romanToInt("XXVI"));
        System.err.println("===");
    }

    public static int romanToInt(String s) {
        String[] arr = s.split("");
        int result = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if(map.get(arr[i+1]) <= map.get(arr[i])) {
                // arr[i]大的数在左边：通常情况下，罗马数字中小的数字在大的数字的右边
                result +=  map.get(arr[i]);
            } else{
                // 大的数在右边
                result -= map.get(arr[i]);
            }
        }
        result += map.get(arr[arr.length - 1]);
        return result;
    }
}
