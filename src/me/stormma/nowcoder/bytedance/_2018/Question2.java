package me.stormma.nowcoder.bytedance._2018;

import java.util.*;

public class Question2 {
    static class Solution {
        static class Node {
            int s;
            int m;
            int count;

            public Node(int s, int m, int count) {
                this.s = s;
                this.m = m;
                this.count = count;
            }
        }
        public static void main(String... args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(1, 1, 0));
            int ans = 0;
            int cnt = 0;
            while (!queue.isEmpty()) {
                cnt++;
                Node node = queue.poll();
                if (node.s == n) {
                    ans = node.count;
                    break;
                } else if (node.s < n) {
                    Node node1 = new Node(node.s * 2, node.s, node.count + 1);
                    Node node2 = new Node(node.s + node.m, node.m, node.count + 1);
                    queue.add(node1);
                    queue.add(node2);
                }
            }
            System.out.println(ans + "==>" + cnt);
        }
    }
}
