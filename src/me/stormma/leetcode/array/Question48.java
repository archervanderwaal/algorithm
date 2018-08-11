package me.stormma.leetcode.array;

/**
 * 难度系数 3星
 * leetcode 48
 * @author stormma
 * @date 2017/11/30
 */
public class Question48 {

    static class Solution {
        public void rotate(int[][] matrix) {
            // rotate 1.
            for (int i = 0; i < matrix.length; i++) {
                for (int j = i + 1; j < matrix[i].length; j++) {
                    if (i != j) {
                        swap(matrix, i, j, j, i);
                    }
                }
            }


            // rotate2.
            for (int i = 0; i < matrix.length; i++) {
                int len = matrix[i].length;
                //[i][0], [i][1], [i][2]
                int j = 0;
                while (j < len / 2) {
                    swap(matrix, i, j, i, len - j - 1);
                    j++;
                }
            }
        }

        private void swap(int[][] matrix, int x, int y, int nx, int ny) {
            int temp = matrix[x][y];
            matrix[x][y] = matrix[nx][ny];
            matrix[nx][ny] = temp;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new Solution().rotate(matrix);
    }
}
