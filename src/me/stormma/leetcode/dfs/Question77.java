package me.stormma.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 简单的DFS即可
 * 难度系数: 2星
 * leetcode 77
 * @author stormma
 * @date 2017/12/06
 */
public class Question77 {

    static class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> ans = new ArrayList<>();
            if (n < 1 || k < 1) return ans;
            dfs(1, n, k, ans, new ArrayList<>());
            return ans;
        }

        private void dfs(int start, int n, int k, List<List<Integer>> ans, List<Integer> tmp) {
            if (k == 0) {
                ans.add(new ArrayList<>(tmp));
                return;
            }
            for (int i = start; i <= n; i++) {
                tmp.add(i);
                dfs(i + 1, n, k - 1, ans, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
