package me.stormma.others;

import java.util.Scanner;

public class Bytedance3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            B[i] = in.nextInt();
        }
        SegmentTreeNode rootA = build(A, 0, n - 1);
        SegmentTreeNode rootB = build(B, 0, n - 1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int maxA = queryMax(rootA, i, j);
                int minB = queryMin(rootB, i, j);
                if (maxA < minB) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    public static int queryMin(SegmentTreeNode root, int start, int end) {
        if (root.start == start && root.end == end) return root.min;
        int mid = (root.start + root.end) >>> 1;
        if (end <= mid) return queryMin(root.left, start, end);
        if (start > mid) return queryMin(root.right, start, end);
        return Math.min(queryMin(root.left, start, mid), queryMin(root.right, mid + 1, end));
    }

    public static int queryMax(SegmentTreeNode root, int start, int end) {
        if (root.start == start && root.end == end) return root.max;
        int mid = (root.start + root.end) >>> 1;
        if (end <= mid) return queryMax(root.left, start, end);
        if (start > mid) return queryMax(root.right, start, end);
        return Math.max(queryMin(root.left, start, mid), queryMax(root.right, mid + 1, end));
    }

    private static SegmentTreeNode build(int[] A, int start, int end) {
        if (start > end) return null;
        SegmentTreeNode node = new SegmentTreeNode(start, end, Integer.MAX_VALUE, Integer.MIN_VALUE);
        if (start == end) {
            node.max = node.min = A[start];
        } else {
            int mid = (start + end) >>> 1;
            node.left = build(A, start, mid);
            node.right = build(A, mid + 1, end);
            if (node.right == null) {
                node.min = node.left.min;
                node.max = node.left.max;
            } else {
                node.min = Math.min(node.left.min, node.right.min);
                node.max = Math.max(node.left.max, node.right.max);
            }
        }
        return node;
    }

    private static class SegmentTreeNode {
        int start, end, min, max;
        SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, int min, int max) {
            this.start = start;
            this.end = end;
            this.min = min;
            this.max = max;
        }
    }
}
