package Week_02.homework;

import java.util.*;

//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
// 示例:
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//
// 说明：
//
//
// 所有输入均为小写字母。
// 不考虑答案输出的顺序。
//
// Related Topics 哈希表 字符串

/**
 * @author linhongxiang
 * @since 2020/9/28
 */
public class GroupAnagrams {
    /**
     * 方法一：
     * 把这个数组遍历一遍，计算出所有字符串的字母计数表，将计数表合成一个字符串，再按字符串分组
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> cache = new HashMap<>();
        char[] count = new char[26];
        for (String str : strs) {
            Arrays.fill(count, 'a');
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            String value = String.valueOf(count);
            if (!cache.containsKey(value)) {
                List<String> list = new ArrayList<>();
                cache.put(value, list);
            }
            cache.get(value).add(str);
        }
        return new ArrayList<>(cache.values());
    }
}
