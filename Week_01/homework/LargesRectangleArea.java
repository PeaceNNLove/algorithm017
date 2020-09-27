package Week_01.homework;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author linhongxiang
 * @since 2020/9/26
 */
public class LargesRectangleArea {
    /**
     * 使用栈。
     * 按从左到右将柱子进栈，栈底到栈顶的元素从小到大排列，就能表明上层的柱子的左边界就是下一层的柱子。
     * 而当试图入栈的元素比当前栈顶的元素小时，就找到了栈顶元素的右边界，那么就可以计算出栈顶元素的最大面积。
     * 不断出栈之后，还未入栈的小元素最终还是会进栈，所以不会漏掉当前未进栈的小元素。
     */
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }

        /*
         * 头部加0，防止将所有元素出栈之后空指针了，取值空指针了。
         * 尾部加0，防止所有柱子等高，进入不到计算循环中
         */
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, heights.length);
        newHeights[newHeights.length - 1] = 0;
        heights = newHeights;

        Deque<Integer> stack = new ArrayDeque<>(heights.length);
        stack.addLast(0);
        int res = 0;
        for (int i = 1; i < heights.length; i++) {
            while (heights[i] < heights[stack.peekLast()]) {
                int currentHeight = heights[stack.pollLast()];
                int currentWidth = i - stack.peekLast() - 1;    // 减一原因，n号柱子和n-2号柱子之间的距离是2，但是宽度是3
                res = Math.max(res, currentHeight * currentWidth);
            }
            stack.addLast(i);
        }
        return res;
    }
}
