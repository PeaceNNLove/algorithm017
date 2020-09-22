package Week_01.homework;

/**
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 示例 1:
 *     输入: [1,2,3]
 *     输出: [1,2,4]
 *     解释: 输入数组表示数字 123。
 * 示例 2:
 *     输入: [4,3,2,1]
 *     输出: [4,3,2,2]
 *     解释: 输入数组表示数字 4321。
 *
 * @author linhongxiang
 * @since 2020/9/22
 */
public class PlusOne {
    /**
     * 第一次解题思路：
     * 只要数字不是9，加一就结束了。
     * 如果数字是9，只要不是全部都是9，就不需要扩容
     * 否则数组容量需要+1
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            } else {
                if (i != 0) {
                    digits[i] = 0;
                } else {
                    int []array = new int[digits.length + 1];
                    array[0] = 1;
                    return array;
                }
            }
        }
        return digits;
    }

    /**
     * 第一次太多if else，能否优化？
     * 1. 因为只有9加了1之后才会进位，而加了9之后，当前位置的值为0，也即是如果当前位置为0了，就说明进位了，高一位的数字需要继续+1
     * 2. 特殊情况，所有的数字都是9，也即通过循环了整个数组，都没有找到一个+1后不为0的，需要扩充数组，首位置1
     */
    public int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
