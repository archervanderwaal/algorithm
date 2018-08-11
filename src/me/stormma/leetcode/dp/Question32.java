package me.stormma.leetcode.dp;

import java.util.Stack;

/**
 * 难度系数: 4星
 * leetcode 32
 * @author stormma
 * @date 2017/10/22
 */
public class Question32 {

    static class Solution {
        public int longestValidParentheses(String s) {
            Stack<Integer> stack = new Stack<>();
            int ans = 0;
            int startPos = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else { // if ')'
                    if (stack.isEmpty()) {
                        startPos = i + 1;
                    } else {
                        stack.pop();
                        if (stack.isEmpty()) {
                            ans = Math.max(ans, i - startPos + 1);
                        } else {
                            //(( ')'
                            ans = Math.max(ans, i - stack.peek());
                        }
                    }
                }
            }
            return ans;
        }
    }
}
