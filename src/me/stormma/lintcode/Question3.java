package me.stormma.lintcode;

/**
 * lintcode 3.
 * @author stormma
 * @date 2018/03/26
 */
public class Question3 {
    static class Solution {
        /*
         * @param : An integer
         * @param : An integer
         * @return: An integer denote the count of digit k in 1..n
         */
        public int digitCounts(int k, int n) {
            // write your code here
            int ans = 0;
            for (int i = 0; i <= n; i++) {
                int j = i;
                if (j % 10 == k) ans++;
                j /= 10;
                while (j > 0) {
                    if (j % 10 == k) ans++;
                    j /= 10;
                }
            }
            return ans;
        }
    };
}
