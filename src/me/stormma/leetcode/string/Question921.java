package me.stormma.leetcode.string;

import java.util.Stack;

/**
 * @author archer archer.vanderwaal@gmail.com
 */
public class Question921 {
    class Solution {
        public int minAddToMakeValid(String S) {
            if (S == null || S.length() == 0) return 0;
            Stack<Character> stack = new Stack<>();
            int len = S.length();
            int res = 0;
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) == '(') {
                    stack.push(')');
                } else { // )
                    if (!stack.isEmpty()) {
                        res += 2;
                        stack.pop();
                    }
                }
            }
            return len - res;
        }
    }
}
