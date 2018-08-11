package me.stormma.leetcode.bit_manipulation;

/**
 * 难度系数: 1星
 * leetcode 461
 * @author stormma
 * @date 2017/11/03
 */
public class Question461 {

    static class Solution {
        public int hammingDistance(int x, int y) {
            x ^= y;
            int ans = 0;
            while (x > 0) {
                if ((x & 1) == 1) {
                    ans++;
                }
                x >>= 1;
            }
            return ans;
        }
    }
}
