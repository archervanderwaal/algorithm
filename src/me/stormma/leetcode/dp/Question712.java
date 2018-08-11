package me.stormma.leetcode.dp;

/**
 * 难度系数: 4星
 * leetcode 712.
 * @author stormma
 * @date 2017/10/23
 */
public class Question712 {
    static class Solution {
        public int minimumDeleteSum(String s1, String s2) {
            int m = s1.length(), n = s2.length();
            // dp[i][j]
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = 0;
                    } else if (i == 0) {
                        dp[0][j] = dp[0][j - 1] + (int)s2.charAt(j - 1);
                    } else if (j == 0) {
                        dp[i][0] = dp[i - 1][0] + (int)s1.charAt(i - 1);
                    } else {
                        // dp[i][j] and i != 0 and j != 0
                        int last = dp[i - 1][j - 1];
                        if (s1.charAt(i - 1) != s2.charAt(j - 1)) {
                            last += (int)s1.charAt(i - 1) + (int)s2.charAt(j - 1);
                        }
                        dp[i][j] = Math.min(last, Math.min(dp[i - 1][j] + (int)s1.charAt(i - 1), dp[i][j - 1] + (int)s2.charAt(j - 1)));
                    }
                }
            }
            return dp[m][n];
        }
    }
}
