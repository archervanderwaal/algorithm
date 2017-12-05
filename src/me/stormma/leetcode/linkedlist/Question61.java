package me.stormma.leetcode.linkedlist;

/**
 * 难度系数: 3星
 * leetcode 61
 * @author stormma
 * @date 2017/12/04
 */
public class Question61 {

    /**
     */
    static class Solution {
        public ListNode rotateRight(ListNode head, int n) {
            if (head == null || head.next == null) return head;
            ListNode ans = new ListNode(0);
            ans.next = head;
            ListNode node1 = ans, node2 = ans;
            int size = 0;
            // get length of listnode
            while (node1.next != null) {
                ++size;
                node1 = node1.next;
            }
            // get (size - n % size)th node if [1, 2, 3, 4, 5] and n = 2, size - n % size = 5 - 2 % 5 = 3
            for (int j = size - n % size; j > 0; j--)
                node2 = node2.next;
            node1.next = ans.next;
            ans.next = node2.next;
            node2.next = null;
            return ans.next;
        }
    }
}
