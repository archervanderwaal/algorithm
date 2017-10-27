package me.stormma.leetcode.math;

/**
 * 难度系数: 3星
 * leetcode 29
 * @author stormma
 * @date 2017/10/27
 */
public class Question29 {

    static class Solution {
        public int divide(int dividend, int divisor) {
            // is positive number
            boolean flag = !((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0));
            long ans = ldivide(Math.abs((long)dividend), Math.abs((long)divisor));
            ans = flag ? ans : 0 - ans;
            if (ans < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            if (ans > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            return (int) ans;
        }

        private long ldivide(long dividend, long divisor) {
            if (divisor == 0) {
                return Long.MAX_VALUE;
            }
            if (dividend == 0 || dividend < divisor) {
                return 0;
            }
            int i = 1;
            long k = divisor;
            long ans = 0;
            while ((k + k) < dividend) {
                k = k << 1;
                i = i << 1;
            }
            dividend -= k;
            ans += i;
            while (dividend > 0) {
                while (k > dividend) {
                    k = k >> 1;
                    i = i >> 1;
                }
                dividend -= k;
                ans += i;
            }
            return ans;
        }
    }

    static class Solution2 {
        public int divide(int dividend, int divisor) {
            // is positive number
            boolean flag = !((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0));
            long lDividend = Math.abs((long)dividend);
            long lDivisor = Math.abs((long)divisor);
            if (lDivisor == 0) {
                return Integer.MAX_VALUE;
            }
            if (lDividend == 0 || lDividend < lDivisor) {
                return 0;
            }
            long ans = divideRecursive(lDividend, lDivisor);
            ans = flag ? ans : 0 - ans;
            if (ans < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            if (ans > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            return (int) ans;
        }

        private long divideRecursive(long dividend, long divisor) {
            if (divisor == 1) {
                return dividend;
            }
            if (dividend < divisor) {
                return 0;
            }
            if (dividend == divisor) {
                return 1;
            }
            int i = 1;
            long k = divisor;
            int ans = 0;
            while ((k + k) < dividend) {
                k = k << 1;
                i = i << 1;
            }
            dividend -= k;
            ans += i;
            ans += divideRecursive(dividend, divisor);
            return ans;
        }
    }
}
