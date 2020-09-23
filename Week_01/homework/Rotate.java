package Week_01.homework;
//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
//
// 示例 1:
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
//
//
// 示例 2:
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释:
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100]
//
// 说明:
//
//
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
// 要求使用空间复杂度为 O(1) 的 原地 算法。

/**
 * @author linhongxiang
 * @since 2020/9/23
 */
public class Rotate {
    /**
     * 方法1：
     * 暴力破解，旋转k次，每次旋转1位
     * Time: O(n^2)
     */
    public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int last = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = last;
        }
    }

    /**
     * 方法二：
     * 使用新数组，将元素按顺序放到新数组上，再将原数组引用指向新数组
     * Time: O(n)
     */
    public void rotate2(int[] nums, int k) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }

//    其实是这样的，对于一个长度为 nn 的数组，整体移动 kk 个位置
//
//    当 nn 和 kk 的最大公约数 等于 1 的时候：1 次遍历就可以完成交换；比如 n = 5, k = 3n=5,k=3
//    当 nn 和 kk 的最大公约数 不等于 1 的时候：1 次遍历是无法完成的所有元素归位，需要 mm (最大公约数) 次
//    所以在最大公约数不为 1 的时候
//    比如 [A,B,C,D,E,F][A,B,C,D,E,F] 此时 n = 6 \ , k = 4n=6 ,k=4 ，其最大公约数为 22 ,因此需要 22 轮循环
//    我们就可以把这个数组分成两部分来看：
//    第 11 轮循环（分组1）： A \ E \ C \ [A]A E C [A]
//    第 22 轮循环（分组2）： \ \ \ \ B \ F \ D \ [B]    B F D [B]
//
//    即：每一轮循环只会在自己的那一组上不停的遍历。所以
//    数组的前 mm 个元素，其实就是每一个分组的第一个元素，我们控制流程在每次发现一轮循环走到原点时+1
//
//    那么如何判断所有的分组都执行归位了呢？ 可以有两种方法来控制
//
//    第一种：我们就用最大公约数 mm 来控制外循环，代表总共有 mm 轮循环
//    第二种：由于nn个元素归位需要nn次交换，所以我们定义一个count代表交换次数，当 count = n 时完成
//
//            代码
//
//    作者：xfzhao
//    链接：https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-yuan-di-huan-wei-xiang-xi-tu-jie/
//    来源：力扣（LeetCode）
    /**
     * 总结：忘掉的数学知识还是要捡回来的.       哭脸.jpg
     */
    public static void rotate3(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int startIndex = 0; count < nums.length; startIndex++) {
            int currentIndex = startIndex;
            int prevValue = nums[startIndex];
            do {
                currentIndex = (currentIndex + k) % nums.length;
                int temp = nums[currentIndex];
                nums[currentIndex] = prevValue;
                prevValue = temp;
                count++;
            } while (currentIndex != startIndex);
        }
    }

    /**
     * 旋转 = 三次旋转大法
     */
    public void rotate4(int[] nums, int k) {
        nums = reverse(nums, 0, nums.length - 1);
        nums = reverse(nums, 0, k);
        nums = reverse(nums, nums.length - k, nums.length);
    }

    public int[] reverse(int[] nums, int start, int end) {
        if (end > nums.length) {
            end = nums.length - 1;
        }

        while(start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
        return nums;
    }
}
