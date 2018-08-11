package me.stormma.leetcode.binary_search;

/**
 * leetcode 669. 剪枝二叉查找树 <a href="https://leetcode.com/problems/trim-a-binary-search-tree">题目链接</a>
 *
 * @author stormma
 * @date 2017/10/19
 */
public class Question669 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    static class Solution {
        public TreeNode trimBST(TreeNode root, int L, int R) {
            if (root == null) {
                return null;
            }
            // trim left subtree and right subtree.
            if (L <= root.val && root.val <= R) {
                root.left = trimBST(root.left, L, R);
                root.right = trimBST(root.right, L, R);
            } else if (root.val < L) {
                root = trimBST(root.right, L, R);
            } else {
                root = trimBST(root.left, L, R);
            }
            return root;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
