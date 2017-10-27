package me.stormma.leetcode.dfs;


/**
 * 难度系数: 3星
 * leetcode 110.
 *
 * @author stormma
 * @date 2017/10/26
 */
public class Question110 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution1 {
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }

        private int height(TreeNode node) {
            if (node == null) {
                return 0;
            }
            return Math.max(height(node.left), height(node.right)) + 1;
        }
    }

    static class Solution2 {
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            int left_height = dfs(root.left);
            int right_height = dfs(root.right);
            if (left_height < 0 || right_height < 0 || Math.abs(left_height - right_height) > 1) {
                return false;
            }
            return true;
        }

        private int dfs(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int left_height = dfs(node.left);
            int right_height = dfs(node.right);
            if (left_height < 0 || right_height < 0 || Math.abs(left_height - right_height) > 1) {
                return -1;
            }
            return Math.max(left_height, right_height) + 1;
        }
    }
}
