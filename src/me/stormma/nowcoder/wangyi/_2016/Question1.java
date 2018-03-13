package me.stormma.nowcoder.wangyi._2016;

import java.util.Scanner;

/**
 * 网易
 *
 * 题目描述
 有 n 个学生站成一排，每个学生有一个能力值，牛牛想从这 n 个学生中按照顺序选取 k 名学生，要求相邻两个学生的位置编号的差不超过 d，使得这 k 个学生的能力值的乘积最大，你能返回最大的乘积吗？
 输入描述:
 每个输入包含 1 个测试用例。每个测试数据的第一行包含一个整数 n (1 <= n <= 50)，表示学生的个数，接下来的一行，包含 n 个整数，按顺序表示每个学生的能力值 ai（-50 <= ai <= 50）。接下来的一行包含两个整数，k 和 d (1 <= k <= 10, 1 <= d <= 50)。
 输出描述:
 输出一行表示最大的乘积。
 示例1
 输入
 3
 7 4 7
 2 50
 输出
 49
 *
 * @author stormma
 * @date 2018/03/13
 */
public class Question1 {

    public static class Main {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            long[] stus = new long[n];
            for (int i = 0; i < n; i++) {
                stus[i] = in.nextInt();
            }
            int k = in.nextInt();
            int d = in.nextInt();

            //dp1[i][j]表示选择j个人，最后一个人编号是i的最大乘积
            //dp2[i][j]表示选择j个人，最后一个人编号是i的最小乘积
            long[][] dp1 = new long[n][k + 1];
            long[][] dp2 = new long[n][k + 1];
            for (int i = 0; i < n; i++) {
                dp1[i][1] = dp2[i][1] = stus[i];
            }
            long ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= k; j++) {
                    for (int t = i - 1; t >= Math.max(i - d, 0); t--) {
                        //dp[i][j]由dp[i t = i - d -> i - 1][j - 1] * stus[i]转移得到
                        dp1[i][j] = Math.max(dp1[i][j], Math.max(dp1[t][j - 1] * stus[i], dp2[t][j - 1] * stus[i]));
                        dp2[i][j] = Math.min(dp2[i][j], Math.min(dp2[t][j - 1] * stus[i], dp1[t][j - 1] * stus[i]));
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, dp1[i][k]);
            }
            System.out.println(ans);
        }
    }
}
