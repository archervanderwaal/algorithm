package me.stormma.leetcode.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 难度系数: 2星
 * leetcode 07
 * @author stormma
 * @date 2017/11/07
 */
public class Question20 {

    static class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            Map<Character, Character> map = new HashMap<>();
            map.put('(', ')');
            map.put('[', ']');
            map.put('{', '}');
            for (char c : s.toCharArray()) {
                if (map.containsKey(c)) {
                    stack.push(c);
                } else {
                    if (stack.isEmpty() || map.get(stack.pop()) != c) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }
}
