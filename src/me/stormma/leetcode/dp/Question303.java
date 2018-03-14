package me.stormma.leetcode.dp;

/**
 * leetcode 303 Range Sum Query - Immutable
 * @author stormma
 * @date 2018/03/14
 */
public class Question303 {

    /**
     * dp 超时
     */
    static class NumArray1 {

        private int[][] dp;

        public NumArray1(int[] nums) {
            int n = nums.length;
            // dp[i][j] 表示i -> j的元素和
            dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                dp[i][i] = nums[i];
            }
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    dp[i][j] = dp[i][j - 1] + nums[j];
                }
            }
        }

        public int sumRange(int i, int j) {
            return dp[i][j];
        }
    }

    /**
     * 前缀和
     */
    static class NumArray2 {
        private int[] sum;
        public NumArray2(int[] nums) {
            sum = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                sum[i + 1] = sum[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return sum[j + 1] - sum[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray2 numArray = new NumArray2(nums);
        System.out.println(numArray.sumRange(0, 5));
    }
}
