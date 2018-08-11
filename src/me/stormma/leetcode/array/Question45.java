package me.stormma.leetcode.array;

/**
 * 难度系数: 3星
 * 贪心问题
 * leetcode 45
 * @author stormma
 * @date 2017/12/03
 */
public class Question45 {

    static class Solution {
        public int jump(int[] nums) {
            if (nums == null || nums.length < 2) {
                return 0;
            }
            int ans = 0, maxIndex = 0, currentMaxIndex = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                maxIndex = Math.max(maxIndex, i + nums[i]);
                if (i == currentMaxIndex) {
                    ans++;
                    currentMaxIndex = maxIndex;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0};
        System.out.println(new Solution().jump(nums));
    }
}
