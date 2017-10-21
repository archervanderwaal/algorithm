package me.stormma.leetcode;

/**
 * leetcode
 */
public class Question2 {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return helper(l1, l2, 0);
    }

    private ListNode helper(ListNode l1, ListNode l2, int carry){
        if(l1 == null && l2 == null){
            return carry == 0? null : new ListNode(carry);
        }
        if(l1 == null && l2 != null){
            l1 = new ListNode(0);
        }
        if(l2 == null && l1 != null){
            l2 = new ListNode(0);
        }
        int sum = l1.val + l2.val + carry;
        ListNode curr = new ListNode(sum % 10);
        curr.next = helper(l1.next, l2.next, sum / 10);
        return curr;
    }

    public static void main(String [] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(0);
        l2.next.next = new ListNode(5);
        ListNode result = new Question2().addTwoNumbers(l1, l2);
        System.out.println(result);
    }
}
