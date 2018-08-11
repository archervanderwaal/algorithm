package me.stormma.leetcode.dp;

/**
 * 难度分析: 3星(要想到处理第0行和第0列的特殊情况。)
 * leetcode 63
 * @author stormma
 * @date 2017/10/22
 */
public class Question63 {
    static class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length, n = obstacleGrid[0].length;
            if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
                return 0;
            }
            int[][] dp = new int[m][n];
            dp[0][0] = 1;
            // init 0th row. 0 0 0 0 0 1 0 0 0 0
            for (int i = 1; i < n; i++) {
                if (obstacleGrid[0][i] == 1 || i > 1 && dp[0][i - 1] == 0) {
                    dp[0][i] = 0;
                } else {
                    dp[0][i] = 1;
                }
            }
            // init 0th column
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[j][0] == 1 || j > 1 && dp[j - 1][0] == 0) {
                    dp[j][0] = 0;
                } else {
                    dp[j][0] = 1;
                }
            }
            // after init
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }
            return dp[m-1][n-1];
        }
    }

    /**
     * 记忆化搜索
     */
    static class Solution1 {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length, n = obstacleGrid[0].length;
            int[][] memo = new int[m][n];
            // init memo
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    memo[i][j] = -1;
                }
            }
            return paths(obstacleGrid, m - 1, n - 1, m, n, memo);
        }

        private int paths(int[][] obstacleGrid, int x, int y, int m, int n, int[][] memo) {
            if (x >= m || y >= n || x <= 0 || y <= 0) {
                return 0;
            }
            if (obstacleGrid[x][y] == 1) {
                return memo[x][y] = 0;
            }
            if (memo[x][y] != -1) {
                return memo[x][y];
            }
            return memo[x][y] = paths(obstacleGrid, x - 1, y, m, n, memo) + paths(obstacleGrid, x, y - 1, m, n, memo);
        }
    }
}
