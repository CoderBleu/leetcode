import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author coderblue
 * @date 2020/12/16
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 链接：https://leetcode-cn.com/problems/two-sum/
 */
public class Main1 {
    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 5};
        twoSum(arr, 5);
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == target - nums[j]) {
                    System.out.println(Arrays.toString(new int[]{i, j}));
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}
