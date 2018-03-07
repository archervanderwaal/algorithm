package me.stormma.others;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Combinations问题
 * @author stormma
 * @date 2017/11/30
 */
public class Combinations {

    /**
     * <p>Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.</p>
     *
     * <em>Example 1</em>
     *
     * if n = 4 and k = 2
     *
     * <code>
     *       [2,4],
     *       [3,4],
     *       [2,3],
     *       [1,2],
     *       [1,3],
     *       [1,4]
     * </code>
     */
    static class Question1 {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> ans = new ArrayList<>();
            dfs(k, n, 1, ans, new LinkedList<>());
            return ans;
        }

        /**
         * @param k 表示从start开始取k个数的组合
         * @param n
         * @param start
         * @param ans
         * @param current 临时的结果
         */
        private void dfs(int k, int n, int start, List<List<Integer>> ans, List<Integer> current) {
            if (k == 0) {
                ans.add(new ArrayList<>(current));
                return;
            }

            // start, k , m

            // 0, 1, 7
            // 1, 0, 6
            // 1, 1, 7
            // 2, 0, 5

            // 1 2 3 4 5 6 7   m = 7
            //

            for (int i = start; i <= n; i++) {
                current.add(i);
                dfs(k - 1, n, i + 1, ans, current);
                ((LinkedList) current).pollLast();
            }
        }

        public static void main(String[] args) {
            System.out.println(new Question1().combine(4, 2));
        }
    }
}
