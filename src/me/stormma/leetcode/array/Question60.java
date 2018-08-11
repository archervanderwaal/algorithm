package me.stormma.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 难度系数
 * leetcode 60
 * @author stormma
 * @date 2017/11/15
 */
public class Question60 {

    static class Solution {
        static final int[] fact = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        public String getPermutation(int n, int k) {
            List<Integer> nums = new ArrayList<>();
            StringBuilder ans = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                nums.add(i);
            }
            dfs(nums, n, --k, ans);
            return ans.toString();
        }

        private void dfs(List<Integer> nums, int n, int k, StringBuilder ans) {
            if (nums.size() == 0) {
                return;
            }
            int index = k / fact[n - 1];
            ans.append(nums.get(index));
            // remove it
            nums.remove(index);
            dfs(nums, n - 1, k % fact[n - 1], ans);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getPermutation(3, 4));
    }
}
