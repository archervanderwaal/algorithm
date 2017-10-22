package me.stormma.leetcode.dfs;

/**
 * 难度系数: 2星(较简单)
 * leetcode 695. max area of Island, <a href="https://leetcode.com/problems/max-area-of-island">题目链接</a>
 *
 * @author stormma
 * @date 2017/10/21
 */
public class Question695 {
    static class Solution {

        private static int[]ds = {-1, 0, 1, 0, 0, 1, 0, -1};

        private int dfs(int[][] grid, int x, int y, int m, int n, int area) {
            // Boundary conditions
            if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0) {
                return area;
            }
            grid[x][y] = 0;
            area++;
            for (int i = 0; i < ds.length; i += 2) {
                // new coordinates
                int nx = x + ds[i];
                int ny = y + ds[i + 1];
                area = dfs(grid, nx, ny, m, n, area);
            }
            return area;
        }

        public int maxAreaOfIsland(int[][] grid) {
            if (grid.length == 0) {
                return 0;
            }
            int result = 0;
            int m = grid.length, n = grid[0].length;
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    // start with Island.
                    if (grid[x][y] == 1) {
                        int area = dfs(grid, x, y, m, n, 0);
                        result = Math.max(result, area);
                    }
                }
            }
            return result;
        }
    }
}
