package me.stormma.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 难度系数: 3星
 * leetcode 40
 * @author stormma
 * @date 2017/11/29
 */
public class Question40 {

    static class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(candidates);
            dfs(candidates, target, 0, ans, new ArrayList<>());
            return ans;
        }

        private void dfs(int[] candidates, int target, int start, List<List<Integer>> ans, List<Integer> current) {
            if (target == 0) {
                ans.add(new ArrayList<>(current));
                return;
            }

            for (int i = start; i < candidates.length; i++) {
                int num = candidates[i];
                if (num > target) return;
                if (i > start && candidates[i] == candidates[i - 1]) continue;
                current.add(num);
                dfs(candidates, target - num, i + 1, ans, current);
                current.remove(current.size() - 1);
            }
        }
    }
}
