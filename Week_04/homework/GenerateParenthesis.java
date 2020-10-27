package Week_04.homework;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    /**
     * week 3写了回溯，本次使用DFS
     */
    public List<String> generateParenthesis(int n) {
        String str = "";
        List<String> list = new ArrayList<>();
        dfs(list, n, n, str);
        return list;
    }

    public void dfs(List<String> list, int left, int right, String str) {
        if (left == 0 && right == 0) {
            list.add(str);
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            dfs(list, left - 1, right, str + "(");
        }
        if (right > 0) {
            dfs(list, left, right - 1, str + ")");
        }
    }
}
