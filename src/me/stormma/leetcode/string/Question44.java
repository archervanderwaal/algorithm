package me.stormma.leetcode.string;

/**
 * 难度系数: 5星
 * leetcode 44. Wildcard Matching
 * @author stormma
 * @date 2018/03/24
 */
public class Question44 {

    static class Solution1 {
        /**
         * time running: O(n)
         * bbarc
         * *c
         * @param s
         * @param p
         * @return
         */
        public boolean isMatch(String s, String p) {
            if (s == null && p == null) return true;
            if (s == null || p == null) return false;
            int sp = 0, pp = 0, star = -1, match = 0;
            while (sp < s.length()) {
                if (pp < p.length() && (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '?')) {
                    sp++;
                    pp++;
                } else if (pp < p.length() && p.charAt(pp) == '*') {
                    star = pp;
                    match = sp;
                    pp++;
                } else if (star != -1) {
                    pp = star + 1;
                    match++;
                    sp = match;
                } else {
                    return false;
                }
            }
            while (pp < p.length() && p.charAt(pp) == '*') pp++;
            return pp == p.length();
        }
    }

    /**
     * dp解决
     * time running time: O(n*m)
     * extra space: O(n*m)
     */
    static class Solution2 {
        public boolean isMatch(String s, String p) {
            if (s == null && p == null) return true;
            if (s == null || p == null) return false;
            // dp[i][j]表示s字符串中前i个和p中前j个字符是否匹配
            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
            dp[0][0] = true;
            // 初始化边界
            for (int i = 1; i <= p.length(); i++) {
                dp[0][i] = p.charAt(i - 1) == '*' && dp[0][i - 1];
            }
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 1; j <= p.length(); j++) {
                    if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (p.charAt(j - 1) == '*') {
                        // ab      abcd
                        // ab*     ab*
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                    }
                }
            }
            return dp[s.length()][p.length()];
        }
    }
}
