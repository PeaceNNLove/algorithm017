package Week_01.homework;

public class MoveZero {
    /**
     * 方法一：先将所有的非零元素移动到前面，然后将后面的元素置为0
     * <p>
     * 因为我是先找到非0的，然后移到0的位置，所以被替换的那个0的索引都是在当前非0索引的前面，
     * 所以被替换了，对循环没有干扰
     * <p>
     * 最坏情况：除了最后一个数，前面都是0
     * O(n)
     */
    public void moveZeroes(int[] nums) {
        int notZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[notZero] = nums[i];
                notZero++;
            }
        }
        for (int i = notZero; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 方法二：每次找到一个非0的，就把它换到对应相对顺序的位置，如果前面已经没有0了，就是和本身交换。
     * 最坏情况，一个0在第一位，后面全部都不是0
     * <p>
     * O(n)
     */
    public void moveZeros2(int[] nums) {
        for (int current = 0, i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[current];
                nums[current] = nums[i];
                nums[i] = temp;
                current++;
            }
        }
    }
}
