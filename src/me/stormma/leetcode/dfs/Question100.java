package me.stormma.leetcode.dfs;

/**
 * 难度系数: 1星，就是简单递归比较的问题
 * leetcode 100.
 *
 * @author stormma
 * @date 2017/10/21
 */
public class Question100 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p == null || q == null) {
                return false;
            }
            if (p.val == q.val) {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
            return false;
        }
    }
}
