package me.stormma.lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * lintcode 205.
 * @author stormma
 * @date 2018/03/26
 */
public class Question205 {
    static class Solution {
        /**
         * @param A: An integer array
         * @param queries: An query list
         * @return: The result list
         */
        public List<Integer> intervalMinNumber(int[] A, List<Interval> queries) {
            // write your code here
            SegmentTreeNode root = build(A, 0, A.length - 1);
            List<Integer> ans = new ArrayList<>();
            for (Interval val : queries) {
                ans.add(query(root, val.start, val.end));
            }
            return ans;
        }

        public int query(SegmentTreeNode root, int start, int end) {
            if (root.start == start && root.end == end) return root.min;
            int mid = (root.start + root.end) >>> 1;
            if (end <= mid) return query(root.left, start, end);
            if (start > mid) return query(root.right, start, end);
            return Math.min(query(root.left, start, mid), query(root.right, mid + 1, end));
        }

        private SegmentTreeNode build(int[] A, int start, int end) {
            if (start > end) return null;
            SegmentTreeNode node = new SegmentTreeNode(start, end, Integer.MAX_VALUE);
            if (start == end) {
                node.min = A[start];
            } else {
                int mid = (start + end) >>> 1;
                node.left = build(A, start, mid);
                node.right = build(A, mid + 1, end);
                node.min = Math.min(node.left.min, node.right.min);
            }
            return node;
        }

        private static class SegmentTreeNode {
            int start, end, min;
            SegmentTreeNode left, right;
            public SegmentTreeNode(int start, int end, int min) {
                this.start = start;
                this.end = end;
                this.min = min;
            }
        }
    }
    static class Interval {
        int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
