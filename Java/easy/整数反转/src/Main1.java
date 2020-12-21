/**
 * @author coderblue
 * @date 2020/12/18
 * <p>
 * 输入: -123
 * 输出: -321
 */
public class Main1 {
    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        // 判断是否值溢出
        System.err.println(Integer.reverse(x));
        return (int) n == n ? (int) n : 0;
    }
}
