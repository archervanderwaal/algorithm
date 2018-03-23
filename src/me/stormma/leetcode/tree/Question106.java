package me.stormma.leetcode.tree;

import me.stormma.leetcode.dfs.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 难度系数: 三星
 * leetcode 106. Construct Binary Tree from Inorder and Postorder Traversal
 * @author stormma
 * @date 2018/03/23
 */
public class Question106 {
    static class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) return null;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return buildTree(map, inorder, 0, inorder.length - 1
                                , postorder, 0, postorder.length - 1);
        }

        private TreeNode buildTree(Map<Integer, Integer> map, int[] in, int inStart, int inEnd
                , int[] post, int postStart, int postEnd) {
            if (inStart > inEnd || postStart > postEnd) return null;
            TreeNode node = new TreeNode(post[postEnd]);
            int i = map.get(post[postEnd]);
            node.left = buildTree(map, in, inStart, i - 1, post, postStart, postStart + i - inStart - 1);
            node.right = buildTree(map, in, i + 1, inEnd, post, postStart + i - inStart, postEnd - 1);
            return node;
        }
    }
}
