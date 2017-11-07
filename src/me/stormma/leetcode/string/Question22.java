package me.stormma.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class Question22 {

    static class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList<>();
            dfs(0, 0, "", ans, n);
            return ans;
        }
        private void dfs(int left, int right, String temp, List<String> ans, int n) {
            // ((()))
            if (right == n) {
                ans.add(temp);
                return;
            }

            if (left < n) {
                dfs(left + 1, right, temp + "(", ans, n);
            }
            if (right < left) {
                dfs(left, right + 1, temp + ")", ans, n);
            }

        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }
}
