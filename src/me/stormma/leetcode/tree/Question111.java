package me.stormma.leetcode.tree;

import me.stormma.leetcode.dfs.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Question111 {

    /**
     * dfs
     * 时间复杂度 O(n) -> n节点个数
     */
    private static class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            if (root.left == null) {
                return 1 + minDepth(root.right);
            }
            if (root.right == null) {
                return 1 + minDepth(root.left);
            }
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }

    /**
     * bfs法
     * 时间复杂度O(n) n->节点个数
     */
    private static class Solution2 {
        public int minDepth(TreeNode root) {
            return bfs(root);
        }

        private int bfs(TreeNode root) {
            if (root == null) return 0;
            Queue<TreeNode> current = new LinkedList<>();
            Queue<TreeNode> next = new LinkedList<>();
            Queue<TreeNode> tmp;
            current.add(root);
            int ans = 0;
            while (!current.isEmpty()) {
                while (!current.isEmpty()) {
                    TreeNode node = current.poll();
                    if (node.left == null && node.right == null) {
                        return ans + 1;
                    }
                    if (node.left != null) next.add(node.left);
                    if (node.right != null) next.add(node.right);
                }
                tmp = current;
                current = next;
                next = tmp;
                ans++;
            }
            return ans;
        }
    }
}
