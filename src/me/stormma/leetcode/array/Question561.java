package me.stormma.leetcode.array;

import java.util.Arrays;

/**
 * 难度系数： 1星
 * leetcode 561
 * @author stormma
 * @date 2017/10/28
 */
public class Question561 {

    static class Solution {
        public int arrayPairSum(int[] nums) {
            Arrays.sort(nums);
            int result = 0;
            for (int i = 0; i < nums.length; i += 2) {
                result += nums[i];
            }
            return result;
        }
    }
}
