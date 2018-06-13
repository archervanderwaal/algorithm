package me.stormma.lintcode;


import java.util.ArrayList;
import java.util.List;

/**
 * @author stormma stormmaybin@gmail.com
 */
public class Question15 {

    public class Solution {
        /*
         * @param nums: A list of integers.
         * @return: A list of permutations.
         */
        public List<List<Integer>> permute(int[] nums) {
            // write your code here
            List<List<Integer>> ans = new ArrayList<>();
            if (nums == null) return ans;
            boolean[] visited = new boolean[nums.length];
            dfs(ans, new ArrayList<>(), nums, visited);
            return ans;
        }

        public void dfs(List<List<Integer>> ans, List<Integer> current, int[] nums, boolean[] visited) {
            if (nums.length == current.size()) {
                ans.add(new ArrayList<>(current));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]) {
                    current.add(nums[i]);
                    visited[i] = true;
                    dfs(ans, current, nums, visited);
                    visited[i] = false;
                    current.remove(current.size() - 1);
                }
            }
        }
    }
}
