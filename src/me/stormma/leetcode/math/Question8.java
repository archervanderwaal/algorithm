package me.stormma.leetcode.math;

/**
 * 难度系数: 2星 ==> 很坑爹的题目，输入得靠自己猜
 * leetcode 8
 * @author stormma
 * @date 2017/10/26
 */
public class Question8 {

    class Solution {
        public int myAtoi(String str) {
            if (str == null || str.length() == 0) {
                return 0;
            }
            str = str.trim();
            int start = 0;
            int sign = 1;
            if (str.charAt(0) == '+') {
                start++;
            }
            if (str.charAt(0) == '-') {
                sign = -1;
                start++;
            }
            long sum = 0;
            for (int i = start; i < str.length(); i++) {
                if (!Character.isDigit(str.charAt(i))) {
                    return (int) sum * sign;
                }
                sum = sum * 10 + str.charAt(i) - '0';
                if (sign == 1 && sum > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (sign == -1 && sign * sum < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }
            return (int) sum * sign;
        }
    }
}
