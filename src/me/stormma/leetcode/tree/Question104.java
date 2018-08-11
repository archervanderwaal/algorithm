package me.stormma.leetcode.tree;

import me.stormma.leetcode.dfs.TreeNode;

/**
 * 难度系数: 3xing
 * leetcode 104
 * @author stormma
 * @date 2017/12/04
 */
public class Question104 {

    static class Solution {
        public int maxDepth(TreeNode root) {
            return dfs(root);
        }

        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return 1 + Math.max(dfs(root.left), dfs(root.right));
        }
    }
}
