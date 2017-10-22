package me.stormma.leetcode.binary_search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 难度系数, 2星(较简单)
 * 思路: 先层次遍历，注意一点是如果节点为空，加入null，不然答案不准确。
 * leetcode 101.
 * @author stormma
 * @date 2017/10/22
 */
public class Question101 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    private boolean isSymmetricList(List<Integer> values) {
        if (values == null || values.size() == 0) {
            return false;
        }
        int low = 0, high = values.size() - 1;
        while (low <= high) {
            if (values.get(low) != values.get(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    level.add(null);
                    continue;
                }
                level.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            ans.add(level);
        }
        return ans;
    }

    public boolean isSymmetric(TreeNode root) {
        for (List<Integer> list: levelOrder(root)) {
            if (!isSymmetricList(list)) {
                return false;
            }
        }
        return true;
    }
}
