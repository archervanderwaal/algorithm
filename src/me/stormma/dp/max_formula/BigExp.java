package me.stormma.dp.max_formula;

import java.util.Scanner;

/**
 * 最大算式问题
 * @author stormma
 * @date 2017/6/10.
 */
public class BigExp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int K = in.nextInt();
        //前缀和
        int[] sum = new int[N + 1];
        int[] num = new int[N + 1];

        //dp array, 表示前i个数包含j个乘号的结果
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 0; i < N; i++) {
            num[i] = in.nextInt();
            if (i == 0) {
                sum[i + 1] = num[i];
            } else {
                sum[i + 1] = num[i] + sum[i];
            }
            dp[i][0] = sum[i];
        }

        for (int i = 2; i <= N; i++) { //前2-N个数枚举乘号的个数
            int multi_sign_count = Math.min(i - 1, K); //乘法的个数是i-1但是不能超过乘号的总数K
            for (int j = 1; j <= multi_sign_count; j++) {//枚举乘号的个数，1-multi_sign_count
                for (int l = 2; l <= i; l++) {//最后一个乘号的位置
                    dp[i][j] = Math.max(dp[i][j], dp[l-1][j-1] * (sum[i] - sum[l-1]));//转移方程
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
