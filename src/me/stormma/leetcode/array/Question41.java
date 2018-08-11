package me.stormma.leetcode.array;

/**
 * 难度系数: 4星
 * leetcode 41
 * @author stormma
 * @date 2017/11/30
 * 思路分析 <a href="http://blog.csdn.net/StromMaybin/article/details/78673162">csdn blog</a>
 */
public class Question41 {

    static class Solution {
        public int firstMissingPositive(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                    swap(nums, nums[i] - 1, i);
                }
            }

            // find ans
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i + 1) {
                    return i +1;
                }
            }
            return nums.length + 1;
        }
        // [3, 4, -1, 1]
        // [-1, 4, 3, 1]
        // [-1, 1, 3, 4]
        // [1, -1, 3, 4]
        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
