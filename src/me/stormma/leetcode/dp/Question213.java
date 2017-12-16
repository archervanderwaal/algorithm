package me.stormma.leetcode.dp;

import me.stormma.leetcode.linkedlist.Question21;

/**
 * 难度系数: 3星
 * leetcode 213.
 * @author stormma
 * @date 2017/10/23
 */
public class Question213 {

    static class Solution {
        private int rob(int[] nums, int low, int high) {

            int include = 0, exclude = 0;
            for (int j = low; j <= high; j++) {
                int i = include, e = exclude;
                include = e + nums[j];
                exclude = Math.max(e, i);
            }
            return Math.max(include, exclude);
        }

        public int rob(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
        }
    }
}
