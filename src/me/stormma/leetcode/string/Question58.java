package me.stormma.leetcode.string;

/**
 * 难度系数 1星
 * leetcode 58
 * @author stormma
 * @date 2017/11/24
 */
public class Question58 {

    static class Solution {
            public int lengthOfLastWord(String s) {
            int c = 0;
            int i = s.length()-1;

            while(i >= 0 && s.charAt(i) == ' '){
                i--;
            }
            while(i >= 0 && s.charAt(i) != ' '){
                c++;
                i--;
            }
            return c;
        }
    }
}
