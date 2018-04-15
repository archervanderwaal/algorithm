package me.stormma.nowcoder.bytedance._2019;

import java.util.Scanner;

/**
 * @author stormma stormmaybin@gmail.com
 */
public class Question3 {
    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int Q = in.nextInt();
        while (Q-- > 0) {
            int n = in.nextInt(), m = in.nextInt(), x = in.nextInt(), y = in.nextInt(), ans = 0;
            x--; y--;
            for (char c : s.toCharArray()) {
                if (c == 'u') x--;
                if (c == 'd') x++;
                if (c == 'l') y--;
                if (c == 'r') y++;
                ans++;
                if (x >= n || y >= m || x < 0 || y < 0) break;
            }
            System.out.println(ans);
        }
    }
}
