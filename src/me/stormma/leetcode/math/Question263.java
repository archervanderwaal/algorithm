package me.stormma.leetcode.math;

/**
 * 难度系数: 二星
 * leetcode 239. Ugly Number
 * @author stormma
 * @date 2018/03/26
 */
public class Question263 {
    static class Solution {
        public boolean isUgly(int num) {
            if (num < 1) return false;
            while (num % 2 == 0) {
                num /= 2;
            }
            while (num % 3 == 0) {
                num /= 3;
            }
            while (num % 5 == 0) {
                num /= 5;
            }
            return num == 1;
        }
    }
}
