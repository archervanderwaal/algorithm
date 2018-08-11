package me.stormma.leetcode.tree;

import me.stormma.leetcode.dfs.TreeNode;

/**
 * 难度系数: 2星
 * leetcode 108
 * @author stormma
 * @date 2017/12/04
 */
public class Question108 {
    static class Solution {
        public TreeNode sortedArrayToBST(int[] num) {
            if (num.length == 0) {
                return null;
            }
            TreeNode head = helper(num, 0, num.length - 1);
            return head;
        }

        private TreeNode helper(int[] num, int low, int high) {
            if (low > high) { // Done
                return null;
            }
            int mid = (low + high) / 2;
            TreeNode node = new TreeNode(num[mid]);
            node.left = helper(num, low, mid - 1);
            node.right = helper(num, mid + 1, high);
            return node;
        }
    }
}

/**
 *
 * "...Q",
 * ".Q..",
 * "Q...", 2, 0  1, 1
 * "..Q."
 *
 *
 *
 *
 *
 ".Q..",
 "...Q",
 "..Q.",
 "Q..."
 */