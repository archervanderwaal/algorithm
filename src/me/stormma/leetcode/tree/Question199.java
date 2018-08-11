package me.stormma.leetcode.tree;

import jdk.nashorn.api.tree.Tree;
import me.stormma.leetcode.dfs.TreeNode;

import java.util.*;

/**
 * leetcode 199
 * @author stormma
 * @date 2018/03/13
 */
public class Question199 {

    /**
     * dfs
     */
    private static class Solution1 {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if (root == null) return ans;
            dfs(ans, root, 0);
            return ans;
        }

        private void dfs(List<Integer> ans, TreeNode node, int depth) {
            if (depth == ans.size()) ans.add(node.val);
            if (node.right != null) {
                dfs(ans, node.right, depth + 1);
            }
            if (node.left != null) {
                dfs(ans, node.left, depth + 1);
            }
        }
    }

    /**
     * bfs
     */
    private static class Solution2 {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if (root == null) return ans;
            Queue<TreeNode> current = new LinkedList<>();
            Queue<TreeNode> next = new LinkedList<>();
            Queue<TreeNode> tmp;
            current.add(root);
            while (!current.isEmpty()) {
                TreeNode last = null;
                while (!current.isEmpty()) {
                    TreeNode node = current.poll();
                    last = node;
                    if (node.left != null) next.add(node.left);
                    if (node.right != null) next.add(node.right);
                }
                tmp = current;
                current = next;
                next = tmp;
                ans.add(last.val);
            }
            return ans;
        }
    }
}
