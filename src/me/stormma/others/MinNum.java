package me.stormma.others;

import java.util.Scanner;

public class MinNum {
    private static int tmp[] = new int[1000], cnt, rec[] = new int[1000];
    private static int[] prime = {0, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 39, 41, 43, 47};
    private static double ans, log[] = new double[30];

    private static void dfs(int pos, int val, int MAX, double clog) {
        if (clog > ans) return;
        if (val == 1) {
            cnt = pos;
            ans = clog;
            for (int i = 1; i < pos; i++)
                rec[i] = tmp[i];
            return;
        }

        for (int i = 1; i * i <= val && i <= MAX; i++) {
            if (val % i == 0) {
                if (i != 1) {
                    tmp[pos] = i;
                    dfs(pos+1, val/i, i, clog + log[pos] * (i-1));
                }
                if (val / i <= MAX && val / i != i) {
                    tmp[pos] = val/i;
                    dfs(pos+1, i, val/i, clog + log[pos] * (val / i - 1));
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 16; i++) {
            log[i] = Math.log((double)prime[i]);
        }
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ans = 0x3f3f3f3f;
        dfs(1, n, n, 0);
        long M = 1;
        for (int i = 1; i < cnt; i++) {
            for (int j = 1; j < rec[i]; j++) {
                M *= prime[i];
            }
        }
        System.out.println(M);
    }
}
