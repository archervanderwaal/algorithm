package me.stormma.leetcode.string;

/**
 * 难度系数: 3星
 * leetcode 6
 * @author stormma
 * @date 2017/11/05
 */
public class Question6 {

    static class Solution {
        public String convert(String s, int numRows) {
            if (numRows <= 1 || s.length() <= numRows) {
                return s;
            }
            StringBuilder[] ans = new StringBuilder[numRows];
            for (int i = 0; i < numRows; i++) {
                ans[i] = new StringBuilder("");
            }
            int index = 0;
            boolean inc = true;
            for (int i = 0; i < s.length(); i++) {
                ans[index].append(s.charAt(i));
                if (index == 0) {
                    inc = true;
                }
                if (index == numRows - 1) {
                    inc = false;
                }
                if (inc) {
                    index++;
                } else {
                    index--;
                }
            }
            for (int i = 1; i < ans.length; i++) {
                ans[0].append(ans[i].toString());
            }
            return ans[0].toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convert("PAYPALISHIRING", 3));
    }
}
