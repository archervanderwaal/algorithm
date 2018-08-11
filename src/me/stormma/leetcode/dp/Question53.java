package me.stormma.leetcode.dp;

import javafx.css.Match;

/**
 * leetcode 53最大子数组和问题 <a href="https://leetcode.com/problems/maximum-subarray/description/">题目链接</a>
 * @author stormma
 * @date 2017/10/19
 */
public class Question53 {

    static class Solution {
        public static int maxSubArray(int[] nums) {
            int currentSum = nums[0], max = currentSum;
            for (int i = 1; i < nums.length; i++) {
                currentSum = Math.max(currentSum + nums[i], nums[i]);
                if (max < currentSum) max = currentSum;
            }
            return max;
        }
    }

    static class Solution1 {
        public static int maxSubArray(int[] nums) {
            int maxSum = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                int thisSum = 0;
                for (int j = i; j < nums.length; j++) {
                    thisSum += nums[j];
                    if (maxSum < thisSum) {
                        maxSum = thisSum;
                    }
                }
            }
            return maxSum;
        }
    }
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(Solution1.maxSubArray(nums));
    }
}
