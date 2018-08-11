package me.stormma.leetcode.math;

/**
 * 难度系数: 2星，难点在于空间复杂度O(1)
 * leetcode 9
 * @author stormma
 * @date 2017/10/26
 */
public class Question9 {

    static class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0 || (x != 0 && x % 10 == 0)) {
                return false;
            }
            int rev = 0;
            while (x > rev) {
                rev = rev * 10 + x % 10;
                x /= 10;
            }
            return (x == rev) || (x == rev / 10);
        }
    }

    public static void main(String[] args) {
        new Solution().isPalindrome(121);
    }
}
