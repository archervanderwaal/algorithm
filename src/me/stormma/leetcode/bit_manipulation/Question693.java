package me.stormma.leetcode.bit_manipulation;

/**
 * 方法各种各样，但是尽量使用位操作完成
 * 难度系数: 1星
 * leetcode 693
 * @author stormma
 * @date 2017/11/03
 */
public class Question693 {

    static class Solution {
        public boolean hasAlternatingBits(int n) {
            int x = n;
            int len = 0;
            while (x > 0) {
                x >>= 1;
                len++;
            }
            return ((0x55555555 >>> (32 - len)) ^ (long) n) == (-1 >>> (32 - len));
        }
    }
}
