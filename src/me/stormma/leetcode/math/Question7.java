package me.stormma.leetcode.math;

/**
 * 难度系数: 一星
 * leetcode 7
 * @author stormma
 * @date 2017/10/26
 */
public class Question7 {
    static class Solution {
        public int reverse(int x) {
            boolean isNegative = x < 0;
            if (isNegative) {
                x = -x;
            }
            long l = 0;
            while (x > 0) {
                l = l * 10 + x % 10;
                x /= 10;
                if (l > Integer.MAX_VALUE) {
                    return 0;
                }
            }
            return isNegative ? (0 - (int)l) : (int)l;
        }
    }
}
