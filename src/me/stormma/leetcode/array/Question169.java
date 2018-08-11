package me.stormma.leetcode.array;

import java.util.Arrays;

/**
 * 难度系数: 1星
 * leetcode 169
 *
 * @author stormma
 * @date 2017/11/03
 */
public class Question169 {

    /**
     * 时间复杂度 o(nlogn)
     * my solution
     */
    static class Solution1 {
        public int majorityElement(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }

            Arrays.sort(nums);
            for (int i = 0; i <= nums.length / 2; i++) {
                if (nums[i] == nums[i + nums.length / 2]) {
                    return nums[i];
                }
            }
            return -1;
        }
    }

    /**
     * 时间复杂度O(n)
     */
    static class Solution2 {
        public int majorityElement(int[] num) {

            int major = num[0], count = 1;
            for (int i = 1; i < num.length; i++) {
                if (count == 0) {
                    count++;
                    major = num[i];
                } else if (major == num[i]) {
                    count++;
                } else {
                    count--;
                }
            }
            return major;
        }
    }
}
