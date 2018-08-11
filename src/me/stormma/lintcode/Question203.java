package me.stormma.lintcode;

/**
 * lintcode 203.
 *
 * @author stormma
 * @date 2018/03/26
 */
public class Question203 {
    static class Solution {
        /**
         * @param root:  The root of segment tree.
         * @param index: index.
         * @param value: value
         * @return: nothing
         */
        public void modify(SegmentTreeNode root, int index, int value) {
            // write your code here
            if (index == root.start && index == root.end) {
                root.max = value;
                return;
            }
            int mid = (root.start + root.end) >>> 1;
            if (index <= mid) {
                // left
                modify(root.left, index, value);
            } else {
                // right
                modify(root.right, index, value);
            }
            root.max = Math.max(root.right.max, root.left.max);
        }
    }

    static class SegmentTreeNode {
        public int start, end, max;
        public SegmentTreeNode left, right;

        public SegmentTreeNode(int start, int end, int max) {
            this.start = start;
            this.end = end;
            this.max = max;
            this.left = this.right = null;
        }
    }
}
