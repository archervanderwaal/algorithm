package me.stormma.leetcode.array;

/**
 * 难度系数: 2星
 * leetcode 74
 * @author stormma
 * @date 2017/12/06
 */
public class Question74 {

    /**
     * Running time log(N*M)
     */
    static class Solution1 {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0) return false;
            int m = matrix.length, n = matrix[0].length;
            int low = 0, high = m * n - 1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                if (target > matrix[mid / n][mid % n]) {
                    low = mid + 1;
                } else if (target < matrix[mid / n][mid % n]) {
                    high = mid - 1;
                } else {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * Running time O(logN + logM)
     */
    static class Solution2 {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
            int m = matrix.length, n = matrix[0].length;
            int low = 0, high = m - 1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                if (target > matrix[mid][n - 1]) low = mid + 1;
                else if (target < matrix[mid][n - 1]) high = mid - 1;
                else return true;
            }
            if (low >= m) return false;
            int row = low;
            low = 0;
            high = n - 1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                if (target > matrix[row][mid]) {
                    low = mid + 1;
                } else if (target < matrix[row][mid]) {
                    high = mid - 1;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
}
