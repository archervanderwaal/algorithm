package me.stormma.leetcode.array;

import java.util.*;

/**
 * 难度系数: 三星
 * leetcode 120. Triangle
 * @author stormma
 * @date 2018/03/24
 */
public class Question120 {
    /**
     *                  -1    0
     *                 2  3   1
     *                1 -1 -3 2
     *
     *                -1
     *               1  0
     */
    static class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            if (triangle == null || triangle.size() == 0) return 0;
            int n = triangle.size();
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                dp[i] = triangle.get(n - 1).get(i);
            }
            for (int i = n - 2; i >= 0; i--) {
                for (int j = 0; j <= i; j++) {
                    int num = triangle.get(i).get(j);
                    num += Math.min(dp[j], dp[j + 1]);
                    dp[j] = num;
                }
            }
            return dp[0];
        }
    }

    /**
     * Submission result: Time Limit Exceeded
     */
    static class Solution2 {
        public int minimumTotal(List<List<Integer>> triangle) {
            if (triangle == null || triangle.size() == 0) return 0;
            return dfs(triangle, 1, 0);
        }

        private int dfs(List<List<Integer>> triangle, int row, int startIndex) {
            if (row > triangle.size()) return 0;
            return Math.min(triangle.get(row - 1).get(startIndex)
                            + dfs(triangle, row + 1, startIndex)
                    , triangle.get(row - 1).get(startIndex)
                            + dfs(triangle, row + 1, startIndex + 1));
        }
    }

    /**

     * @param args
     */
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Collections.singletonList(-1));
        triangle.add(Arrays.asList(2, 3));
        triangle.add(Arrays.asList(1, -1, -3));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(new Solution().minimumTotal(triangle));
        System.out.println(triangle);
    }
}
