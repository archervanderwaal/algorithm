package me.stormma.lintcode;

/**
 * lintcode 2.
 * @author stormma
 * @date 2018/03/26
 */
public class Question2 {
    static class Solution {
        /*
         * @param n: An integer
         * @return: An integer, denote the number of trailing zeros in n!
         */
        public long trailingZeros(long n) {
            // write your code here, try to do it without arithmetic operators.
            long cnt = 0;
            while (n > 0) {
                cnt += (n / 5);
                n /= 5;
            }
            int i = 0;
            return cnt;
        }
    }
}
