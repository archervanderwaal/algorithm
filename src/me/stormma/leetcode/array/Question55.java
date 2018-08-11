package me.stormma.leetcode.array;

/**
 * 难度系数: 3星
 * leetcode 55
 * @author stormma
 * @date 2017/12/03
 */
public class Question55 {

    static class Solution {
        public boolean canJump(int[] nums) {
            //
            if (nums == null || nums.length < 2) {
                return true;
            }

            int ans = 0, maxIndex = 0, currMaxIndex = 0;
            for (int i = 0; i < nums.length; i++) {
                maxIndex = Math.max(maxIndex, i + nums[i]);
                if (i == currMaxIndex) {
                    currMaxIndex = maxIndex;
                }
                if (i > currMaxIndex) {
                    return false;
                }
            }
            return true;
        }
    }
}
