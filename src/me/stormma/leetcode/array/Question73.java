package me.stormma.leetcode.array;

/**
 * 难度系数: 3星
 * leetcode 73
 * @author stormma
 * @date 2017/12/06
 */
public class Question73 {

    /**
     * WA code
     *
     * ×
     */
    static class Solution1 {
        public void setZeroes(int[][] matrix) {
            if (matrix == null || matrix.length == 0) return;
            helper(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1);
        }

        private void helper(int[][] matrix, int startRow, int startColumn, int endRow, int endColumn) {
            int m = matrix.length, n = matrix[0].length;
            if (startRow > endRow || startColumn > endColumn) return;
            boolean flag = false;
            int row = -1, column = -1;
            for (int i = startRow; i <= endRow; i++) {
                for (int j = startColumn; j <= endColumn; j++) {
                    if (matrix[i][j] == 0) {
                        row = i;
                        column = j;
                        flag = true;
                        break;
                    }
                }
                if (flag) break;
            }
            if (flag) {
                // replace row
                for (int c = startColumn; c <= endColumn; c++) matrix[row][c] = 0;
                // replace column
                for (int r = startRow; r <= endRow; r++) matrix[r][column] = 0;

                helper(matrix, startRow, startColumn, row - 1, column - 1);
                helper(matrix, startRow, column + 1, row - 1, endColumn);
                helper(matrix, row + 1, startColumn, endRow, column - 1);
                helper(matrix, row + 1, column + 1, endRow, endColumn);
            }
        }
    }


    /**
     * AC code
     * √
     */
    static class Solution2 {
        public void setZeroes(int[][] matrix) {
            if (matrix == null || matrix.length == 0) return;

            /**
             为什么要对第0行和第0列进行标记呢？假如矩阵如下:
             1 0 1
             1 1 1
             1 1 1
             按照我们的思路，标记成
             0 0 1
             1 1 1
             1 1 1
             后面进行遍历replace时候，如果i <- 0 to m j <- 0 to n
             此时[0][0] = 0 ，这时候如果没有对0行0列进行特殊标记的话，
             我们会误把第0列也replace掉。故进行row, column的特殊标记，并且
             replace时候从1开始。
             */
            boolean row = false, column = false;
            int m = matrix.length, n = matrix[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                        if (i == 0) row = true;
                        if (j == 0) column = true;
                    }
                }
            }
            for (int i = 1; i < m; i++) {
                if (matrix[i][0] == 0) {
                    for (int j = 1; j < n; j++) {
                        matrix[i][j] = 0;
                    }
                }
            }
            for (int j = 1; j < n; j++) {
                if (matrix[0][j] == 0) {
                    for (int i = 1; i < m; i++) {
                        matrix[i][j] = 0;
                    }
                }
            }
            if (row) {
                for (int j = 0; j < n; j++) {
                    matrix[0][j] = 0;
                }
            }
            if (column) {
                for (int i = 0; i < m; i++) {
                    matrix[i][0] = 0;
                }
            }
        }
    }

    public static void main(String... args) {
        int[][] matrix = {
                {0, 1, 2, 3},
                {1, 2, 3, 4},
                {4, 5, 6, 7},
                {1, 0, 2, 3}
        };
        new Solution1().setZeroes(matrix);
    }
}
