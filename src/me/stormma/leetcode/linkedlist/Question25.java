package me.stormma.leetcode.linkedlist;

/**
 * 难度系数: 5星
 * leetcode 25
 * @author stormma
 * @date 2017/11/07
 */
public class Question25 {

    static class Solution1 {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode node = new ListNode(0), pre = node;
            node.next = head;
            // node -> 1 -> 2 -> 3 -> 4
            for (int i = 1; head != null; i++) {
                if (i % k == 0) {
                    pre = reverse(pre, head.next);
                    head = pre.next;
                } else {
                    head = head.next;
                }
            }
            return node.next;
        }

        /**
         * @description reverse all nodes of pre to next(no include pre and next)
         * @param pre
         * @param next
         * @return next pre
         */
        private ListNode reverse(ListNode pre, ListNode next) {
            // pre node1 node2 node3 next
            // pre head move(x)  y   next
            // pre -> x -> head -> y next
            ListNode head = pre.next;
            ListNode move = head.next;
            while (move != next) {
                head.next = move.next;
                move.next = pre.next;
                pre.next = move;
                move = head.next;
            }
            return head;
        }
    }


    static class Solution2 {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || head.next == null || k == 1) {
                return head;
            }
            ListNode node = head, end = null, pre = new ListNode(0);
            pre.next = head;
            int index = 0;
            // find reverse end node
            while (node != null) {
                if (index == k) {
                    end = node;
                    break;
                }
                index++;
                node = node.next;
            }
            if (index != k) {
                return head;
            }
            // reverse pre -> end
            ListNode move = head.next;
            while (move != end) {
                head.next = move.next;
                move.next = pre.next;
                pre.next = move;
                move = head.next;
            }
            head.next = reverseKGroup(end, k);
            return pre.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        System.out.println(new Solution2().reverseKGroup(head, 2));
    }
}
