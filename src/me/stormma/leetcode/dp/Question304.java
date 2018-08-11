package me.stormma.leetcode.dp;

/**
 * leetcode 304.Range Sum Query 2D - Immutable
 * @author stormma
 * @date 2018/03/14
 */
public class Question304 {

    /**
     * dp
     * time: O(n * m)
     * space: O(n * m)
     */
    static class NumMatrix {

        private int[][] dp;
        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
            int n = matrix.length, m = matrix[0].length;
            dp = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
        }
    }
}
