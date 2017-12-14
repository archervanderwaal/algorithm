package me.stormma.leetcode.dp;

/**
 * 难度系数:2星
 *
 * @author stormma
 * @date 2017/12/14
 */
public class Question121 {

    /**
     * Solution Function: Force Enumeration
     * Running Time O(n^2)  => ans: TLE
     */
    static class Solution1 {
        public int maxProfit(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }

            int ans = Integer.MIN_VALUE;
            for (int i = 0; i < prices.length; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    int tmp = prices[j] - prices[i];
                    ans = Math.max(tmp, ans);
                }
            }
            return ans < 0 ? 0 : ans;
        }
    }

    /**
     * Solution Function: Recursive
     * Running Time O(n) => ans: ACCEPTED
     */
    static class Solution2 {
        public int maxProfit(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }
            int ans = 0, minPrice = prices[0];
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > minPrice) {
                    ans = Math.max(prices[i] - minPrice, ans);
                } else {
                    minPrice = prices[i];
                }
            }
            return ans;
        }
    }

    /**
     * Solution Function: Kadane's Algorithm
     * Running Time: O(n) => ans: ACCEPTED
     */
    static class Solution3 {
        public int maxProfit(int[] prices) {
            int maxCur = 0, maxSoFar = 0;
            for (int i = 1; i < prices.length; i++) {
                maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
                maxSoFar = Math.max(maxCur, maxSoFar);
            }
            return maxSoFar;
        }
    }
}
