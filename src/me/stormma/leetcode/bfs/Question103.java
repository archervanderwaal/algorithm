package me.stormma.leetcode.bfs;

import me.stormma.leetcode.dfs.TreeNode;

import java.util.*;

public class Question103 {
    private static class Solution1 {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>(100);
            if (root == null) return ans;
            boolean left2Right = true;
            Queue<TreeNode> current = new LinkedList<>();
            Queue<TreeNode> next = new LinkedList<>();
            Queue<TreeNode> tmp;
            current.add(root);
            while (!current.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                List<TreeNode> nodes = new ArrayList<>();
                left2Right = !left2Right;
                while (!current.isEmpty()) {
                    TreeNode node = current.poll();
                    if (!left2Right) { // right->left
                        if (node.left != null) nodes.add(node.left);
                        if (node.right != null) nodes.add(node.right);
                    } else { // left->right
                        if (node.right != null) nodes.add(node.right);
                        if (node.left != null) nodes.add(node.left);
                    }
                    list.add(node.val);
                }
                Collections.reverse(nodes);
                next.addAll(nodes);
                ans.add(list);
                tmp = current;
                current = next;
                next = tmp;
            }
            return ans;
        }
    }

    private static class Solution2 {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            bfs(res, root, 0);
            return res;
        }

        @SuppressWarnings("unchecked")
        private void bfs(List<List<Integer>> res, TreeNode root, int level) {
            if(root == null) return;
            if(level == res.size()) {
                res.add(new ArrayList());
            }
            if(level % 2 == 1) {
                res.get(level).add(0, root.val);
            } else {
                res.get(level).add(root.val);
            }
            bfs(res, root.left, level + 1);
            bfs(res, root.right, level + 1);
        }
    }
}
