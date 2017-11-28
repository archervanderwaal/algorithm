package me.stormma.leetcode.linkedlist;

/**
 * 难度系数: 1星
 * leetcode 83
 * @author stormma
 * @date 2017/11/28
 */
public class Question83 {

    static class Solution1 {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode node = head;
            int preVal = 0;
            ListNode preNode = null;
            while (node != null) {
                if (preNode != null && preVal == node.val) {
                    preNode.next = node.next;
                    node.next = null;
                    node = preNode.next;
                    continue;
                }
                preVal = node.val;
                preNode = node;
                node = node.next;
            }
            return head;
        }
    }

    static class Solution2 {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode currentNode = head;
            while (currentNode != null && currentNode.next != null) {
                if (currentNode.val == currentNode.next.val){
                    currentNode.next = currentNode.next.next;
                } else {
                    currentNode = currentNode.next;
                }
            }
            return head;
        }
    }
}
