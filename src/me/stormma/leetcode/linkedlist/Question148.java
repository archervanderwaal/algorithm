package me.stormma.leetcode.linkedlist;

/**
 * leetcode 148 Sort List
 * @author stormma
 * @date 2018/03/14
 */
public class Question148 {

    /**
     * time: O(nlogn)
     * space: O(n)
     */
    private static class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode middle = getMiddle(head);
            ListNode next = middle.next;
            middle.next = null;
            return merge(sortList(head), sortList(next));
        }

        private ListNode merge(ListNode head, ListNode next) {
            ListNode dummy = new ListNode(0);
            ListNode current = dummy;
            while (head != null && next != null) {
                if (head.val <= next.val) {
                    current.next = head;
                    head = head.next;
                } else {
                    current.next = next;
                    next = next.next;
                }
                current = current.next;
            }
            if (head == null) current.next = next;
            else current.next = head;
            return dummy.next;
        }

        private ListNode getMiddle(ListNode head) {
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }
}
