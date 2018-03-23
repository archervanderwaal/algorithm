package me.stormma.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 难度系数: 三星
 * leetcode 78. Subsets
 * @author stormma
 * @date 2018/03/23
 */
public class Question78 {
    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            if (nums == null || nums.length == 0) return ans;
            dfs(new ArrayList<>(), ans, 0, nums);
            return ans;
        }

        public void dfs(List<Integer> tmp, List<List<Integer>> ans, int index, int[] nums) {
            ans.add(new ArrayList<>(tmp));
            for (int i = index; i < nums.length; i++) {
                tmp.add(nums[i]);
                dfs(tmp, ans, i + 1, nums);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        new Solution().subsets(nums);
    }
}
