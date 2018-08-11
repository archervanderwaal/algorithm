package me.stormma.leetcode.bit_manipulation;

/**
 * 难度系数: 1星
 * leetcode 136
 * @author stormma
 * @date 2017/11/03
 */
public class Question136 {

    static class Solution {
        public int singleNumber(int[] nums) {
            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                ans ^= nums[i];
            }
            return ans;
        }
    }
}
