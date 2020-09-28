package Week_02.homework;

//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
//
//
//
// 示例:
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
//
// Related Topics 数组 哈希表

import java.util.HashMap;
import java.util.Map;

/**
 * @author linhongxiang
 * @since 2020/9/28
 */
public class TwoSum {
    /**
     * Hash法：
     * a + b = target, a = target - b
     * 一次遍历，key 为 target - b, value = b
     * 二次遍历，遍历a获取value
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(target - nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i != map.get(nums[i])) {
                return new int[]{i, map.get(nums[i])};
            }
        }
        throw new IllegalArgumentException("not two sum equals to target");
    }

    /**
     * 一遍Hash法
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{i, map.get(nums[i])};
            }
            map.put(target - nums[i], i);
        }
        throw new IllegalArgumentException("not two sum equals to target");
    }
}
