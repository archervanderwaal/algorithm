package me.stormma.leetcode.math;

import java.util.Stack;

/**
 * 难度系数: 2星
 * leetcode 66
 * @author stormma
 * @date 2017/12/04
 */
public class Question66 {

    static class Solution {
        public int[] plusOne(int[] digits) {
            int high = digits.length - 1;
            if (digits[high] + 1 < 10) {
                digits[high] += 1;
                return digits;
            }
            Stack<Integer> stack = new Stack<>();
            int carry = 1;
            while (high >= 0) {
                int num = digits[high] + carry;
                if (num >= 10) {
                    stack.push(num % 10);
                    carry = num / 10;
                } else {
                    stack.push(num);
                    carry = 0;
                }
                high--;
            }
            if (carry != 0) {
                stack.push(carry);
            }
            int[] ans = new int[stack.size()];
            int ind = 0;
            while (!stack.isEmpty()) {
                ans[ind++] = stack.pop();
            }
            return ans;
        }
    }
}
