package me.stormma.leetcode.array;

import java.util.Arrays;

/**
 * 难度系数: 2星
 * 思路: http://blog.csdn.net/StromMaybin/article/details/78432815
 * leetcode 16
 * @author stormma
 * @date 2017/11/03
 */
public class Question16 {

    static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            if (nums.length == 1) {
                return nums[0];
            }
            Arrays.sort(nums);

            int result = Integer.MAX_VALUE >> 1;

            for (int i = 0; i < nums.length - 2; i++) {
                int low = i + 1, high = nums.length - 1;
                int goal = target - nums[i];
                while (low < high) {
                    if (goal == nums[low] + nums[high]) {
                        return target;
                    }
                    result = Math.abs(goal - nums[low] - nums[high]) > Math.abs(result - target) ? result: nums[i] + nums[low] + nums[high];
                    if (goal > nums[low] + nums[high]) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
            return result;
        }
    }
}
