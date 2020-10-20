package Week_03.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题分析：
 * 1. 集合中的元素不重复
 * 2. 寻找子集，即集合中的元素，取或者不取
 */
public class SubSet {
    /**
     * 方法一：
     * 回溯
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> subNum = new ArrayList<>();
        fetchSub(lists, subNum, nums, 0);
        return lists;
    }

    public void fetchSub(List<List<Integer>> lists, List<Integer> subNum, int[] nums, int current) {
        if (current == nums.length) {
            lists.add(subNum);
            return;
        }
        List<Integer> temp = new ArrayList<>(subNum);
        fetchSub(lists, subNum, nums, current + 1);
        temp.add(nums[current]);
        fetchSub(lists, temp, nums, current + 1);
    }
}
