package me.stormma.leetcode.array;

/**
 * 难度系数: 2星
 * leetcode 566
 * @author stormma
 * @date 2017/10/28
 */
public class Question566 {

    static class Solution {
        public int[][] matrixReshape(int[][] nums, int r, int c) {
            int m = nums.length, n = nums[0].length;
            if (r * c != m * n || m == r) {
                return nums;
            }
            int[][] ans = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    // i * c + j
                    ans[i][j] = nums[(i * c + j) / n][(i * c + j) % n];
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[][] data = {{1, 2, 3, 4}};
        int[][] ans = new Solution().matrixReshape(data, 2, 2);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
