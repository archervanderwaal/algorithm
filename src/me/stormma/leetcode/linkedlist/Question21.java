package me.stormma.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * 难度系数: 2星
 * leetcode 21
 *
 * @author stormma
 * @date 2017/10/28
 */
public class Question21 {

    /**
     * Definition for singly-linked list.
     */

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode newList = new ListNode(0);
            ListNode node = newList;
            while (l1 != null || l2 != null) {
                if (l1 != null && l2 != null) {
                    if (l1.val > l2.val) {
                        node.next = l2;
                        l2 = l2.next;
                    } else {
                        node.next = l1;
                        l1 = l1.next;
                    }
                } else {
                    if (l1 != null) {
                        node.next = l1;
                        l1 = l1.next;
                    } else {
                        node.next = l2;
                        l2 = l2.next;
                    }
                }
                node = node.next;
            }
            return newList.next;
        }
    }
}
