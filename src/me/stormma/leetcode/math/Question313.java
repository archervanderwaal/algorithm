package me.stormma.leetcode.math;

/**
 * 难度系数: 三星
 * leetcode 313. Super Ugly Number
 * @author stormma
 * @date 2018/03/26
 */
public class Question313 {
    static class Solution1 {
        public int nthSuperUglyNumber(int n, int[] primes) {
            int[] dp = new int[n];
            int[] inx = new int[primes.length];
            dp[0] = 1;
            for (int i = 1; i < n; i++) {
                dp[i] = Integer.MAX_VALUE;
                for (int j = 0; j < primes.length; j++) {
                    dp[i] = Math.min(dp[i], dp[inx[j]] * primes[j]);
                }
                for (int j = 0; j < primes.length; j++) {
                    if (primes[j] * dp[inx[j]] == dp[i]) inx[j]++;
                }
            }
            return dp[n - 1];
        }
    }
}
