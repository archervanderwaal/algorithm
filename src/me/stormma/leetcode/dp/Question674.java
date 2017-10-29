package me.stormma.leetcode.dp;

/**
 * 难度系数: 2星
 * leetcode 674
 * @author stormma
 * @date 2017/10/28
 */
public class Question674 {

    static class Solution {
        public int findLengthOfLCIS(int[] nums) {
            int[] dp = new int[nums.length];
            if (nums.length == 0) {
                return 0;
            }
            dp[0] = 1;
            int max = dp[0];
            for (int i = 1; i < nums.length; i++) {
                max = Math.max(dp[i] = nums[i] > nums[i - 1] ? dp[i - 1] + 1: 1, max);
            }
            return max;
        }
    }
}
