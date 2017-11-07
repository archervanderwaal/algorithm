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
        String ans = "";
        public String longestPalindrome(String s) {
            if (s == null || s.length() == 1) {
                return s;
            }
            for (int i = 0; i < s.length(); i++) {
                String tmp1 = check(s, i,i);
                String tmp2 = check(s, i, i + 1);
                if (ans.length() < Math.max(tmp1.length(), tmp2.length())) {
                    ans = tmp1.length() >= tmp2.length() ? tmp1 : tmp2;
                }
            }
            return ans;
        }

        private String check(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            // abac
            // right = 3
            // left = -1
            // 3 + 1 = 4
            return s.substring(left + 1, right);
        }
    }



    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("bb"));
    }
}
