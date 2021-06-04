package Solution.StackAndQueue;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * 单调栈主要用于求
 *      某个数字距离最近、满足某关系的数字
 *      比如：求数字 i 右边第一个小于它的数
 */
public class 单调栈 {
    /**
     * 下一个最大数字（每日温度）
     * https://leetcode-cn.com/problems/daily-temperatures/description/
     * 单调栈最基础的应用，求相邻的最大数字
     */
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            if (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                    ans[stack.peek()] = i - stack.pop();
                }
            }
            stack.push(i);
        }
        return ans;
    }

    @Test
    public void testDailyTemperatures() {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }

    /**
     * 柱状图中最大的矩形
     * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
     * 每一个高度的方块，左右两边第一个低于它的方块就是它的面积边界
     * 采用单调递增栈，需要弹栈时就遇到了右边界，左边界自然就是上一个低于它的方块了
     */
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i = 0; i < heights.length; i++) {
            if(!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                while(!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                    stack.pop();
                }
            }
            stack.push(i);
        }
        return max;
    }

    @Test
    public void testLargestRectangleArea() {
        int[] heights = {2,1,5,6,5,2,3};
        System.out.println(largestRectangleArea(heights));
    }
}
