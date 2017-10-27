package me.stormma.leetcode.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 难度系数: 2星
 * leetcode 13
 * @author stormma
 * @date 2017/10/27
 */
public class Question13 {

    static class Solution {
        public int romanToInt(String s) {
            Map<Character, Integer> romans = new HashMap<>();
            romans.put('M', 1000);
            romans.put('D', 500);
            romans.put('C', 100);
            romans.put('L', 50);
            romans.put('X', 10);
            romans.put('V', 5);
            romans.put('I', 1);
            int sum = 0;
            for (int i = 0; i < s.length() - 1; i++) {
                if (romans.get(s.charAt(i)) < romans.get(s.charAt(i + 1))) {
                    sum -= romans.get(s.charAt(i));
                } else {
                    sum += romans.get(s.charAt(i));
                }
            }
            return sum + romans.get(s.charAt(s.length() - 1));
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("IX"));
    }
}
