package me.stormma.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 难度系数: 3星
 * leetcode 39
 * @author stormma
 * @date 2017/11/15
 */
public class Question39 {

    static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> ans = new ArrayList<>();
            dfs(0, target, new ArrayList<>(), ans, candidates);
            return ans;
        }

        private void dfs(int index, int target, List<Integer> tmp, List<List<Integer>> ans, int[] nums) {
            if (target == 0) {
                ans.add(new ArrayList<>(tmp));
            } else if (target > 0) {
                for (int i = index; i < nums.length && target >= nums[i]; i++) {
                    tmp.add(nums[i]);
                    dfs(i, target - nums[i], tmp, ans, nums);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {8, 7, 4, 3};
        System.out.println(new Solution().combinationSum(nums, 11));
    }
}
