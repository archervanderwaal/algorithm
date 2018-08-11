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

    public class Solution2 {
        /*
         * @param nums: A list of integers.
         * @return: A list of permutations.
         */
        public List<List<Integer>> permute(int[] nums) {
            // write your code here
            List<List<Integer>> ans = new ArrayList<>();
            if (nums == null) return ans;
            dfs(0, ans, new ArrayList<>(), nums);
            return ans;
        }

        private void dfs(int start, List<List<Integer>> ans, List<Integer> current, int[] nums) {
            if (start == nums.length) {
                ans.add(new ArrayList<>(current));
                return;
            }
            for (int i = start; i < nums.length; i++) {
                swap(nums, i, start);
                current.add(nums[start]);
                dfs(start + 1, ans, current, nums);
                current.remove(current.size() - 1);
                swap(nums, i, start);
            }
        }

        private void swap(int[] nums, int a, int b) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }
}
