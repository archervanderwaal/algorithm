package me.stormma.nowcoder.daily;

import java.util.Stack;

/**
 * @brief 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * @author stormma stormmaybin@gmail.com
 */
public class TreeConvertList {

    /**
     * 递归版
     */
    static class Solution1 {
        // 递归版
        public TreeNode Convert(TreeNode pRootOfTree) {
            if (pRootOfTree == null) return null;
            TreeNode headList = null;
            if (pRootOfTree.left != null) {
                TreeNode left = (headList = Convert(pRootOfTree.left));
                while (left.right != null) {
                    left = left.right;
                }
                left.right = pRootOfTree;
                pRootOfTree.left = left;
            }
            if (pRootOfTree.right != null) {
                TreeNode right = Convert(pRootOfTree.right);
                right.left = pRootOfTree;
                pRootOfTree.right = right;
            }
            return headList != null ? headList : pRootOfTree;
        }
    }

    /**
     * 非递归版
     */
    static class Solution2 {
        public TreeNode Convert(TreeNode pRootOfTree) {
            if (pRootOfTree == null) return null;
            Stack<TreeNode> stack = new Stack<>();
            TreeNode res = null;
            boolean init = true;
            TreeNode p = pRootOfTree, pre = null;
            while (p != null || !stack.isEmpty()) {
                while (p != null) {
                    stack.push(p);
                    p = p.left;
                }
                p = stack.pop();
                if (init) {
                    res = p;
                    pre = res;
                    init = false;
                } else {
                    pre.right = p;
                    p.left = pre;
                    pre = p;
                }
                p = p.right;
            }
            return res;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static void main(String... args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(3);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(4);
        node.right = new TreeNode(7);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(8);
        System.out.println(new Solution1().Convert(node));
    }
}
