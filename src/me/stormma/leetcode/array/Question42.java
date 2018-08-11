package me.stormma.leetcode.array;

import java.util.Stack;

/**
 * 难度系数: 3星
 * leetcode 42
 * @author stormma
 * @date 2017/11/30
 */
public class Question42 {

    static class Solution {
        public int trap(int[] height) {
            int ans = 0;

            Stack<Integer> stack = new Stack<Integer>();
            int tmp = 0;
            for (int i = 0; i < height.length; i++) {
                if (height[i] == 0 && i == 0) continue;

                if (stack.isEmpty()) {
                    stack.push(height[i]);
                } else if (height[i] >= stack.peek()) {
                    stack.pop();
                    stack.push(height[i]);
                    ans += tmp;
                    tmp = 0;
                } else {
                    tmp += stack.peek() - height[i];
                }
            }
            return ans;
        }
    }

    static class Solution2 {
        public int trap(int[] height) {
            if (height.length < 3) return 0;
            int left = 0, right = height.length - 1, ans = 0;
            while (left < right && height[left] <= height[left + 1]) left++;
            while (left < right && height[right] <= height[right - 1]) right--;

            while (left < right) {
                int left_height = height[left], right_height = height[right];
                if (left_height <= right_height) {
                    while (left < right && left_height >= height[++left]) {
                        ans +=  left_height - height[left];
                    }
                } else {
                    while (left < right && height[--right] <= right_height) {
                        ans += right_height - height[right];
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new Solution().trap(height));
    }
}
