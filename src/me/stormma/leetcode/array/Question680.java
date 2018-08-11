package me.stormma.leetcode.array;


/**
 * 难度系数: 2星
 * leetcode 680
 * @author stormma
 * @date 2017/10/26
 */
public class Question680 {

    class Solution {
        public boolean validPalindrome(String s) {
            int start = 0;
            int end = s.length() - 1;
            boolean flag = false;
            while (start <= end) {
                if (s.charAt(start) == s.charAt(end)) {
                    start++;
                    end--;
                } else {
                    if (!flag) {
                        flag = true;
                        int tempStart = start, tempEnd = end - 1;
                        // remove end
                        while (tempStart < tempEnd) {
                            if (s.charAt(tempStart) != s.charAt(tempEnd)) {
                                break;
                            }
                            tempStart++;
                            tempEnd--;
                            if (tempStart >= tempEnd) {
                                return true;
                            }
                        }
                        // remove start
                        start++;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
