package me.stormma.leetcode.math;

/**
 * 难度系数: 2星
 * leetcode 67
 * @author stormma
 * @date 2017/10/27
 */
public class Question67 {
    static class Solution1 {
        public String addBinary(String a, String b) {
            int len1 = a.length();
            int len2 = b.length();
            int maxLen = Math.max(len1, len2);
            if (len1 < maxLen) {
                int count = maxLen - len1;
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i <= count; i++) {
                    sb.append("0");
                }
                a = sb.toString() + a;
            }
            if (len2 < maxLen) {
                int count = maxLen - len2;
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i <= count; i++) {
                    sb.append("0");
                }
                b = sb.toString() + b;
            }

            int carry = 0;
            StringBuilder result = new StringBuilder();
            for (int i = maxLen - 1; i >= 0; i--) {
                int sum = (a.charAt(i) - '0') + (b.charAt(i) - '0') + carry;
                result.append(sum >= 2 ? sum - 2: sum);
                carry = (sum >= 2) ? 1: 0;
            }
            if (carry != 0) {
                result.append(carry);
            }
            return result.reverse().toString();
        }
    }


    static class Solution2 {
        public String addBinary(String a, String b) {
            int i = a.length() - 1, j = b.length() - 1, carry = 0;
            StringBuilder result = new StringBuilder();
            while (i >= 0 || j >= 0) {
                int sum = carry;
                if (i >= 0) {
                    sum += a.charAt(i--) - '0';
                }
                if (j >= 0) {
                    sum += b.charAt(j--) - '0';
                }
                result.append(sum % 2);
                carry = sum / 2;
            }
            if (carry != 0) {
                result.append(carry);
            }
            return result.reverse().toString();
        }
    }
}
