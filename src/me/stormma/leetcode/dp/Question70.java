package me.stormma.leetcode.dp;

/**
 * 难度系数: 2星
 * leetcode 70.
 * @author stormma
 * @date 2017/10/22
 */
public class Question70 {

    /**
     * dp
     */
    static class Solution {
        public int climbStairs(int n) {
            // dp[i] represents the kind of stairs climbed to ith.
            // also, we can get dp[i] = dp[i - 1] + dp[i - 2];
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }

    /**
     * 记忆化搜索
     */
    static class Solution2 {

        public int climbStairs(int n) {
            int[] memo = new int[n + 1];
            return solve(n, memo);
        }

        private int solve(int n, int[] memo) {
            if (n < 2) {
                return 1;
            }
            return memo[n] = (memo[n - 1] != 0 ? memo[n - 1] : solve(n - 1, memo)) + (memo[n - 2] != 0 ? memo[n - 2] : solve(n - 2, memo));
        }
    }

    /**
     * 优化空间复杂度
     */
    static class Solution3 {
        public int climbStairs(int n) {
            int pre1 = 1, pre2 = 1, curr = 1;
            for (int i = 2; i <= n; i++) {
                curr = pre1 + pre2;
                pre2 = pre1;
                pre1 = curr;
            }
            return curr;
        }
    }
}
