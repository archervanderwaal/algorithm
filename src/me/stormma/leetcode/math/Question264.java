package me.stormma.leetcode.math;

/**
 * 难度系数: 三星
 * leetcode 264.
 * @author stormma
 * @date 2018/03/26
 */
public class Question264 {
    static class Solution {
        public int nthUglyNumber(int n) {
            if (n < 1) return 0;
            int[] dp = new int[n];
            int moreThanPreUglyNumMinIndex2 = 0, moreThanPreUglyNumMinIndex3 = 0, moreThanPreUglyNumMinIndex5 = 0;
            dp[0] = 1;
            int index = 1;
            for (int i = index; i < n; i++) {
                dp[i] = Math.min(dp[moreThanPreUglyNumMinIndex2] * 2
                        , Math.min(dp[moreThanPreUglyNumMinIndex3] * 3, dp[moreThanPreUglyNumMinIndex5] * 5));
                if (dp[moreThanPreUglyNumMinIndex2] * 2 == dp[i]) moreThanPreUglyNumMinIndex2++;
                if (dp[moreThanPreUglyNumMinIndex3] * 3 == dp[i]) moreThanPreUglyNumMinIndex3++;
                if (dp[moreThanPreUglyNumMinIndex5] * 5 == dp[i]) moreThanPreUglyNumMinIndex5++;
            }
            return dp[n -1];
        }
    }
}
