package Week_03.homework;

import java.util.ArrayList;
import java.util.List;


/**
 * 问题拆解：
 * 1. n对括号，即有2n个位置。
 * 2. 每个位置是放“(”还是“)”的问题。
 * 3. 第一个位置一定是“(”，最后一个位置一定是")"
 * 4. 左边至少要有一个"("，右边才能加一个")"
 */
public class GenerateParenthesis {
    /**
     * 方法一：
     * 回溯
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(n, 2 * n, 0, 0, list, "");
        return list;
    }

    public void generate(int n, int length, int leftNum, int rightNum, List<String> list, String str) {
        // 终结条件
        if (leftNum < rightNum || leftNum > n) {
            return;
        }
        if (length == 0) {
            list.add(str);
            return;
        }
        generate(n, length - 1, leftNum + 1, rightNum, list, str + "(");
        generate(n, length - 1, leftNum,rightNum + 1, list, str + ")");
    }

    /**
     * 方法二：
     * 参考官方答案修改版1.0
     *  - 去除不必要参数
     */
    public List<String> generateParenthesis2(int n) {
        List<String> list = new ArrayList<>();
        generate2(n, 0, 0, list, "");
        return list;
    }

    public void generate2(int n, int leftNum, int rightNum, List<String> list, String str) {
        // 终结条件
        if (leftNum < rightNum || leftNum > n) {
            return;
        }
        if (str.length() == 2 * n) {
            list.add(str);
            return;
        }
        generate2(n, leftNum + 1, rightNum, list, str + "(");
        generate2(n, leftNum, rightNum + 1, list, str + ")");
    }

    /**
     * 方法三：
     * 参考官方答案修改版1.1
     *  - 将String替换成StringBuilder，减少对象的创建
     */
    public List<String> generateParenthesis3(int n) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        generate3(n, 0, 0, list, sb);
        return list;
    }

    /**
     * 需要注意这里传递的是StringBuilder，是一个可修改的对象，添加左括号和右括号不能直接顺序。
     */
    public void generate3(int n, int leftNum, int rightNum, List<String> list, StringBuilder sb) {
        // 终结条件
        if (leftNum < rightNum || leftNum > n) {
            return;
        }
        if (sb.length() == 2 * n) {
            list.add(sb.toString());
            return;
        }
        generate3(n, leftNum + 1, rightNum, list, sb.append("("));
        sb.deleteCharAt(sb.length() - 1);
        generate3(n, leftNum, rightNum + 1, list, sb.append(")"));
        sb.deleteCharAt(sb.length() - 1);
    }

    /**
     * 方法三：todo
     * 参考官方答案修改版1.2
     */
    public List<String> generateParenthesis4(int n) {
        return null;
    }
}
