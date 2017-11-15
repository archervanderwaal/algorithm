package me.stormma.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 难度系数: 3星，难度在于对dfs和递归的深入理解
 * leetcode 46
 * @author stormma
 * @date 2017/11/15
 */
public class Question46 {

    static class Solution {
        public List<List<Integer>> permute(int[] numbers) {
            List<List<Integer>> ans = new ArrayList<>();
            dfs(ans, new ArrayList<>(), numbers, new boolean[numbers.length], 0);
            return ans;
        }

        private void dfs(List<List<Integer>> ans, List<Integer> tmp, int[] numbers, boolean[] visited, int n) {
            if (n == numbers.length) {
                ans.add(new ArrayList<>(tmp));
                return;
            }

            for (int i = 0; i < numbers.length; i++) {
                if (!visited[i]) {
                    tmp.add(numbers[i]);
                    visited[i] = true;
                    dfs(ans, tmp, numbers, visited, n + 1);
                    visited[i] = false;
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }
}
