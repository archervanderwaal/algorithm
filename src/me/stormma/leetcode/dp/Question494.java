package me.stormma.leetcode.dp;

/**
 * 难度系数: 3星
 * leetcode 494
 * @author stormma
 * @date 2018/01/25
 */
public class Question494 {
    static class Solution1 {
        public int findTargetSumWays(int[] nums, int S) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum < S) return 0;
            int offset = sum; // range: -sum ~ sum.. -sum + offset = 0  ==> 0 ~ sum + offset <=> 0 ~ 2*sum
            int[][] ways = new int[nums.length + 1][2 * sum + 1];
            ways[0][offset] = 1;
            for (int i = 0; i < nums.length; i++) {
                for (int j = nums[i]; j < 2 * sum + 1 - nums[i]; j++) {
                    ways[i + 1][j + nums[i]] += ways[i][j];
                    ways[i + 1][j - nums[i]] += ways[i][j];
                }
            }
            return ways[nums.length][S + offset];
        }
    }

    static class Solution2 {
        public int findTargetSumWays(int[] nums, int S) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum < S) return 0;
            return dfs(nums, 0, S);
        }

        private int dfs(int[] nums, int ind, int S) {
            if (ind == nums.length) {
                if (S == 0) return 1;
                else return 0;
            }
            int ans = 0;
            ans += dfs(nums, ind + 1, S - nums[ind]);
            ans += dfs(nums, ind + 1, S + nums[ind]);
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int S = 3;
        System.out.println(new Solution2().findTargetSumWays(nums, S));
    }
}
