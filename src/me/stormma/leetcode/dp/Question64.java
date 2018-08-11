package me.stormma.leetcode.dp;

/**
 * 难度系数: 2星(很简单的题目)
 * leetcode 64.
 * @author stormma
 * @date 2017/10/22
 */
public class Question64 {

    static class Solution {
        public int minPathSum(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            // create dp array. dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            int[][] dp = new int [m][n];
            // 0th column pre array sum;
            int[] column0PreSum = new int[m];
            column0PreSum[0] = grid[0][0];
            for (int i = 1; i < m; i++) {
                column0PreSum[i] = column0PreSum[i - 1] + grid[i][0];
            }
            // 0th row pre array sum
            int[] row0PreSum = new int[n];
            row0PreSum[0] = grid[0][0];
            for (int j = 1; j < n; j++) {
                row0PreSum[j] = row0PreSum[j - 1] + grid[0][j];
            }
            // init dp array
            dp[0][0] = grid[0][0];
            for (int j = 0; j < n; j++) {
                dp[0][j] = row0PreSum[j];
            }
            for (int i = 0; i < m; i++) {
                dp[i][0] = column0PreSum[i];
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
            return dp[m - 1][n - 1];
        }
    }

    /**
     * 后来发现前缀数组是不需要的，删除两个O(n)复杂度的求前缀和步骤。
     */
    static class Solution2 {
        public int minPathSum(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            // create dp array. dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            int[][] dp = new int [m][n];
            // init dp array
            dp[0][0] = grid[0][0];
            for (int j = 1; j < n; j++) {
                dp[0][j] = dp[0][j - 1] + grid[0][j];
            }
            for (int i = 1; i < m; i++) {
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
            return dp[m - 1][n - 1];
        }
    }
}
