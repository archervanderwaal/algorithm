package me.stormma.leetcode.stack;

import java.util.Stack;

/**
 * 难度系数: 3星
 * leetcode 739
 * @author stormma
 * @date 2017/12/07
 */
public class Question739 {

    /**
     * 维护一个单调递减栈
     */
    static class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            if (temperatures == null || temperatures.length == 0) return null;
            Stack<Integer> stack = new Stack<>();
            int[] ans = new int[temperatures.length];
            for (int i = 0; i < temperatures.length; i++) {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    int index = stack.pop();
                    ans[index] = i - index;
                }
                stack.push(i);
            }
            return ans;
        }
    }
}
