package me.stormma.leetcode.tree;

import me.stormma.leetcode.dfs.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 难度系数: 2星
 * leetcode 530. Minimum Absolute Difference in BST
 * @author stormma
 * @date 2018/03/26
 */
public class Question530 {
    /**
     * 利用中序遍历计算
     * time: O(n)
     * space: O(n)
     */
    static class Solution1 {
        private List<Integer> list;
        public int getMinimumDifference(TreeNode root) {
            list = new ArrayList<>();
            int ans = Integer.MAX_VALUE;
            if (root == null) return ans;
            inOrder(root);
            for (int i = 1; i < list.size(); i++) {
                ans = Math.min(ans, list.get(i) - list.get(i - 1));
            }
            return ans;
        }

        private void inOrder(TreeNode root) {
            if (root == null) return;
            inOrder(root.left);
            list.add(root.val);
            inOrder(root.right);
        }
    }

    /**
     * 利用中序遍历计算
     * time: O(n)
     * 记录一下pre就行，不用全部存储
     */
    static class Solution2 {
        private Integer ans = Integer.MAX_VALUE;
        private TreeNode pre = null;
        public int getMinimumDifference(TreeNode root) {
            if (root == null) return ans;
            inOrder(root);
            return ans;
        }
        private void inOrder(TreeNode root) {
            if (root == null) return;
            inOrder(root.left);
            if (pre != null) {
                ans = Math.min(ans, root.val - pre.val);
            }
            pre = root;
            inOrder(root.right);
        }
    }

    /**
     * 中序遍历的另外一种实现
     */
    static class Solution3 {
        public int getMinimumDifference(TreeNode root) {
            int ans = Integer.MAX_VALUE;
            TreeNode current = root, pre = null;
            Stack<TreeNode> nodes = new Stack<>();
            while (!nodes.isEmpty() || current != null) {
                if (current != null) {
                    nodes.push(current);
                    current = current.left;
                } else { // 代表左边走到头了
                    current = nodes.pop();
                    if (pre != null) {
                        ans = Math.min(ans, current.val - pre.val);
                    }
                    pre = current;
                    current = current.right;
                }
            }
            return ans;
        }
    }
}
