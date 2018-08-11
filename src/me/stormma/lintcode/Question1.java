package me.stormma.lintcode;

/**
 * lintcode 1. A+B
 * @author stormma
 * @date 2018/03/26
 */
public class Question1 {
    static class Solution {
        /**
         * @param a: An integer
         * @param b: An integer
         * @return: The sum of a and b
         */
        public int aplusb(int a, int b) {
            // write your code here
            int ans= 0;
            while (b != 0) {
                ans = a ^ b;
                b = (a & b) << 1;
                a = ans;
            }
            return a;
        }
    }
}
