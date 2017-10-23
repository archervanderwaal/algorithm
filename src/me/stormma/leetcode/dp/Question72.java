package me.stormma.leetcode.dp;

/**
 * 难度系数: 4星 ==> 难度系数说明：普通的递归肯定会TLE,使用记忆化搜索优化，dp状态转移方程比较难琢磨，容易考虑不周
 * 思路分析: 从word1和word2最后一个字符开始判断，如果相等，那么答案就是word1前i-1项和word2前j-1项的操作数，如果不相等
 * 可以从word1的i-1转换成word2的j ，也可以从Word1的i转换成wordj-1转换得到再加上1，或者是word1的i-1转换成word2的j-1
 * leetcode 72
 * @author stormma
 */
public class Question72 {
    static class Solution {

        private int solve(String word1, String word2, int pos1, int pos2, int[][] memo) {
            if (pos1 == 0) {
                return memo[pos1][pos2] = pos2;
            }
            if (pos2 == 0) {
                return memo[pos1][pos2] = pos1;
            }
            if (word1.charAt(pos1 - 1) == word2.charAt(pos2 - 1)) {
                if (memo[pos1 - 1][pos2 - 1] != 0) {
                    return memo[pos1 - 1][pos2 - 1];
                }
                return memo[pos1][pos2] = solve(word1, word2, pos1 - 1, pos2 - 1, memo);
            } else {
                if (memo[pos1 - 1][pos2] == 0) {
                    memo[pos1 - 1][pos2] = solve(word1, word2, pos1 - 1, pos2, memo);
                }
                if (memo[pos1][pos2 - 1] == 0) {
                    memo[pos1][pos2 - 1] = solve(word1, word2, pos1, pos2 - 1, memo);
                }
                if (memo[pos1 - 1][pos2 - 1] == 0) {
                    memo[pos1 - 1][pos2 - 1] = solve(word1, word2, pos1 - 1, pos2 - 1, memo);
                }
                return 1 + Math.min(Math.min(memo[pos1 - 1][pos2], memo[pos1][pos2 - 1]), memo[pos1 - 1][pos2 - 1]);
            }
        }

        public int minDistance(String word1, String word2) {
            int[][] memo = new int[word1.length() + 1][word2.length() + 1];
            return solve(word1, word2, word1.length(), word2.length(), memo);
        }
    }

    static class Solution2 {
        public int minDistance(String word1, String word2) {
            // dp[i][j] 表示word1的前i个字符转换成word2的前j个字符需要操作次数
            int[][] dp = new int[word1.length() + 1][word2.length() + 1];
            for (int i = 0; i <= word1.length(); i++) {
                dp[i][0] = i;
            }
            for (int j = 0; j <= word2.length(); j++) {
                dp[0][j] = j;
            }
            for (int i = 1; i <= word1.length(); i++) {
                for (int j = 1; j <= word2.length(); j++) {
                    int c = (word1.charAt(i - 1) == word2.charAt(j - 1)) ? 0 : 1;
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + c, 1 + Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
            return dp[word1.length()][word2.length()];
        }
    }
}
