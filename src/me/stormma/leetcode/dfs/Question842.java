package me.stormma.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Split Array into Fibonacci Sequence
 * @author stormma stormmaybin@gmail.com
 */
public class Question842 {

    static class Solution {
        public List<Integer> splitIntoFibonacci(String S) {
            List<Integer> ans = new ArrayList<>();
            if (S == null || S.length() == 0) return ans;
            dfs(ans, S, 0);
            return ans;
        }

        private boolean dfs(List<Integer> ans, String s, int start) {
            if (start == s.length() && ans.size() >= 3) {
                return true;
            }
            for (int i = start; i < s.length(); i++) {
                // 如果start位置是0, 则这个数字只能是0, 如果这个数字是一个前导0并且位数>1是非法的
                if ((s.charAt(start) == '0' && i > start) || (i - start > 9)) return false;
                long current = Long.parseLong(s.substring(start, i + 1));
                if (current > Integer.MAX_VALUE) return false;
                // 判断是不是满足结果
                if (ans.size() < 2 || (current == ans.get(ans.size() - 1) + ans.get(ans.size() - 2))) {
                    ans.add((int) current);
                    if (dfs(ans, s, i + 1)) {
                        return true;
                    }
                    ans.remove(ans.size() - 1);
                }
            }
            return false;
        }
    }
}
