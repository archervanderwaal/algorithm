package me.stormma.leetcode.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 难度系数: 3星
 * leetcode 80
 * @author stormma
 * @date 2017/12/06
 */
public class Question80 {

    static class Solution1 {
        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length < 3) {
                return nums == null ? 0 : nums.length;
            }
            Queue<Integer> queue = new LinkedList<>();
            int cnt = 1, pre = nums[0];
            queue.add(pre);
            for (int i = 1; i < nums.length; i++) {
                if (pre == nums[i]) cnt++;
                if (cnt <= 2 || pre != nums[i]) queue.add(nums[i]);
                if (pre != nums[i]) cnt = 1;
                pre = nums[i];
            }
            int ans = queue.size();
            for (int i = 0; i < ans; i++) nums[i] = queue.poll();
            return ans;
        }
    }


    static class Solution2 {
        public int removeDuplicates(int[] nums) {
            if(nums == null || nums.length <= 2) {
                return nums == null ? 0 : nums.length;
            }

            int slow = 2;
            for(int fast = 2; fast < nums.length; fast++) {
                if(nums[fast] != nums[slow - 2]) {
                    nums[slow++] = nums[fast];
                }
            }
            return slow;
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,3,3,3,3,3};
        int result = new Solution1().removeDuplicates(nums);
        for (int i = 0; i < result; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
