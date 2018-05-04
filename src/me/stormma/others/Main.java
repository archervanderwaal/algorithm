package me.stormma.others;

import java.util.Scanner;

/**
 * @author stormma stormmaybin@gmail.com
 */
public class Main {

    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n-- > 0) {
            long x = in.nextLong();
            if (x > 100) {
                System.out.println(x - 10);
            } else { // x <= 100
                // f(100) = f(f(111)) = f(101) = 91
                // f(99) = f(f(110)) = f(100) = 91
                // f(98) = f(f(109)) = f(99) = 91
                // f(1) = f(f(12)) = f(f(f(12+11)))
                // f 100 + 11 = 111 = f(f(111)) = f(101)
                // f 99 + 11 = 110 = f(f(110)) = f(100)
                // f(x) = f(f(x+11)) =>
                // f(90) = f(f(90 + 11)) = f(f(101)) = f(91) = f(f(91 + 11)) = f(f(102)) = f(f(92))

                // f(80) = f(f(91)) =
                System.out.println(91);
            }
        }
    }
}
