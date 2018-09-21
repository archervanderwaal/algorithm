package me.stormma.leetcode.string;

/**
 * @author archer archer.vanderwaal@gmail.com
 */
public class Question557 {

    static class Solution {
        public String reverseWords(String s) {
            char[] ss = s.toCharArray();
            int currI = 0;
            int spaceI = s.indexOf(' ', currI);
            while (spaceI != -1) {
                reverse(ss, currI, spaceI-1);
                currI = spaceI + 1;
                spaceI = s.indexOf(' ', currI);
            }
            reverse(ss, currI, s.length() - 1);
            return new String(ss);
        }

        private void reverse(char[] ss, int start, int end) {
            while (start < end) {
                char t = ss[start];
                ss[start++] = ss[end];
                ss[end--] = t;
            }
        }
    }
}
