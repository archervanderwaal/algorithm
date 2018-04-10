package me.stormma.leetcode.string;

/**
 * 难度系数: 2星
 * leetcode 38
 * @author stormma
 * @date 2017/11/03
 */
public class Question38 {
    static class Solution {
        public String countAndSay(int n) {
            String str = "1";
            while (--n > 0) {
                int count = 1;
                char[] chars = str.toCharArray();
                StringBuilder temp = new StringBuilder();
                for (int i = 1; i < chars.length; i++) {
                    if (chars[i] == chars[i - 1]) {
                        count++;
                    } else {
                        temp.append(count).append(chars[i - 1]);
                        count = 1;
                    }
                }
                str = temp.append(count).append(chars[chars.length - 1]).toString();
            }
            return str;
        }
    }
}
