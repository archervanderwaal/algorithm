package me.stormma.lintcode;

/**
 * lintcode 202. Segment Tree Query
 *
 * @author stormma
 * @date 2018/03/26
 */
public class Question202 {
    static class Solution {
        /**
         * @param root:  The root of segment tree.
         * @param start: start value.
         * @param end:   end value.
         * @return: The maximum number in the interval [start, end]
         */
        public int query(SegmentTreeNode root, int start, int end) {
            // write your code here
            if (root.start == end && root.end == end) return root.max;
            int mid = (root.start + root.end) >>> 1;
            if (end <= mid) return query(root.left, start, end);
            if (start > mid) return query(root.right, start, end);
            else return Math.max(query(root, start, mid), query(root, mid + 1, end));
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
