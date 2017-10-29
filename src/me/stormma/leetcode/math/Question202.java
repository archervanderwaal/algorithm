package me.stormma.leetcode.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 难度系数: 2星
 * leetcode 202
 * @author stormma
 * @date 2017/10/27
 */
public class Question202 {

    static class Solution {
        public boolean isHappy(int n) {
            if (n == 1) {
                return true;
            }
            List<Integer> memo = new ArrayList<>();
            while (!memo.contains(n)) {
                memo.add(n);
                String number = n + "";
                n = 0;
                for (int i = 0; i < number.length(); i++) {
                    n += (int) Math.pow(number.charAt(i) - '0', 2);
                }
            }
            return n == 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isHappy(10));
    }
}
