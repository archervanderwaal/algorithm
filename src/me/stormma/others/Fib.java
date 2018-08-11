package me.stormma.others;

/**
 * 斐波那契数列的记忆化搜索
 *
 * @author stormma
 * @date 2017/10/21
 */
public class Fib {

    static class Solution {

        private static int fib(int n) {
            if (n <= 1) {
                return n;
            }
            return fib(n - 1) + fib(n - 2);
        }

        public static void main(String[] args) {
            int n = 40;
            long startTime = System.currentTimeMillis();
            int result = fib(n);
            // 563
            System.out.println(System.currentTimeMillis() - startTime);
            // 102334155
            System.out.println(result);
        }
    }

    static class Solution1 {

        private static int[] memo = new int[1000];
        private static int fib(int n) {
            if (n <= 1) {
                return n;
            }
            if (memo[n] != 0) {
                return memo[n];
            }
            return memo[n] = fib(n - 1) + fib(n - 2);
        }

        public static void main(String[] args) {
            int n = 40;
            long startTime = System.currentTimeMillis();
            int result = fib(n);
            // 0
            System.out.println(System.currentTimeMillis() - startTime);
            // 102334155
            System.out.println(result);
        }
    }
}
