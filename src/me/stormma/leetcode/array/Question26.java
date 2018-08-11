package me.stormma.leetcode.array;

/**
 * 难度系数: 1星
 * leetcode 26
 * @author stormma
 * @date 2017/11/07
 */
public class Question26 {

    static class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length < 2) {
                return nums.length;
            }
            int ans = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[i - 1]) {
                    nums[ans++] = nums[i];
                }
            }
            return ans;
        }
    }
}
