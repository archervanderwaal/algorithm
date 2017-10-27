package me.stormma.leetcode.math;

/**
 * 难度系数: 三星
 * leetcode 43
 * @author stormma
 * @date 2017/10/27
 */
public class Question43 {

    static class Solution {
        public String multiply(String num1, String num2) {
            int len1 = num1.length();
            int len2 = num2.length();
            int[] multi = new int[len1 + len2];
            for (int i = len1 - 1; i >= 0; i--) {
                for (int j = len2 - 1; j >= 0; j--) {
                    int index = len1 + len2 -i - j - 2;
                    multi[index] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                    multi[index + 1] += multi[index] / 10;
                    multi[index] %= 10;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = multi.length - 1; i > 0; i--) {
                if (stringBuilder.length() == 0 && multi[i] == 0) {
                    continue;
                }
                stringBuilder.append(multi[i]);
            }
            stringBuilder.append(multi[0]);
            return stringBuilder.toString();
        }
    }
}
