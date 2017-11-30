package me.stormma.xdoj;

import java.util.Scanner;

public class Main5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String string = in.next();

        int p1 = 0, p2 = 0, p3 = 0;

        int ans = 0;

        p1 = string.indexOf('Q');
        while (p1 != -1) {
            p2 = string.indexOf('A');
            while (p2 != -1) {
                ans += search(p1, p2, string);
                p2 = string.indexOf('A', p2 + 1);
            }
            p1 = string.indexOf('Q', p1 + 1);
        }
        System.out.println(ans);
    }

    private static int search(int p1, int p2, String string) {
        int ans = 0;
        int p3 = string.indexOf('Q', p2 + 1);
        while (p3 != -1) {
            if (p3 >= p2 && p2 >= p1) {
                ans++;
            }
            p3 = string.indexOf('Q', p3 + 1);
        }
        return ans;
    }
}
