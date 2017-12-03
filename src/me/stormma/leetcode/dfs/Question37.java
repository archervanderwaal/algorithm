package me.stormma.leetcode.dfs;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * 解决算法: df+backtracking
 * 难度系数 4星
 * leetcode 37
 * @author stormma
 * @date 2017/11/27
 */
public class Question37 {

    static class Solution {
        private static final int COUNT = 9;
        private static final Map<Integer, Boolean[]> rows = new HashMap<>();
        private static final Map<Integer, Boolean[]> columns = new HashMap<>();
        private static final Map<Integer, Boolean[]> boxes = new HashMap<>();

        public void solveSudoku(char[][] board) {
            init();
            // traverse the board
            for (int i = 0; i < COUNT; i++) {
                for (int j = 0; j < COUNT; j++) {
                    if (board[i][j] != '.') {
                        int n = board[i][j] - '0';
                        // mark it was used
                        rows.get(i)[n] = true;
                        columns.get(j)[n] = true;
                        boxes.get((i / 3) * 3 + j / 3)[n] = true;
                    }
                }
            }
            dfs(board, 0, 0);
        }

        private void init() {
            for (int i = 0; i < COUNT; i++) {
                Boolean[] booleans1 = new Boolean[10];
                Boolean[] booleans2 = new Boolean[10];
                Boolean[] booleans3 = new Boolean[10];
                for (int j = 0; j <= COUNT; j++) {
                    booleans3[j] = booleans2[j] = booleans1[j] = false;
                }
                rows.put(i, booleans1);
                columns.put(i, booleans2);
                boxes.put(i, booleans3);
            }
        }

        private boolean dfs(char[][] board, int x, int y) {
            if (x == COUNT) {
                return true;
            }
            int ny = (y + 1) % COUNT;
            int nx = (ny == 0) ? x + 1 : x;
            if (board[x][y] != '.') {
                return dfs(board, nx, ny);
            }
            for (int i = 1; i <= COUNT; i++) {
                // (x, y) => get index of box.
                int boxInd = (x / 3) * 3 + y / 3;
                // if i not was used
                if (!rows.get(x)[i] && !columns.get(y)[i] && !boxes.get(boxInd)[i]) {
                    // mark it was used
                    boxes.get(boxInd)[i] = columns.get(y)[i] = rows.get(x)[i] = true;
                    board[x][y] = (char) (i + '0');
                    if (dfs(board, nx, ny)) {
                        return true;
                    }
                    board[x][y] = '.';
                    boxes.get(boxInd)[i] = columns.get(y)[i] = rows.get(x)[i] = false;
                }
            }
            return false;
        }
    }


    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                          {'6','.','.','1','9','5','.','.','.'},
                          {'.','9','8','.','.','.','.','6','.'},
                          {'8','.','.','.','6','.','.','.','3'},
                          {'4','.','.','8','.','3','.','.','1'},
                          {'7','.','.','.','2','.','.','.','6'},
                          {'.','6','.','.','.','.','2','8','.'},
                          {'.','.','.','4','1','9','.','.','5'},
                          {'.','.','.','.','8','.','.','7','9'}};
        new Solution().solveSudoku(board);
    }
}
