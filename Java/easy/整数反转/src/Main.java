/**
 * @author coderblue
 * @date 2020/12/18
 * <p>
 * 输入: -123
 * 输出: -321
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        long n = 0;
        while (x != 0) {
            // n*10未溢出时, n*10个位为0, x%10的取值范围是0~9, n*10 + x%10一定没有进位, 故不会溢出。
            if ((n * 10) / 10 != n) {
                n = 0;
                break;
            }
            n = n * 10 + x % 10;
            x = x / 10;
        }
        // 判断是否值溢出
        System.err.println(Integer.reverse(x));
        return (int) n == n ? (int) n : 0;
    }
}
