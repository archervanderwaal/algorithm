package me.stormma.leetcode.string;

/**
 * 难度系数: 3星
 * leetcode 5
 * @author stormma
 * @date 2017/11/06
 */
public class Question5 {

    static class Solution {
        static int longestSize = 0, startPos = 0;
        public String longestPalindrome(String s) {
            if (s == null || s.length() == 1) {
                return s;
            }
            for (int i = 0; i < s.length(); i++) {
                checkOddPalindrome(s, i);
                checkEvenPalindrome(s, i);
            }
            return s.substring(startPos, startPos + longestSize);
        }

        private void checkOddPalindrome(String s, int index) {
            // odd palindrome
            int start = index, end = index;
            while (start > 0 && end < s.length() - 1 && s.charAt(start - 1) == s.charAt(end + 1)) {
                start--;
                end++;
            }
            // start -> end
            if (end - start + 1 > longestSize) {
                longestSize = end - start + 1;
                startPos = start;
            }
        }

        private void checkEvenPalindrome(String s, int index) {
            int start = index, end = Math.min(s.length() - 1, index + 1);
            while (start > 0 && end < s.length() - 1 && s.charAt(start - 1) == s.charAt(end + 1) && s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
            }

            if (end - start + 1 > longestSize && s.charAt(start) == s.charAt(end)) {
                longestSize = end - start + 1;
                startPos = start;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("bb"));
    }
}
