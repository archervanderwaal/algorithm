package me.stormma.leetcode.dp;

import java.io.IOException;

/**
 * 难度系数: 2星
 * leetcode 3
 * @author stormma
 * @date 2017/10/28
 */
public class Question3 {

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            int[] dp = new int[s.length()];
            dp[0] = 1;
            int max = dp[0];
            for (int i = 1; i < s.length(); i++) {
                if (s.substring(i - dp[i - 1], i).indexOf(s.charAt(i)) == -1) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = Math.max(i - (s.substring(i - dp[i - 1], i).indexOf(s.charAt(i)) + i - dp[i - 1]), 1);
                }
                max = Math.max(dp[i], max);
            }
            return max;
        }

        public static void main(String[] args) throws IOException {
            //System.out.println(new Solution().lengthOfLongestSubstring("abcabcabcbb"));
            int x = 1;
            for (int i = 1; i <= 50; i++) {
                x = (x + 15) % 50;
                System.out.println(x);
            }
        }
    }
}
