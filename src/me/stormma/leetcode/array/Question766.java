package me.stormma.leetcode.array;

/**
 * 难度系数: 2星
 * leetcode 766
 * @author stormma
 * @date 2018/01/24
 */
public class Question766 {

    static class Solution {
        public boolean isToeplitzMatrix(int[][] matrix) {
            if (matrix == null) return false;
            return judge(matrix);
        }
        private boolean judge(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            for (int i = 0, j = 0; j < n; j++) {
                int s = i, t = j;
                while (++s < m && ++t < n) {
                    if (matrix[s][t] != matrix[i][j]) {
                        return false;
                    }
                }
            }
            for (int i = 0, j = 0; i < m; i++) {
                int s = i, t = j;
                while (++s < m && ++t < n) {
                    if (matrix[s][t] != matrix[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
