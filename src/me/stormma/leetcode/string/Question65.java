package me.stormma.leetcode.string;

/**
 * 难度系数: 二星
 * leetcode 65. Valid Number
 * @author stormma
 * @date 2018/03/25
 */
public class Question65 {
    static class Solution {
        public boolean isNumber(String s) {
            if (s == null || s.length() == 0) return false;
            s = s.trim();
            boolean numberSeen = false, pointSeen = false, eSeen = false, numberAfterE = true;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    numberSeen = true;
                    numberAfterE = true;
                } else if (s.charAt(i) == '.') {
                    if (eSeen || pointSeen) return false;
                    pointSeen = true;
                } else if (s.charAt(i) == 'e') {
                    if (eSeen || !numberSeen) return false;
                    eSeen = true;
                    numberAfterE = false;
                } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                    if (i != 0 && s.charAt(i - 1) != 'e') return false;
                } else {
                    return false;
                }
            }
            return numberSeen && numberAfterE;
        }
    }
}
