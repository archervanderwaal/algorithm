package me.stormma.nowcoder.wangyi._2019;

import java.util.Scanner;

/**
 * @author stormma stormmaybin@gmail.com
 */
public class Question5 {

    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt();
        int ans = 0;
        if (k == 0) {
            ans = n * n;
        } else {
            for (int y = k + 1; y <= n; y++) {
                ans += n / y * (y - k) + (n % y >= k ? n % y - k + 1 : 0);
            }
        }
        System.out.println(ans);
    }
}
