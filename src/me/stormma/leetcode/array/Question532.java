package me.stormma.leetcode.array;

import java.util.Arrays;

/**
 * @author stormma stormmaybin@gmail.com
 */
public class Question532 {

    static class Solution {
        public int findPairs(int[] nums, int k) {
            Arrays.sort(nums);
            int ans = 0;
            for (int low = 0, high = 0; low < nums.length; low++) {
                for (high = Math.max(low + 1, high); high < nums.length && nums[high] - nums[low] < k; high++);
                if (high < nums.length && nums[high] - nums[low] == k) ans++;
                while (low + 1 < nums.length && nums[low] == nums[low + 1]) low++;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 5, 4};
        System.out.println(new Solution().findPairs(nums, 0));
    }
}
