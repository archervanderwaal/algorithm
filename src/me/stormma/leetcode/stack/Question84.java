package me.stormma.leetcode.stack;

import java.util.Stack;

/**
 * 难度系数: 3星
 * leetcode 84
 *
 * @author stormma
 * @date 2017/12/07
 */
public class Question84 {

    /**
     * 时间复杂度 O(n^2)
     * TLE
     */
    static class Solution1 {
        public int largestRectangleArea(int[] heights) {
            if (heights == null || heights.length == 0) return 0;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < heights.length; i++) {
                int wid = 1;
                for (int j = i + 1; j < heights.length; j++) {
                    if (heights[i] <= heights[j]) wid++;
                    else break;
                }
                for (int j = i - 1; j >= 0; j--) {
                    if (heights[i] <= heights[j]) wid++;
                    else break;
                }
                if (heights[i] * wid > max) max = heights[i] * wid;
            }
            return max;
        }
    }

    /**
     * 单调栈
     * 时间复杂度 O(n)
     */
    static class Solution2 {
        public int largestRectangleArea(int[] heights) {
            if (heights == null || heights.length == 0) return 0;
            Stack<Integer> stack = new Stack<>();
            int ans = 0;
            int[] tmp = new int[heights.length + 1];
            System.arraycopy(heights, 0, tmp, 0, heights.length);
            tmp[heights.length] = -1;
            heights = tmp;
            for (int i = 0; i < heights.length; i++) {
                if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                    stack.push(i);
                } else {
                    while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                        int cur = heights[stack.pop()];
                        int left = -1;
                        if (!stack.isEmpty()) left = stack.peek();
                        ans = Math.max(ans, cur * (i - left - 1));
                    }
                    stack.push(i);
                }
            }
            return ans;
        }
    }

    /**
     * from leetcode discuss
     */
    static class Solution3 {
        public int largestRectangleArea(int[] heights) {
            return find(heights, 0, heights.length - 1);
        }

        private int find(int[] h, int left, int right) {
            if (left > right) return 0;
            if (left == right) return h[left];
            int minIndex = left;
            boolean sorted = true;
            for (int i = left + 1; i <= right; i++) {
                if (h[i] < h[i - 1]) sorted = false;
                if (h[i] < h[minIndex]) minIndex = i;
            }
            if (sorted) {
                int max = 0;
                for (int i = left; i <= right; i++) {
                    if (h[i] * (right - i + 1) > max) max = h[i] * (right - i + 1);
                }
                return max;
            } else {
                int maxLeft = find(h, left, minIndex - 1);
                int maxRight = find(h, minIndex + 1, right);
                int crossMax = h[minIndex] * (right - left + 1);
                return Math.max(Math.max(maxLeft, maxRight), crossMax);
            }
        }
    }

    public static void main(String... args) {
        int[] heights = {1, 2, 2};
        System.out.println(new Solution2().largestRectangleArea(heights));
    }
}
