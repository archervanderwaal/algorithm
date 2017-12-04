package me.stormma.leetcode.dfs;

/**
 * 难度系数: 4星
 * leetcode 52
 * @author stormma
 * @date 2017/12/04
 */
public class Question52 {

    static class Solution {

        static int ans;

        public int totalNQueens(int n) {
            ans = 0;
            boolean[][] map = new boolean[n][n];
            dfs(map, 0, n);
            return ans;
        }

        private void dfs(boolean[][] map, int row, int n) {
            if (row == n) {
                ans++;
                return;
            }
            for (int c = 0; c < n; c++) {
                boolean valid = true;
                for (int r = 0; r < row; r++) {
                    if (map[r][c]) {
                        valid = false;
                    }
                }
                int x = row, y = c;
                while (valid && x > 0 && y > 0) {
                    if (map[--x][--y]) valid = false;
                }
                x = row;
                y = c;
                while (valid && x > 0 && y + 1 < n) {
                    if (map[--x][++y]) valid = false;
                }

                if (valid) {
                    map[row][c] = true;
                    dfs(map, row + 1, n);
                    map[row][c] = false;
                }
            }
        }
    }
}
