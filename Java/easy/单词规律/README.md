给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。

 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。

 示例1:

 输入: pattern = "abba", str = "dog cat cat dog"
 输出: true
 示例 2:

 输入:pattern = "abba", str = "dog cat cat fish"
 输出: false
 示例 3:

 输入: pattern = "aaaa", str = "dog cat cat dog"
 输出: false
 示例 4:

 输入: pattern = "abba", str = "dog dog dog dog"
 输出: false
 说明:
 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。

 链接：https://leetcode-cn.com/problems/word-pattern
 
解法一：遍历，再分key存在、不存在处理

```java
public static boolean wordPattern(String pattern, String s) {
    if (pattern.isEmpty() || s.isEmpty()) {
        return false;
    }
    Map<Character, Object> map = new HashMap<>();
    // 键pattern  值
    String[] arr = s.split(" ");
    if (pattern.length() != arr.length) {
        return false;
    }
    for (int i = 0; i < pattern.length(); i++) {
        if (map.isEmpty()) {
            map.put(pattern.charAt(i), arr[i]);
            continue;
        }
        // key存在
        if (map.containsKey(pattern.charAt(i))) {
            // 值也相同, 为true；值不同，为false
            if (!Objects.equals(arr[i], map.get(pattern.charAt(i)))) {
                return false;
            }
        } else {
            // key不存在：还有值相同为false，没值就添加
            if (map.containsValue(arr[i])) {
                return false;
            }
            map.put(pattern.charAt(i), arr[i]);
        }

    }
    return true;
}
```

解法二：利用map.put方法的返回值（key第一次put的时候返回null，第n次put则返回第n-1次的value）

```java
public static boolean wordPattern(String pattern, String s) {
    String[] arr = s.split(" ");
    if (pattern.length() != arr.length) {
        return false;
    }
    Map map = new HashMap<>();
    // 遍历键pattern
    for (Integer i = 0; i < pattern.length(); i++) {
        if (map.put(pattern.charAt(i), i) != map.put(arr[i], i)) {
            // 第一次map.put(a)跟map.put(dog)都是返回null，第二次map.put(a)跟map.put(dog)都是返回0
            return false;
        }
    }
    return true;
}
```