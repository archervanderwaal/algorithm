package me.stormma.nowcoder.wangyi._2019;

import java.util.Scanner;

/**
 * @author stormma stormmaybin@gmail.com
 */
public class Question6 {

    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] x1 = new int[n];
        int[] x2 = new int[n];
        int[] y1 = new int[n];
        int[] y2 = new int[n];
        int[] xx = new int[n * 2];
        int[] yy = new int[n * 2];
        for (int i = 0; i < n; i++) {
            x1[i] = in.nextInt();
            xx[i] = x1[i];
        }
        for (int i = 0; i < n; i++) {
            y1[i] = in.nextInt();
            yy[i] = y1[i];
        }
        for (int i = 0; i < n; i++) {
            x2[i] = in.nextInt();
            xx[i + n] = x2[i];
        }
        for (int i = 0; i < n; i++) {
            y2[i] = in.nextInt();
            yy[i + n] = y2[i];
        }
        int ans = 0;
        for (int x : xx) {
            for (int y : yy) {
                int cnt = 0;
                for (int k = 0; k < n; k++) {
                    if (x1[k] <= x && y1[k] <= y && x2[k] > x && y2[k] > y) cnt++;
                }
                ans = Math.max(ans, cnt);
            }
        }
        System.out.println(ans);
    }
}
