package me.stormma.leetcode.string;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/**
 * @author archer archer.vanderwaal@gmail.com
 */
public class Question387 {

    /**
     * use hash map
     */
    class Solution1 {
        public int firstUniqChar(String s) {
            if (s == null || s.length() == 0) return -1;
            Map<Character, Integer> map = new HashMap<>();
            for (char c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            for (int i = 0; i < s.length(); i++) {
                if (map.get(s.charAt(i)) == 1) {
                    return i;
                }
            }
            return -1;
        }
    }

    class Solution2 {
        public int firstUniqChar(String s) {
            if (s == null || s.length() == 0) return -1;
            int[] map = new int[26];
            for (char c : s.toCharArray()) {
                map[c - 'a']++;
            }
            for (int i = 0; i < s.length(); i++) {
                if (map[s.charAt(i) - 'a'] == 1) {
                    return i;
                }
            }
            return -1;
        }
    }

    /**
     * use string search
     */
    class Solution3 {
        public int firstUniqChar(String s) {
            if (s == null || s.length() == 0) return -1;
            int min = s.length();
            for (char c = 'a'; c <= 'z'; c++) {
                int ind;
                if ((ind = s.indexOf(c)) != - 1 && s.lastIndexOf(c) == ind) {
                    min = Math.min(min, ind);
                }
            }
            return min == s.length() ? -1 : min;
        }
    }
}
