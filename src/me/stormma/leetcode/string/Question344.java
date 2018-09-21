package me.stormma.leetcode.string;

/**
 * @author archer.vanderwaal@gmail.com
 */
public class Question344 {
    class Solution {
        public String reverseString(String s) {
            if (s == null || s.length() <= 1) return s;
            char[] sc = s.toCharArray();
            int start = 0, end = sc.length - 1;
            while (start < end) {
                char c = sc[start];
                sc[start++] = sc[end];
                sc[end--] = c;
            }
            return new String(sc);
        }
    }
}
