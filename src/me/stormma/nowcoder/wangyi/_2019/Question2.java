package me.stormma.nowcoder.wangyi._2019;

import java.util.Scanner;

/**
 * @author stormma stormmaybin@gmail.com
 */
public class Question2 {

    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        long l = in.nextLong(), r = in.nextLong();
        System.out.println(f(r) - f(l - 1));
    }

    public static long f(long x) {
        return x / 3 * 2 + (x % 3 == 0 ? 0 : x % 3 == 1 ? 0 : 1);
    }
}
