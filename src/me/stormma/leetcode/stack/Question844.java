package me.stormma.leetcode.stack;

import java.util.Stack;

/**
 * @author stormma stormmaybin@gmail.com
 */
public class Question844 {

    class Solution {
        public boolean backspaceCompare(String S, String T) {
            if (S == null || S.length() == 0 || T == null || T.length() == 0) {
                return (S == null || S.length() == 0) && (T == null || T.length() == 0);
            }
            Stack<Character> s = new Stack<>();
            for (char c : S.toCharArray()) {
                if (c != '#') {
                    s.push(c);
                } else {
                    if (!s.isEmpty()) {
                        s.pop();
                    }
                }
            }
            Stack<Character> t = new Stack<>();
            for (char c : T.toCharArray()) {
                if (c != '#') {
                    t.push(c);
                } else {
                    if (!t.isEmpty()) {
                        t.pop();
                    }
                }
            }
            while (!s.isEmpty() && !t.isEmpty()) {
                if (s.pop() != t.pop()) {
                    return false;
                }
            }
            return s.isEmpty() && t.isEmpty();
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
    }
}
