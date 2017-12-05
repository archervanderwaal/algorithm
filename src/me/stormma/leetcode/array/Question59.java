package me.stormma.leetcode.array;

/**
 * 难度系数: 3星
 * leetcode 59
 * @author stormma
 * @date 2017/12/04
 */
public class Question59 {

    static class Solution {
        public int[][] generateMatrix(int n) {
            int[][] ans = new int[n][n];
            fillArray(ans, n);
            return ans;
        }

        private void fillArray(int[][] array, int n) {
            if (n == 0) return;
            int xb = 0;
            int rowStart = 0, rowEnd = n - 1, columnStart = 0, columnEnd = n - 1;
            while (rowStart <= rowEnd && columnStart <= columnEnd) {
                for (int i = columnStart; i <= columnEnd; i++) {
                    array[rowStart][i] = ++xb;
                }
                rowStart++;
                for (int j = rowStart; j <= rowEnd; j++) {
                    array[j][columnEnd] = ++xb;
                }
                columnEnd--;
                if (rowStart <= rowEnd) {
                    for (int j = columnEnd; j >= columnStart; j--) {
                        array[rowEnd][j] = ++xb;
                    }
                }
                rowEnd--;
                if (columnStart <= columnEnd) {
                    for (int j = rowEnd; j >= rowStart; j--) {
                        array[j][columnStart] = ++xb;
                    }
                }
                columnStart++;
            }
        }
    }
}
