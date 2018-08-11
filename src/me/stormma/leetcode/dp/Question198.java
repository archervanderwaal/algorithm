package me.stormma.leetcode.dp;

/**
 * 难度系数: 2星
 * leetcode 198
 * @author stormma
 * @date 2017/10/23
 */
public class Question198 {
    static class Solution {
        public int rob(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            // dp[i] --> max(dp[i - 1], dp[i - 2] + nums[i], dp[i - 3] + nums[i]) //状态转移方程
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                // dp[i] = Math.max(Math.max(dp[i - 2] + nums[i], dp[i - 3] + nums[i]), dp[i - 1]);
                dp[i] = (i - 2) < 0 ? Math.max(nums[i], dp[i - 1]) : (i - 3) < 0 ? Math.max(Math.max(nums[i], dp[i - 2] + nums[i]), dp[i - 1]) : Math.max(Math.max(dp[i - 1], dp[i - 2] + nums[i]), dp[i - 3] + nums[i]);
            }
            return dp[nums.length - 1];
        }
    }

    static class Solution2 {
        public int rob(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int pre1 = 0, pre2 = 0;
            for (int money: nums) {
                int max = Math.max(pre2 + money, pre1);
                pre2 = pre1;
                pre1 = max;
            }
            return pre1;
        }
    }
}
