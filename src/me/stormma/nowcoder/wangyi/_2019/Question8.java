package me.stormma.nowcoder.wangyi._2019;

import java.util.Scanner;

/**
 * @author stormma stormmaybin@gmail.com
 */
public class Question8 {
    static int ans = 0;
    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), w = in.nextInt();
        int[] v = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            v[i] = in.nextInt();
            sum += v[i];
        }
        if (sum <= w) {
            System.out.println((int) Math.pow(2, n));
        } else {
            dfs(0, 0, v, w);
            System.out.println(ans + 1);
        }
    }

    private static void dfs(long sum, int cur, int[] v, int w) {
        if (cur < v.length) {
            if (sum > w) return;
            dfs(sum, cur + 1, v, w);
            if (sum + v[cur] <= w) {
                ans++;
                dfs(sum + v[cur], cur + 1, v, w);
            }
        }
    }


    // 10 //

    // 9*10/2 = 45 + 1 = 46
    // 1+ 2+ 3+...+9+10;
}
