package me.stormma.leetcode.dfs;

/**
 * leetcode 200
 * @author stormma
 * @date 2018/03/13
 */
public class Question200 {

    private static class Solution {
        private static final int[][] LL = {
                {-1, 0},
                {0, 1},
                {1, 0},
                {0, -1}
        };
        public int numIslands(char[][] grid) {
            int count = 0;
            if (grid == null) return 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        dfs(grid, i, j);
                        count++;
                    }
                }
            }
            return count;
        }

        private void dfs(char[][] grid, int x, int y) {
            if (x < 0 || x > grid.length - 1 || y < 0 || y > grid[0].length - 1 || grid[x][y] != '1') return;
            grid[x][y] = '0';
            dfs(grid, x + LL[0][0], y + LL[0][1]);
            dfs(grid, x + LL[1][0], y + LL[1][1]);
            dfs(grid, x + LL[2][0], y + LL[2][1]);
            dfs(grid, x + LL[3][0], y + LL[3][1]);
        }
    }

    public static void main(String[] args) {
        long s = 88273515312500000L;
        System.out.println(s);
    }
}
