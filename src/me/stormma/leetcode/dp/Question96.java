package me.stormma.leetcode.dp;

/**
 * 难度系数: 3星(一搬)，比较难的是，状态方程推导
 * leetcode 96
 * @author stormma
 * @date 2017/10/23
 */
public class Question96 {

    static class Solution {
        public int numTrees(int n) {
            if (n == 0 || n == 1 || n == 2) {
                return n;
            }
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    dp[i] += dp[j - 1] * dp[i - j];
                }
            }
            return dp[n];
        }
    }
}
