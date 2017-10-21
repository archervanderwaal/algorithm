package me.stormma.leetcode.binary_search;

/**
 * leetcode 35. Search Insert Position <a href="https://leetcode.com/problems/maximum-subarray/">题目链接</a>
 *
 * @author stormma
 * @date 2017/10/20
 */
public class Question35 {

    static class Solution {
        public int maxSubArray(int[] nums) {
            // just is binary search
            int maxSum = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                int thisSum = 0;
                for (int j = i; j < nums.length; j++) {
                    thisSum += nums[j];
                    if (maxSum < thisSum) {
                        maxSum = thisSum;
                    }
                }
            }
            return maxSum;
        }
    }
}
