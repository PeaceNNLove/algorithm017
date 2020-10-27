package Week_03.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
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
            // 如果一个元素已经被使用过了，那么就肯定不再使用
            if (use[i]) {
                continue;
            }
            /*
             * 如果一个元素不是第一个元素，且它和上一个元素相同，是重复元素，而且上一个元素没被使用过，也就是说，如果让其过去了，在接下来的层级中，
             * 上一个元素会排在去后面，那么就肯定会出现重复结果，所以重复元素一定要保证他们的固定使用顺序，只有之前的重复元素被使用过了，才使用
             * 后面的重复元素，否则就是重复的枝头，剪掉
              */
            if (i > 0 && (nums[i] == nums[i - 1]) && !use[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            use[i] = true;
            // 进入下一层
            choose(nums, lists, list, use, depth + 1);
            use[i] = false;
            list.remove(list.size() - 1);
        }
        // 处理操作
    }
}
