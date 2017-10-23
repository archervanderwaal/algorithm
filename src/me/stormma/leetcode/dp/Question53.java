package me.stormma.leetcode.dp;

/**
 * 难度系数: 2星
 * leetcode 56 dp问题
 *
 * @author stormma
 * @date 2017/10/22
 */
public class Question53 {
    static class Solution {
        public int maxSubArray(int[] nums) {
            int[] dp = new int [nums.length];
            // dp[i] 表示以位置i结尾的最大子序列之和
            // dp[0] = nums[0], dp[1] = max(dp[0] + nums[1], nums[1])... dp[i] = max(dp[i-1] + nums[i], nums[i])
            dp[0] = nums[0];
            int max = dp[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
                if (dp[i] > max) {
                    max = dp[i];
                }
            }
            return max;
        }
    }
}
