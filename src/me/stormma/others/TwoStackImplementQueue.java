package me.stormma.others;

import java.util.Stack;

/**
 * @brief 两个Stack实现Queue
 * @author stormma stormmaybin@gmail.com
 */
public class TwoStackImplementQueue {

    private Stack<Integer> stack1;

    private Stack<Integer> stack2;

    public TwoStackImplementQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int val) {
        if (stack1.isEmpty()) {
            stack2.push(val);
        } else {
            stack1.push(val);
        }
    }

    public int pop() {
        if (stack1.isEmpty()) {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            return stack1.pop();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

    public static void main(String[] args) {
        TwoStackImplementQueue queue = new TwoStackImplementQueue();
        System.out.println(queue.pop());
        queue.push(1);
        queue.push(2);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
