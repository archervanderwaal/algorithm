package me.stormma.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 难度系数: 3星
 * leetcode 17
 * @author stormma
 * @date 2017/11/06
 */
public class Question17 {

    static class Solution {
        public List<String> letterCombinations(String digits) {
            String[] hs = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            List<String> ans = new ArrayList<>();
            if (digits.isEmpty()) {
                return ans;
            }
            dfs(digits, 0, new StringBuilder(), ans, hs);
            return ans;
        }

        private void dfs(String digits, int index, StringBuilder temp, List<String> ans, String[] hs) {
            if (temp.length() == digits.length()) {
                ans.add(temp.toString());
                return;
            }

            for (Character character : hs[digits.charAt(index) - '0'].toCharArray()) {
                temp.append(character);
                dfs(digits, index + 1, temp, ans, hs);
                // remove the last element of temp
                temp.replace(temp.length() - 1, temp.length(), "");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
    }
}
