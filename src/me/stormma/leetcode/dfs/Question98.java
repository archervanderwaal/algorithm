package me.stormma.leetcode.dfs;

/**
 * 难度系数: 3星
 * leetcode 98
 * @author stormma
 * @date 2017/11/28
 */
public class Question98 {


    static class Solution1 {
        public boolean isValidBST(Question100.TreeNode root) {
            return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean dfs(Question100.TreeNode node, Long minVal, Long maxVal) {
            if (node == null) {
                return true;
            }

            if (node.val <= minVal || node.val >= maxVal) {
                return false;
            }

            return dfs(node.left, minVal, (long) node.val) && dfs(node.right, (long) node.val, maxVal);
        }
    }

    static class Solution2 {
        public boolean isValidBST(Question100.TreeNode root) {
            return dfs(root, null, null);
        }

        private boolean dfs(Question100.TreeNode node, Integer min, Integer max) {
            if (node == null) {
                return true;
            }

            if ((min != null && node.val <= min) || (max != null &&node.val >= max)) {
                return false;
            }
            return dfs(node.left, min, node.val) && dfs(node.right, node.val, max);
        }
    }
}
