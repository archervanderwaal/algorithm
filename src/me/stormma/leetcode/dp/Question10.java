package me.stormma.leetcode.dp;

/**
 * 难度系数: 5星
 * leetcode 10
 * @author stormma
 * @date 2017/11/06
 */
public class Question10 {

    static class Solution {
        public boolean isMatch(String s, String p) {
            if (p.isEmpty()) {
                return s.isEmpty();
            }
            boolean firstMatch = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

            if (p.length() >= 2 && p.charAt(1) == '*') {
                return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
            } else {
                return firstMatch && isMatch(s.substring(1), p.substring(1));
            }
        }
    }

    static class Solution2 {
        public boolean isMatch(String s, String p) {
            if (p.isEmpty()) {
                return s.isEmpty();
            }
            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
            dp[0][0] = true;
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[0][j] = dp[0][j - 2];
                }
            }

            for (int i = 1; i <= s.length(); i++) {
                for (int j = 1; j <= p.length(); j++) {
                    if (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (p.charAt(j - 1) == '*') {
                        if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {
                            dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                        } else {
                            dp[i][j] = dp[i][j - 2];
                        }
                    }
                }
            }
            return dp[s.length()][p.length()];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().isMatch("aaa", "ab*ac*a"));
    }
}
