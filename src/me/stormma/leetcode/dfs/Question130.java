package me.stormma.leetcode.dfs;

/**
 * 难度系数 三星
 * leetcode 130
 * @author stormma
 * @date 2018/03/13
 */
public class Question130 {

    private static class Solution {

        static final int[][] LL = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };
        public void solve(char[][] board) {
            if (board == null || board.length == 0 || board[0].length == 0) return;
            int n = board.length, m = board[0].length;
            for (int i = 0; i < n; i++) {
                if (board[i][0] == 'O') dfs(board, i, 0);
                if (board[i][m - 1] == 'O') dfs(board, i, m - 1);
            }
            for (int i = 0; i < m; i++) {
                if (board[0][i] == 'O') dfs(board, 0, i);
                if (board[n - 1][i] == 'O') dfs(board, n - 1, i);
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 'O') board[i][j] = 'X';
                    if (board[i][j] == '$') board[i][j] = 'O';
                }
            }
        }

        private void dfs(char[][] board, int i, int j) {
            if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || board[i][j] != 'O') return;
            board[i][j] = '$';
            dfs(board, i + LL[0][0], j + LL[0][1]);
            dfs(board, i + LL[1][0], j + LL[1][1]);
            dfs(board, i + LL[2][0], j + LL[2][1]);
            dfs(board, i + LL[3][0], j + LL[3][1]);
        }
    }
}
