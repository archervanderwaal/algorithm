package me.stormma.leetcode.math;

/**
 * 难度系数: 1星
 * leetcode 231
 * @author stormma
 * @date 2017/10/27
 */
public class Question231 {

    /**
     * 0001 << 1 ==> 0010 << 1 ==>0100 << 1 ==>1000都是2的幂
     * 0000          0001         0011         0111  -1
     * 0000          0000         0000         0000  &
     */
    static class Solution {
        public boolean isPowerOfTwo(int n) {
            return n > 0 && ( n & (n - 1)) == 0;
        }
    }
}
