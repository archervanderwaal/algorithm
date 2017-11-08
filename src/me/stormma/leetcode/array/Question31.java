package me.stormma.leetcode.array;

/**
 * 难度系数: 3星
 * leetcode 31
 * @author stormma
 * @date 2017/11/07
 */
public class Question31 {

    static class Solution {
        public void nextPermutation(int[] nums) {
            if (nums == null || nums.length < 2) {
                return;
            }

            int index = nums.length - 1;
            int ke = index;

            while (index > 0 && nums[index - 1] >= nums[index]) {
                index--;
            }
            for (int j = index; j < ke; j++, ke--) {
                swap(nums, j, ke);
            }

            // 2 5 4 3 1
            // 2 1 4 3 5
            // 2 1 3 4 5
            //

            // 1 5 4 3 2
            // 1 2 4 3 5
            // 1 2 3 4 5
            // 2 1 3 4 5
            if (index > 0) {
                ke = index--;
                while (nums[ke] <= nums[index]) {
                    ke++;
                }
                swap(nums, ke, index);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 4, 3, 1};
        new Solution().nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
