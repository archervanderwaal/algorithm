package me.stormma.lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @author stormma stormmaybin@gmail.com
 */
public class Question16 {

    public class Solution {
        /*
         * @param :  A list of integers
         * @return: A list of unique permutations
         */
        public List<List<Integer>> permuteUnique(int[] nums) {
            // write your code here
            List<List<Integer>> ans = new ArrayList<>();
            if (nums == null) return ans;
            Arrays.sort(nums);
            dfs(ans, new ArrayList<>(), new boolean[nums.length], nums);
            return ans;
        }

        private void dfs(List<List<Integer>> ans, List<Integer> current, boolean[] visited, int[] nums) {
            if (current.size() == nums.length) {
                ans.add(new ArrayList<>(current));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]) {
                    // 去除重复元素
                    if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                        continue;
                    }
                    current.add(nums[i]);
                    visited[i] = true;
                    dfs(ans, current, visited, nums);
                    current.remove(current.size() - 1);
                    visited[i] = false;
                }
            }
        }
    }
}
