package me.stormma.leetcode.tree;

import me.stormma.leetcode.dfs.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 难度系数: 三星
 * leetcode 105. Construct Binary Tree from Preorder and Inorder Traversal
 * @author stormma
 * @date 2018/03/23
 */
public class Question105 {

    /**
     * running time: 24ms
     */
    static class Solution1 {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        /**
         * preorder = [3,9,20,15,7]
         * inorder = [9,3,15,20,7]
         * 我们可以知道root节点是3, 然后再inorder中找3, 那么inorder中3左边的必定是root的左子树, 右边的必定是它的右子树, 递归解决之
         *
         * @param pre
         * @param preStart
         * @param preEnd
         * @param in
         * @param inStart
         * @param inEnd
         * @return
         */
        private TreeNode buildTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
            if (preStart > preEnd || inStart > inEnd) return null;
            TreeNode node = new TreeNode(pre[preStart]);
            for (int i = inStart; i <= inEnd; i++) {
                if (in[i] == pre[preStart]) {
                    //
                    node.left = buildTree(pre, preStart + 1, preStart + i - inStart, in, inStart, i - 1);
                    node.right = buildTree(pre, preStart + i - inStart + 1, preEnd, in, i + 1, inEnd);
                }
            }
            return node;
        }
    }

    /**
     * 优化
     * running time 7ms
     */
    static class Solution2 {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (inorder == null || inorder.length == 0 || preorder == null || preorder.length == 0) return null;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return buildTree(map, preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        /**
         * preorder = [3,9,20,15,7]
         * inorder = [9,3,15,20,7]
         * 我们可以知道root节点是3, 然后再inorder中找3, 那么inorder中3左边的必定是root的左子树, 右边的必定是它的右子树, 递归解决之
         *
         * @param pre
         * @param preStart
         * @param preEnd
         * @param in
         * @param inStart
         * @param inEnd
         * @return
         */
        private TreeNode buildTree(Map<Integer, Integer> map, int[] pre, int preStart, int preEnd
                , int[] in, int inStart, int inEnd) {
            if (preStart > preEnd || inStart > inEnd) return null;
            TreeNode node = new TreeNode(pre[preStart]);
            int i = map.get(pre[preStart]);
            node.left = buildTree(map, pre, preStart + 1, preStart + i - inStart
                            , in, inStart, i - 1);
            node.right = buildTree(map, pre, preStart + i - inStart + 1, preEnd
                            , in, i + 1, inEnd);
            return node;
        }
    }
}
