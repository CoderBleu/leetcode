给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 示例:

 给定 nums = [2, 7, 11, 15], target = 9

 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]
 
解法一：暴力枚举，时间复杂度O(n^2)

```java
public int[] twoSum(int[] nums, int target) {
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
```

解法二：建立hash，时间复杂度O(n^2)，空间复杂度O(n^2)

```java
public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        // 建立k-v ，一一对应的哈希表
        Map<Integer,Integer> hash = new HashMap<Integer,Integer>();

        for(int i = 0; i < nums.length; i++){
            // 如果有此key，那么就是需要找的另外一个数
            if(hash.containsKey(nums[i])){
                result[0] = hash.get(nums[i]);
                result[1] = i;
                System.out.println(Arrays.toString(result));
                return result;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target-nums[i],i);
        }
        return null;
    }
```