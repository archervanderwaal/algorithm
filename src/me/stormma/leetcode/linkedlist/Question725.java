package me.stormma.leetcode.linkedlist;

/**
 * 难度系数: 3星
 * leetcode 725
 * @author stormma
 * @date 2017/11/12
 */
public class Question725 {

    static class Solution {
        public ListNode[] splitListToParts(ListNode root, int k) {
            int len = 0;
            ListNode tmp = root;
            while (tmp != null) {
                len++;
                tmp = tmp.next;
            }
            ListNode[] res = new ListNode[k];
            int size = len / k;
            int remain = len % k;
            ListNode pre = null;
            for (int i = 0; i < k; i++, remain--) {
                res[i] = root;
                for (int j = 0; j < size + (remain > 0 ? 1 : 0); j++) {
                    pre = root;
                    root = root.next;
                }
                if (pre != null) {
                    pre.next = null;
                }
            }
            return res;
        }
    }
}
