package me.stormma.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * DFS水题
 * 难度系数: 3星
 * leetcode 113
 * @author stormma
 * @date 2017/12/05
 */
public class Question113 {

    static class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> ans = new ArrayList<>();
            dfs(root, sum, ans, new ArrayList<>());
            return ans;
        }

        private void dfs(TreeNode node, int target, List<List<Integer>> ans, List<Integer> tmp) {
            if (node == null) return;
            tmp.add(node.val);
            target -= node.val;
            if (node.left == null && node.right == null && target == 0) {
                ans.add(new ArrayList<>(tmp));
                tmp.remove(tmp.size() - 1);
                return;
            }
            dfs(node.left, target, ans, tmp);
            dfs(node.right, target, ans, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
