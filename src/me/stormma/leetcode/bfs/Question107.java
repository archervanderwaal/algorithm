package me.stormma.leetcode.bfs;

import jdk.nashorn.api.tree.Tree;
import me.stormma.leetcode.dfs.TreeNode;

import java.util.*;

/**
 * BFS问题
 * leetcode 107
 * @author stormma
 * @date 2018/03/10
 */
public class Question107 {

    private static class Solution1 {
        static final int L = 100;
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            Queue<TreeNode> current = new LinkedList<>();
            Queue<TreeNode> next = new LinkedList<>();
            Queue<TreeNode> tmp = new LinkedList<>();
            current.offer(root);
            while (!current.isEmpty()) {
                List<Integer> list = new ArrayList<>(L);
                while (!current.isEmpty()) {
                    TreeNode node = current.poll();
                    if (node.left != null) {
                        next.offer(node.left);
                    }
                    if (node.right != null) {
                        next.offer(node.right);
                    }
                    list.add(node.val);
                }
                res.add(list);
                tmp = current;
                current = next;
                next = tmp;
            }
            Collections.reverse(res);
            return res;
        }
    }

    private static class Solution2 {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> out = new ArrayList<>();
            if (root == null) return out;
            traverse(out, root, 0);
            Collections.reverse(out);
            return out;
        }

        private void traverse(List<List<Integer>> out, TreeNode root, int depth) {
            if (root == null) return;
            if (depth == out.size()) out.add(new ArrayList<>());
            traverse(out, root.left, depth + 1);
            traverse(out, root.right, depth + 1);
            out.get(depth).add(root.val);
        }
    }
}
