package me.stormma.leetcode.dp;

import java.util.Arrays;

/**
 * leetcode 406. Partition Equal Subset Sum
 * @author stormma
 * @date 2018/03/14
 */
public class Question406 {

    static class Solution {
        public boolean canPartition(int[] nums) {
            if (nums == null || nums.length == 0) return false;
            Arrays.sort(nums);
            int[] sum = new int[nums.length + 1];
            for (int i = 1; i <= nums.length; i++) {
                sum[i] = sum[i - 1] + nums[i - 1];
            }
            for (int i = nums.length - 2; i >= 0; --i) {
                if (sum[nums.length] == 2 * sum[i + 1]) return true;
            }
            return false;

            // 1 5 5 11
            // 22 -
        }

        public static void main(String[] args) {
            int[] nums = {1, 2, 3, 4, 5, 6, 7};
            System.out.println(new Solution().canPartition(nums));
        }
    }
}
