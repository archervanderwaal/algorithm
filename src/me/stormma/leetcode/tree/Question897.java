package me.stormma.leetcode.tree;

import me.stormma.leetcode.dfs.TreeNode;

/**
 * @author archer.vanderwaal@gmail.com
 * 897. Increasing Order Search Tree
 */
public class Question897 {

    // res(root) = inorder(root.left) + root + inorder(root.right)
    static class Solution {
        public TreeNode increasingBST(TreeNode root) {
            return helper(root, null);
        }

        public TreeNode helper(TreeNode root, TreeNode tail) {
            if (root == null) return tail;
            TreeNode res = helper(root.left, root);
            root.left = null;
            root.right = helper(root.right, tail);
            return res;
        }
    }
}
