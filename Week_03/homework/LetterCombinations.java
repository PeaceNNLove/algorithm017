package Week_03.homework;

import java.util.*;

public class LetterCombinations {
    /**
     * 回溯
     */
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.equals("")) {
            return new ArrayList<>();
        }
        char[] charDigits = digits.toCharArray();
        List<String> list = new ArrayList<>();
        Map<Character, String> map = new HashMap<Character, String>() {
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };
        backtrack(charDigits, map, 0, "", list);
        return list;
    }

    public void backtrack(char[] digits, Map<Character, String> map, int depth, String str, List<String> list) {
        if (depth == digits.length) {
            list.add(str);
            return;
        }
        char[] chars = map.get(digits[depth]).toCharArray();
        for (char aChar : chars) {
            backtrack(digits, map, depth + 1, str + aChar, list);
        }
    }
}
