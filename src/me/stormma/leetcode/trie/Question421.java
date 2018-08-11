package me.stormma.leetcode.trie;

/**
 * @author stormma stormmaybin@gmail.com
 */
public class Question421 {

    static class Solution {
        public int findMaximumXOR(int[] numbers) {
            if (numbers == null || numbers.length == 0) return -1;
            // 构建字典树
            Node root = new Node(-1), currentNode = root;
            for (int i = 0; i < numbers.length; i++) {
                for (int j = 31; j >= 0; j--) {
                    int bit = (numbers[i] >> j) & 1;
                    if (bit == 0) {
                        if (currentNode.right == null) {
                            currentNode.right = new Node(0);
                        }
                        currentNode = currentNode.right;
                    } else {
                        if (currentNode.left == null) {
                            currentNode.left = new Node(1);
                        }
                        currentNode = currentNode.left;
                    }
                }
                currentNode = root;
            }
            int max = 0;
            for (int i = 0; i < numbers.length; i++) {
                int res = 0;
                for (int j = 31; j >=0; j--) {
                    int bit = (numbers[i] >> j) & 1;
                    if (bit == 1) {
                        if (currentNode.right != null) {
                            currentNode = currentNode.right;
                            res += 1 << j;
                        } else {
                            currentNode = currentNode.left;
                        }
                    } else {
                        if (currentNode.left != null) {
                            currentNode = currentNode.left;
                            res += 1 << j;
                        } else {
                            currentNode = currentNode.right;
                        }
                    }
                }
                currentNode = root;
                max = Math.max(res, max);
            }
            return max;
        }
    }

    static class Node {
        int val;
        Node left;   // one
        Node right; // zero
        public Node(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
}
