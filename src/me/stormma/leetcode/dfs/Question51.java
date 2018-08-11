package me.stormma.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 难度系数: 4星
 * leetcode 51
 * @author stormma
 * @date 2017/12/04
 */
public class Question51 {

    static class Solution {
        public List<List<String>> solveNQueens(int n) {
            boolean[][] map = new boolean[n][n];
            List<List<String>> ans = new ArrayList<>();
            dfs(map, 0, ans, new ArrayList<String>(), n);
            return ans;
        }

        private void dfs(boolean[][] map, int row, List<List<String>> ans, List<String> tmp, int n) {
            if (row == n) {
                ans.add(new ArrayList<>(tmp));
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
                    char[] array = new char[n];
                    Arrays.fill(array, '.');
                    array[c] = 'Q';
                    tmp.add(new String(array));
                    dfs(map, row + 1, ans, tmp, n);
                    map[row][c] = false;
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }
}
