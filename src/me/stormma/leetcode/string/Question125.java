package me.stormma.leetcode.string;

/**
 * 难度系数: 2星
 * leetcode 125
 * @author stormma
 * @date 2017/12/16
 */
public class Question125 {
    static class Solution {
        public boolean isPalindrome(String s) {
            int low = 0, high = s.length() - 1;
            while (low <= high) {
                char lowC = getChar(s, low), highC = getChar(s, high);
                if (lowC != 0 && highC != 0) {
                    if (lowC == highC) {
                        low++;
                        high--;
                    } else {
                        return false;
                    }
                }
                if (lowC == 0) low++;
                if (highC == 0) high--;
            }
            return true;
        }

        private char getChar(String s, int index) {
            char character = s.charAt(index);
            if ((character >= 'a' && character <= 'z') || (character >= '0' && character <= '9')) {
                return character;
            }
            if (character >= 'A' && character <= 'Z') {
                return (char) (character + 32);
            } else {
                return 0;
            }
        }
    }


    public static void main(String[] args) {
        System.out.print(new Solution().isPalindrome("0P"));
    }
}
