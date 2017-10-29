package me.stormma.leetcode.array;

/**
 * 难度系数: 3星
 * leetcode 713
 * @author stormma
 * @date 2017/10/28
 */
public class Question713 {

    /**
     * 暴力解法，TLE，时间复杂度O(n ^ 2)
     */
    static class Solution1 {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                int temp = 1;
                int pos = i;
                while (pos < nums.length && temp * nums[pos] < k) {
                    temp *= nums[pos];
                    pos++;
                }
                count += pos - i;
            }
            return count;
        }
    }

    // 10 5 2 6
    // +1 =>10
    // +2 => 5、 10 5
    // left++ ==> left = 1
    // +2 => 2、5 2
    // +3 => 6、2 6、5 2 6
    // return 8
    // 标解

    static class Solution2 {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int cnt = 0;
            int left = 0;
            int pre = 1;
            for (int i = 0; i < nums.length; i++) {
                pre *= nums[i];
                while (pre >= k && left <= i) {
                    pre /= nums[left];
                    left++;
                }
                cnt += i - left + 1;
            }
            return cnt;
        }
    }
}
