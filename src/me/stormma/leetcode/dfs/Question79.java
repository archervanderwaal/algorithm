package me.stormma.leetcode.dfs;

/**
 * 难度系数: 3星
 * leetcode 79
 * @author stormma
 * @date 2017/12/06
 */
public class Question79 {

    static class Solution {

        static final int[][] coor = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public boolean exist(char[][] board, String word) {
            if (board == null || board.length == 0 || board[0].length == 0 && word == null || word.isEmpty() || board.length * board[0].length < word.length()) {
                return false;
            }
            boolean[][] marked = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    // 剪枝
                    if (board[i][j] == word.toCharArray()[0]) {
                        marked[i][j] = true;
                        if (dfs(board, marked, word.toCharArray(), 1, i, j)) {
                            return true;
                        }
                        marked[i][j] = false;
                    }
                }
            }
            return false;
        }

        private boolean dfs(char[][] board, boolean[][] marked, char[] word, int si, int x, int y) {
            if (si == word.length) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + coor[i][0], ny = y + coor[i][1];
                if (nx < 0 || nx > board.length - 1 || ny < 0 || ny > board[0].length - 1 || marked[nx][ny] || board[nx][ny] != word[si]) continue;
                marked[nx][ny] = true;
                if (dfs(board, marked, word, si + 1, nx, ny)) return true;
                marked[nx][ny] = false;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(new Solution().exist(board, "SEE"));
    }
}
