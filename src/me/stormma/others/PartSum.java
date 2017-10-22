package me.stormma.others;

import java.util.Scanner;

/**
 * 题目：求部分和问题
 *      给定整数a1，a2，… ，an，判断是否可以从中选出若干个数字，试他们的和恰好为k。
 *      其中：1 <= n <= 20，-10^8 <= ai <= 10^8，-10^8 <= k <= 10^8
 *      <em>输入:</em>
 *          n=4
 *          a={1,2, 4, 7}
 *          k=13
 *      <em>输出:</em>
 *          Yes（13= 2 + 4 + 7）
 * @author stormma
 * @date 2017/10/21
 */
public class PartSum {

    static class Solution {

        /**
         * 前i项是否可以选若干数，其和==sum
         * @param i
         * @param sum
         * @param numbers
         * @return
         */
        private static boolean dfs(int i, int sum, int[] numbers) {
            if (i == 0) {
                return sum == 0;
            }
            // 加上numbers[i-1]这个位置的数
            if (dfs(i - 1, sum - numbers[i - 1], numbers)) {
                return true;
            }
            // 不加numbers[i-1]这个位置的数
            if (dfs(i - 1, sum, numbers)) {
                return true;
            }
            return false;
        }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int count = in.nextInt();
            int[] numbers = new int[count];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = in.nextInt();
            }
            int sum = in.nextInt();
            System.out.println(dfs(numbers.length, sum, numbers) ? "Yes" : "No");
        }
    }
}
