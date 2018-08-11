package me.stormma.leetcode.math;

/**
 * 难度系数: 2.5星
 * leetcode 2
 *
 * @author stormma
 * @date 2017/10/26
 */
public class Question2 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int carry = 0;
            ListNode result = new ListNode(0);
            ListNode node = result;
            while (l1 != null || l2 != null) {
                int sum = carry;
                carry = 0;
                if (l1 != null) {
                    sum += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    sum += l2.val;
                    l2 = l2.next;
                }
                if (sum >= 10) {
                    carry = sum / 10;
                    sum %= 10;
                }
                node.next = new ListNode(sum);
                node = node.next;
            }
            if (carry != 0) {
                node.next = new ListNode(carry);
            }
            return result.next;
        }
    }
}
