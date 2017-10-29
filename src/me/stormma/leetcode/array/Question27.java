package me.stormma.leetcode.array;

/**
 * 难度xish : 1星
 * leetcode 27
 * @author stormma
 * @date 2017/10/28
 */
public class Question27 {
    static class Solution {
        public int removeElement(int[] nums, int val) {
            int high = nums.length - 1, low = 0;
            while (low <= high) {
                if (nums[low] == val) {
                    // remove it
                    nums[low] = nums[high];
                    high--;
                    if (nums[low] != val) {
                        low++;
                    }
                } else {
                    low++;
                }
            }
            return high + 1;
        }
    }
}
