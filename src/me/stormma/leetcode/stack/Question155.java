package me.stormma.leetcode.stack;

/**
 * leetcode 155. Min Stack
 * @author stormma
 * @date 2018/03/14
 */
public class Question155 {

    private static class MinStack {

        private Node first;
        private int size;
        private Node minFirst;

        class Node {
            private int val;
            private Node next;

            public Node(int val) {
                this.val = val;
            }

            public Node next(Node next) {
                this.next = next;
                return this;
            }
        }

        /** initialize your data structure here. */
        public MinStack() {
            ;
        }

        public void push(int x) {
            if (isEmpty()) {
                first = new Node(x);
                minFirst = new Node(x);
            } else {
                Node oldFirst = first;
                first = new Node(x);
                first.next = oldFirst;
                // push min stack
                int tmp = Math.min(minFirst.val, x);
                Node oldMinFirst = minFirst;
                minFirst = new Node(tmp);
                minFirst.next = oldMinFirst;
            }
            size++;
        }

        public void pop() {
            if (isEmpty()) return;
            first = first.next;
            minFirst = minFirst.next;
        }

        public int top() {
            return first.val;
        }

        public int getMin() {
            return minFirst.val;
        }

        public boolean isEmpty() {
            return first == null;
        }
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println("sss");
    }
}
