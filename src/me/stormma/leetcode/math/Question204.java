package me.stormma.leetcode.math;

/**
 * 难度系数：1星
 * leetcode 204
 * @author stormma
 * @date 2017/10/27
 */
public class Question204 {

    static class Solution {
        public int countPrimes(int n) {
            boolean[] notPrime = new boolean[n];
            int count = 0;
            for (int i = 2; i < n; i++) {
                if (notPrime[i] == false) {
                    count++;
                    for (int j = 2; i*j < n; j++) {
                        notPrime[i*j] = true;
                    }
                }
            }

            return count;
        }
    }
}
