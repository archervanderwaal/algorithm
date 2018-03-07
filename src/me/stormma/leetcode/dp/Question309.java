package me.stormma.leetcode.dp;

/**
 * 难度系数: 3星
 * leetcode309
 * @author stormma
 * @date 2018/01/26
 */
public class Question309 {

    /**
     * Runind time O(n)
     * space Complexity O(n)
     */
    static class Solution1 {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[] hold = new int[n + 1];
            int[] sold = new int[n + 1];
            int[] rest = new int[n + 1];

            sold[0] = 0; rest[0] = 0; hold[0] = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                hold[i] = Math.max(hold[i - 1], rest[i - 1] - prices[i - 1]);
                sold[i] = hold[i - 1] + prices[i - 1];
                rest[i] = Math.max(rest[i - 1], sold[i - 1]);
            }
            return Math.max(rest[n], sold[n]);
        }
    }

    /**rr
     * Time Complexity O(n)
     * Space Complexity O(1)
     */
    static class Solution2 {
        public int maxProfit(int[] prices) {
            int rest = 0, sold = 0, hold = Integer.MIN_VALUE;
            for (int price : prices) {
                int preSold = sold;
                sold = hold + price;
                hold = Math.max(hold, rest - price);
                rest = Math.max(rest, preSold);
            }
            return Math.max(rest, sold);
        }
    }
}


/**
 *
 * 状态转换:
 *  rest -rest-> rest
 *  rest -buy-> hold
 *  hold -rest-> hold
 *  hold -sell-> sold
 *  sold -rest-> rest
 */
