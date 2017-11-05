package me.stormma.leetcode.string;

import java.util.Arrays;
import java.util.Stack;

/**
 * leetcode 720
 * @author stormma
 * @date 2017/11/04
 */
public class Question720 {

    static class Solution {
        public String longestWord(String[] words) {
            if (words == null || words.length == 0) {
                return "";
            }
            Stack<String> stack = new Stack<>();
            Arrays.sort(words);
            stack.push("");
            int max = 0;
            String ans = "";
            for (String word: words) {
                while (!stack.isEmpty() && stack.peek().equals(word.substring(0, word.length()))) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek().length() != word.length() - 1) {
                    continue;
                }
                stack.push(word);
                if (stack.size() > max) {
                    max = stack.size();
                    ans = stack.peek();
                }
            }
            return ans;
        }
    }


    public static void main(String[] args) {
        String[] words = {"rac","rs","ra","on","r","otif","o","onpdu","rsf","rs","ot","oti","racy","onpd"};
        System.out.println(new Solution().longestWord(words));
    }
}
