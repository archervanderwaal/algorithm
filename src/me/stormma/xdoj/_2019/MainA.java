package me.stormma.xdoj._2019;

import java.util.Scanner;

/**
 * @author stormma stormmaybin@gmail.com
 */
public class MainA {

    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int n = in.nextInt() - 1;
            System.out.println(n * (n + 1) / 2);
        }
    }
}


