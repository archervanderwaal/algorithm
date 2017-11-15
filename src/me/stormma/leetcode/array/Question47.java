package me.stormma.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 难度系数: 3星
 * leetcode 47
 * @author stormma
 * @date 2017/11/15
 */
public class Question47 {

    static class Solution {
        public List<List<Integer>> permuteUnique(int[] numbers) {
            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(numbers);
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
                    // 跳过重复
                    if (i > 0 && numbers[i] == numbers[i - 1] && !visited[i - 1]) {
                        continue;
                    }
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
