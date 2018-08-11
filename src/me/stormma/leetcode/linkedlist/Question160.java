package me.stormma.leetcode.linkedlist;

/**
 * leetcode 160. Intersection of Two Linked Lists
 * @author stormma
 * @date 2018/03/14
 */
public class Question160 {

    static class Solution1 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) return null;
            boolean flag = false;
            int lenA = len(headA), lenB = len(headB);
            if (lenA > lenB) {
                while (lenA != lenB) {
                    headA = headA.next;
                    lenA--;
                }
            } else {
                while (lenA != lenB) {
                    headB = headB.next;
                    lenB--;
                }
            }
            while (headA != headB) {
                headA = headA.next;
                headB = headB.next;
            }
            return headA;
        }

        private int len(ListNode node) {
            int len = 0;
            while (node != null) {
                len++;
                node = node.next;
            }
            return len;
        }
    }

    static class Solution2 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) return null;
            ListNode a = headA, b = headB;
            int count = 1;
            while (a != b && count <= 2) {
                if (a == null) {
                    a = headB;
                    count++;
                } else {
                    a = a.next;
                }
                b = b == null ? headA : b.next;
            }
            return count <= 2 ? a : null;
        }
    }
}

// a1 -> a2 -> a3 -> a4 -> b1 -> b2 -> b3 -> b4
// b1 -> b2 -> b3 -> b4 -> a1 -> a2 -> a3 -> a4