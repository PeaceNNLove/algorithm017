package Week_03.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题分析：
 * 1. 第一个元素，遍历nums所有元素，取或者不取，取了就标记为取了。
 * 2. 第n层，在未取的元素中遍历一遍，取或者不取，取了就标记为取了。
 * 3. 每一层一定会取一个数字，如果全部取用过了，那么就会加入可能性并返回。
 * 4. 本题数组是不重复的元素。
 */
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] use = new boolean[nums.length];
        choose(nums, lists, list, use, 0);
        return lists;
    }

    public void choose(int[] nums, List<List<Integer>> lists, List<Integer> list, boolean[] use, int depth) {
        // 终结条件
        if (depth == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        // 本层操作
        for (int i = 0; i < nums.length; i++) {
            if (!use[i]) {
                list.add(nums[i]);
                use[i] = true;
                // 进入下一层
                choose(nums, lists, list, use, depth + 1);
                use[i] = false;
                list.remove(list.size() - 1);
            }
        }
        // 处理操作
    }
}
