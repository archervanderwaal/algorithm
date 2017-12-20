package me.stormma.leetcode.tree;

import me.stormma.leetcode.dfs.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 难度系数: 2星, 水题
 * leetcode 94
 * @author stormma
 * @date 2017/12/20
 */
public class Question94 {

    static class Solution {
        static List<Integer> ans;
        public List<Integer> inorderTraversal(TreeNode root) {
            ans = new ArrayList<>();
            inOrderTraversal(root);
            return ans;
        }

        private void inOrderTraversal(TreeNode node) {
            if (node == null) return;
            inOrderTraversal(node.left);
            ans.add(node.val);
            inOrderTraversal(node.right);
        }
    }
}
