package me.stormma.leetcode.dfs;

import java.util.ArrayList;
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
            // map[i][j] represent i + 1 row j +1 column wheather have queen. if true yes, else no
            boolean[][] map = new boolean[n][n];
            List<List<String>> ans = new ArrayList<>();
            for (int c = 0; c < n; c++) {
                map[0][c] = true;
                List<String> tmp = new ArrayList<String>();
                char[] array = new char[n];
                for (int i = 0; i < n; i++) {
                    if (i == c) array[i] = 'Q';
                    else array[i] = '.';
                }
                tmp.add(new String(array));
                dfs(map, 1, ans, tmp, n);
                map[0][c] = false;
            }
            return ans;
        }

        private void dfs(boolean[][] map, int row, List<List<String>> ans, List<String> tmp, int n) {
            if (row == n) {
                ans.add(new ArrayList<>(tmp));
                return;
            }

            // trivalse map
            for (int c = 0; c < n; c++) {
                boolean valid = true;
                // check column
                for (int r = 0; r < row; r++) {
                    if (map[r][c]) {
                        valid = false;
                    }
                }
                // check row. finshed
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
                    for (int i = 0; i < n; i++) {
                        if (i == c) array[i] = 'Q';
                        else array[i] = '.';
                    }
                    tmp.add(new String(array));
                    dfs(map, row + 1, ans, tmp, n);
                    map[row][c] = false;
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }
}
