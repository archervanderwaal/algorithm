package me.stormma.others;

import jdk.nashorn.api.tree.Tree;
import me.stormma.leetcode.dfs.TreeNode;

import java.util.Stack;

/**
 * @brief 二叉树的各种非递归遍历方式
 * @author stormma stormmaybin@gmail.com
 */
public class NonRecursionTravelTreeNode {

    public static void preTravel(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public static void inorderTravel(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.println(root.val);
            root = root.right;
        }
    }

    public static void postTravel(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> out = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            out.push(node);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        while (!out.isEmpty()) {
            System.out.println(out.pop().val);
        }
    }
}
