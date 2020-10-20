package Week_01.homework;

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
//
// 示例:
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6
// Related Topics 栈 数组 双指针

import java.util.ArrayDeque;
import java.util.Deque;

public class Trap {
    /**
     * 左边找到一个比自己高的，右边找到一个比自己高的，雨水面积 = 两个边界之间的最大面积 - 区域内非雨水方块的面积
     */
//    public int trap(int[] height) {
//        if (height.length < 2) {
//            return 0;
//        }
//        Deque<Integer> stack = new ArrayDeque<>();
//        stack.addLast(0);
//
//        for (int i = 0; i < height.length; i++) {
//            while (height[i] < height[stack.])
//        }
//    }
}
