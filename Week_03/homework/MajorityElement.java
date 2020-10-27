package Week_03.homework;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MajorityElement {
    /**
     * 方法一：
     * 利用哈希表，key为值，value为出现次数，找出 value > n/2的key
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        return map.entrySet().stream().filter(entry -> entry.getValue() > (nums.length / 2))
                .map(Map.Entry::getKey).collect(Collectors.toList()).get(0);
    }

    /**
     * 方法二：
     * 分治，将数组分成两部分，那么那个唯一的多数一定会在某一部分还是多数，直至数量为一，依旧是多数的那个数就是多数
     * 从根节点开始往上进行统计
     * O(nlog(n))
     */
    public int majorityElement2(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    /**
     * 不断折半，O(log(n))
     */
    public int search(int[] nums, int firstIndex, int lastIndex) {
        if (firstIndex == lastIndex) {
            return nums[firstIndex];
        }
        int midIndex = (lastIndex - firstIndex) / 2 + firstIndex;
        int left = search(nums, firstIndex, midIndex);
        int right = search(nums, midIndex + 1, lastIndex);

        int leftCount = count(nums, left, firstIndex, midIndex);
        int rightCount = count(nums, right, midIndex + 1, lastIndex);
        return leftCount > rightCount ? left : right;
    }

    /**
     * O(n)
     */
    public int count(int[] nums, int num, int firstIndex, int lastIndex) {
        int count = 0;
        for (int i = firstIndex; i <= lastIndex; i++) {
            if (nums[i] == num) {
                count ++;
            }
        }
        return count;
    }
}
