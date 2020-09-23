package Week_01.homework;

public class Rotate {
    /**
     * 方法1：
     * 暴力破解，旋转k次，每次旋转1位
     * O(n^k)
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
     * 一次跨k步
     */
    public void rotate2(int[] nums, int k) {
        for (int i = k; i < nums.length; i++) {

        }
    }
}
