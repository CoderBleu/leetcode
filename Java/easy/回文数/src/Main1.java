import java.util.Objects;

/**
 * @author coderblue
 * @date 2020/12/21
 */
public class Main1 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || x / 10 == 0) {
            return false;
        }
        String s = String.valueOf(x);
        // 最后一位不能为0
        String[] split = s.split("");
        if (!Objects.equals(split.length - 1, '0')) {
            long aLong = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                aLong = aLong * 10 + Long.parseLong(split[i]);
            }
            if ((int) aLong != aLong || aLong != Long.parseLong(s)) {
                return false;
            }
            return true;
        }
        return false;
    }
}
