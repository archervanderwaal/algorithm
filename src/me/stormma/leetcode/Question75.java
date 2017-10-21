package me.stormma.leetcode;

/**
 * <p>荷兰国旗问题，<a href="https://leetcode.com/problems/sort-colors">题目链接</a></p>
 *
 * @author stormma
 * @date 2017/10/19
 */
public class Question75 {

    static class Solution {
        public void sortColors(int[] nums) {
            int pos0 = 0, pos2 = nums.length - 1, currentPos =0;
            while (currentPos <= pos2) {
                if (nums[currentPos] == 0) {
                    swap(nums, currentPos, pos0);
                    pos0++;
                    currentPos++;
                    continue;
                }
                if (nums[currentPos] == 2) {
                    swap(nums, currentPos, pos2);
                    pos2--;
                    continue;
                }
                currentPos++;
            }
            show(nums);
        }

        private static void show(int[] array) {
            for (int anArray : array) {
                System.out.print(anArray + " ");
            }
            System.out.println();
        }

        private static void swap(int[] nums, int a, int b) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }
}
