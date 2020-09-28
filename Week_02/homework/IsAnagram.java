package Week_02.homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author linhongxiang
 * @since 2020/9/28
 */
public class IsAnagram {
    /**
     * 方法一：
     * 排序后进行比较。
     * 时间复杂度O(nlogn),排序时间复杂度O(nlogn)
     * 空间复杂度O(n)
     *
     * 在 Java 中，toCharArray() 制作了一个字符串的拷贝，所以它花费 O(n)O(n) 额外的空间，但是我们忽略了这一复杂性分析，因为：
     * 这依赖于语言的细节。
     * 这取决于函数的设计方式。例如，可以将函数参数类型更改为 char[]。
     *
     */
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        if (s.equals(t)) {
            return true;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }

    /**
     * 方法二：
     * 维护一个计数表
     */
    public boolean isAnagram2(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        if (s.equals(t)) {
            return true;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int[] charNumbers = new int[26];
        for (int i = 0; i < sChars.length; i++) {
            charNumbers[sChars[i] - 'a']++;
            charNumbers[tChars[i] - 'a']--;
        }
        for (int aChar : charNumbers) {
            if (aChar != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 方法三：
     * 哈希表
     */
    public boolean isAnagram3(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        if (s.equals(t)) {
            return true;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char sChar : sChars) {
            if (map.containsKey(sChar)) {
                map.put(sChar, map.get(sChar) + 1);
            } else {
                map.put(sChar, 1);
            }
        }
        for (char tChar : tChars) {
            if (map.containsKey(tChar)) {
                map.put(tChar, map.get(tChar) - 1);
            } else {
                return false;
            }
        }
        for (char sChar : sChars) {
            if (map.getOrDefault(sChar, -1) != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 方法四：
     * 哈希表
     */
    public boolean isAnagram4(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        if (s.equals(t)) {
            return true;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < sChars.length; i++) {
            if (map.containsKey(sChars[i])) {
                map.put(sChars[i], map.get(sChars[i]) + 1);
            } else {
                map.put(sChars[i], 1);
            }
            if (map.containsKey(tChars[i])) {
                map.put(tChars[i], map.get(tChars[i]) - 1);
            } else {
                map.put(tChars[i], -1);
            }
        }
        for (Integer value : map.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }

    /*
     * 总结：
     * 如果操作的元素数量有限，那么使用数组弄一个查询表比较好，如果数量不确定，再考虑用哈希表
     */
}
