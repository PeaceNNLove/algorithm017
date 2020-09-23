package Week_01.homework;

import java.util.HashMap;
import java.util.Map;

/**
 * @author linhongxiang
 * @since 2020/9/23
 */
public class TwoSum {
    /**
     * 方法一：
     * 暴力破解O（n^2）
     */
    public int[] twoSum(int[] nums, int target) {
        int[] twoIndex = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    twoIndex[0] = i;
                    twoIndex[1] = j;
                    return twoIndex;
                }
            }
        }
        return twoIndex;
    }

    /**
     * 方法二：
     * 一次hash法O(n)
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{i, map.get(complement)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no element");
    }
}
