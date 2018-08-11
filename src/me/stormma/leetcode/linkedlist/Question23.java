package me.stormma.leetcode.linkedlist;

/**
 * 难度系数: 3星
 * leetcode 23
 * @author stormma
 * @date 2017/11/07
 */
public class Question23 {

    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            return merge(lists, 0, lists.length - 1);
        }

        // 1 2 3 4
        // 0 -> 3
        // 0 -> 1 2 -> 3
        private ListNode merge(ListNode[] lists, int left, int right) {
            if (left == right) {
                return lists[left];
            }
            int mid = (left + right) >> 1;
            return mergeTwoLists(merge(lists, left, mid), merge(lists, mid + 1, right));
        }

        private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
