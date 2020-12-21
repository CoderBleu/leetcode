import java.util.Objects;

/**
 * @author coderblue
 * @date 2020/12/21
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        // 排除负数、个位数、零数
        if (x < 0 || (x % 10 == 0 && x / 10 == 0)) {
            return false;
        }
        int compareNum = 0;
        while (x > compareNum) {
            compareNum = x % 10 + compareNum * 10;
            x /= 10;
        }
        return x == compareNum || x == compareNum / 10;
    }
}
