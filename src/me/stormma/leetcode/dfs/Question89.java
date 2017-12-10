package me.stormma.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 难度系数: 3星
 * leetcode 89
 * @author stormma
 * @date 2017/12/10
 */
public class Question89 {

    /**
     * dfs+backtracking
     */
    static class Solution1 {
        public List<Integer> grayCode(int n) {
            List<Integer> ans = new ArrayList<>();
            if (n == 0) {
                ans.add(0);
                return ans;
            }
            dfs(n, ans, new ArrayList<>(), false);
            return ans;
        }
        private void dfs(int n, List<Integer> ans, List<Integer> tmp, boolean flag) {
            if (n == 0) {
                StringBuilder sb = new StringBuilder("");
                for (Integer integer : tmp) {
                    sb.append(integer);
                }
                ans.add(Integer.valueOf(sb.toString(), 2));
                return;
            }
            if (!flag) {
                tmp.add(0);
                dfs(n - 1, ans, tmp, false);
                tmp.remove(tmp.size() - 1);
                tmp.add(1);
                dfs(n - 1, ans, tmp, true);
                tmp.remove(tmp.size() - 1);
            } else {
                tmp.add(1);
                dfs(n - 1, ans, tmp, false);
                tmp.remove(tmp.size() - 1);
                tmp.add(0);
                dfs(n - 1, ans, tmp, true);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    static class Solution2 {
        public List<Integer> grayCode(int n) {
            List<Integer> ans = new ArrayList<>();
            ans.add(0);
            for(int i = 0; i < n; i++){
                int size = ans.size();
                for(int k = size - 1; k >= 0; k--) {
                    // System.out.println(ans.get(k) + " | " + 1 + " << " + i + " = " + (ans.get(k) | 1 << i));
                    ans.add(ans.get(k) | 1 << i);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().grayCode(3));
    }
}
