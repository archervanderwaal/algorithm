package me.stormma.lintcode;

/**
 * 难度系数: 1星
 * lintcode 201. Segment Tree Build
 * @author stormma
 * @date 2018/03/26
 */
public class Question201 {

    static class Solution {
        /*
         * @param start: start value.
         * @param end: end value.
         * @return: The root of Segment Tree.
         */
        public SegmentTreeNode build(int start, int end) {
            // write your code here
            if (start > end) return null;
            SegmentTreeNode root = new SegmentTreeNode(start, end);
            if (start == end) return root;
            int mid = (start + end) >>> 1;
            root.left = build(start, mid);
            root.right = build(mid + 1, end);
            return root;
        }
    }
}
