package me.stormma.leetcode.array;

/**
 * 难度系数： 2星
 * leetcode 724
 * @author stormma
 * @date 2017/11/12
 */
public class Question724 {

    static class Solution {
        public int pivotIndex(int[] nums) {
            int low = 0, high = nums.length - 1;
            if (nums.length < 3) {
                return -1;
            }

            int[] preNum = new int[nums.length];
            int sum = nums[0];
            preNum[0] = sum;
            for (int i = 1; i < nums.length; i++) {
                sum += nums[i];
                preNum[i] = sum;
            }
            for (int i = 0; i < nums.length; i++) {
                boolean valid = (i > 0 && preNum[i - 1] == preNum[nums.length - 1] - preNum[i]) || (i == 0 && preNum[nums.length - 1] - preNum[i] == 0) || (i == nums.length && preNum[i - 1] == 0);
                if (valid) {
                    return i;
                }
            }
            return -1;
        }
    }

    static class Solution2 {
        public int pivotIndex(int[] nums) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            int pre = 0;
            for (int i = 0; i < nums.length; pre += nums[i++]) {
                if (pre * 2 == sum - nums[i]) {
                    return i;
                }
            }
            return -1;
        }
    }
}
