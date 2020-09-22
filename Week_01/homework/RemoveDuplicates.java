package Week_01.homework;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 示例 1:
 *      给定数组 nums = [1,1,2],
 *      函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *      你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *      给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *      函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *      你不需要考虑数组中超出新长度后面的元素。
 *
 * @author linhongxiang
 * @since 2020/9/22
 */
public class RemoveDuplicates {
    /**
     * 第一次解题：
     * 参考题解：
     * 双指针法
     */
    public int removeDuplicates(int[] nums) {
         if (nums.length < 2) {
             return nums.length;
         }
         int a = 0;
         // O(n)
         for (int z = 1; z < nums.length; z++) {
             if (nums[a] != nums[z]) {
                 a++;
                 nums[a] = nums[z];
             }
         }
         return a + 1;
    }

    /**
     * 第二次解题思路：
     * 由于是有序数组，所以重复的数据肯定连在一起
     * 使用两个指针，分别指向第一个和第二个元素，不断的移动第二个指针，
     * 当第二个指针指向的值不等于第一个指针的值时，就将第二个指针的值放到
     * 第二个指针处，最后a指针的位置就是新数组的长度。
     */
    public int removeDuplicates2(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int a = 0;
        int b = 1;
        while (b != nums.length) {
            if (nums[a] != nums[b]) {
                nums[a + 1] = nums[b];
                a++;
            }
            b++;
        }
        return a + 1;
    }
}
