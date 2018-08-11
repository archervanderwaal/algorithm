package me.stormma.leetcode.linkedlist;

/**
 * 难度系数: 3星
 * leetcode 24
 * @author stormma
 * @date 2017/11/07
 */
public class Question24 {

    static class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode node = head.next;
            head.next = swapPairs(head.next.next);
            node.next = head;
            return node;
        }
    }
}
