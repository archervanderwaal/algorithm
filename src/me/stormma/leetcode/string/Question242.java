package me.stormma.leetcode.string;

import java.util.Arrays;

/**
 * 难度系数:1 星
 * leetcode 242
 * @author stormma
 * @date 2017/11/30
 */
public class Question242 {

    static class Solution1 {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            char[] sArray = s.toCharArray();
            char[] tArray = t.toCharArray();
            Arrays.sort(sArray);
            Arrays.sort(tArray);
            for (int i = 0; i < sArray.length; i++) {
                if (sArray[i] != tArray[i]) {
                    return false;
                }
            }
            return true;
        }
    }

    static class Solution2 {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            int[] count = new int[128];
            for (char c : s.toCharArray()) {
                count[c]++;
            }
            for (char c : t.toCharArray()) {
                count[c]--;
                if (count[c] < 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
