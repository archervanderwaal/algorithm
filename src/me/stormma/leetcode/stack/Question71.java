package me.stormma.leetcode.stack;

import java.util.Stack;

/**
 * Stack 水题
 * 难度系数: 2星
 * leetcode 71
 * @author stormma
 * @date 2017/12/06
 */
public class Question71 {

    static class Solution1 {
        public String simplifyPath(String path) {
            Stack<String> stack = new Stack<>();
            for (String part : path.split("/")) {
                if (!part.equals(".") && !part.equals("..") && !part.isEmpty()) {
                    stack.push(part);
                } else if (part.equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                }
            }
            if (stack.isEmpty()) return "/";
            String ans = "";
            while (!stack.isEmpty()) {
                ans = "/" + stack.pop() + ans;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().simplifyPath("////a"));
    }
}
