package me.stormma.leetcode.dfs;

/**
 * 水题  dfs
 * 难度系数: 2星
 * leetcode 112
 * @author stormma
 * @date 2017/12/05
 */
public class Question112 {

    static class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            return dfs(root, sum);
        }

        private boolean dfs(TreeNode node, int target) {
            if (node == null) return false;
            if (node.left == null && node.right == null && target == node.val) return true;
            return dfs(node.left, target - node.val) || dfs(node.right, target - node.val);
        }
    }
}
