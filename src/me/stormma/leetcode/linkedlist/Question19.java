package me.stormma.leetcode.linkedlist;

import java.util.Map;

/**
 * 难度系数: 2星
 * leetcode 19
 * @author stormma
 * @date 2017/11/07
 */
public class Question19 {

    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null || head.next == null) {
                return null;
            }
            int size = 0;
            ListNode node = head;
            // get listnode size
            while (node != null) {
                size++;
                node = node.next;
            }

            int index = size - n + 1;
            if (index == 1) {
                return head.next;
            }
            node = head;
            ListNode pre = head;
            int i = 1;
            while (node != null) {
                if (index - 1 == i) {
                    pre = node;
                } else if (index == i) {
                    pre.next = node.next;
                    node = null;
                    break;
                }
                i++;
                node = node.next;
            }
            return head;
        }
    }

// 1 2 3 4 5 removeIndex = 2
// size = 5, 5 - 2 + 1 = 4
}
