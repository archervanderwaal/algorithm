package me.stormma.leetcode.string;

/**
 * 难度系数: 2星
 * leetcode 28
 * @author stormma
 * @date 2017/11/03
 */
public class Question28 {

    static class Solution {
        public int strStr(String haystack, String needle) {
            if (needle.length() == 0 || haystack.equals(needle)) {
                return 0;
            }
            if (haystack.length() <= needle.length()) {
                return -1;
            }
            int low = 0, high = haystack.indexOf(needle.charAt(0)), mark = high;
            while (high != -1 && high < haystack.length() && low < needle.length()) {
                if (needle.charAt(low) == haystack.charAt(high)) {
                    low++;
                    high++;
                } else {
                    low = 0;
                    high = haystack.substring(mark + 1).indexOf(needle.charAt(low)) + mark + 1;
                    if (high == mark) {
                        break;
                    }
                    mark = high;
                }
            }
            return low == needle.length() ? (high - needle.length()) : -1;
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution().strStr("mississippi", "sippj"));
    }
}
