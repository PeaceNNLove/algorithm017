package Week_01.homework;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *    假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *    每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *    注意：给定 n 是一个正整数。
 *    示例 1：
 *        输入： 2
 *        输出： 2
 *    解释： 有两种方法可以爬到楼顶。
 *        1.  1 阶 + 1 阶
 *        2.  2 阶
 *    示例 2：
 *        输入： 3
 *        输出： 3
 *    解释： 有三种方法可以爬到楼顶。
 *        1.  1 阶 + 1 阶 + 1 阶
 *        2.  1 阶 + 2 阶
 *        3.  2 阶 + 1 阶
 *
 * @author linhongxiang
 * @since 2020/9/22
 */
public class ClimbStairs {
    /**
     * 第一遍解题思路：
     * 爬到第n层台阶，只能由n-1层台阶走一步或n-2层台阶走2步
     * fn = fn(n-1) + f(n-2)
     *
     * result: 递归法，超时，时间复杂度2^n
     */
    public int climbStairs(int n) {
        if (n < 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 第二次解题思路：
     * 使用n容量的数组，从1，2层台阶开始算出走到每一层的路径数。
     *
     * result：通过，但是空间复杂度O(n)
     */
    public int climbStairs2(int n) {
         if (n == 1 || n == 2) {
             return n;
         }
         int[] stairs = new int[n];
         stairs[0] = 1;
         stairs[1] = 2;
         for (int i = 2; i < n; i++) {
             stairs[i] = stairs[i - 2] + stairs[i - 1];
         }
         return stairs[n - 1];
    }

    /**
     * 第三次解题思路：
     * 实际上整个方程式只需要三个变量，使用三个变量分别记录f(n-1), f(n-2), f(n)的值
     *
     * 时间复杂度O（n）,空间复杂度O(1)
     */
    public int climbStairs3(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int p = 1;
        int q = 2;
        int result = 0;
        for (int i = 2; i < n; i++) {
            result = p + q;
            p = q;
            q = result;
        }
        return result;
    }
}
