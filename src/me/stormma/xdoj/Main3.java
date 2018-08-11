package me.stormma.xdoj;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String string1 = in.next();
            String string2 = in.next();
            String string3 = in.next();
            string1 = string1.substring(1, string1.length() - 1);
            string2 = string2.substring(0, string2.length() - 1);
            string3 = string3.substring(0, string3.length() - 1);
            String R = Integer.toHexString(Integer.parseInt(string1)).toUpperCase();
            String G = Integer.toHexString(Integer.parseInt(string2)).toUpperCase();
            String B = Integer.toHexString(Integer.parseInt(string3)).toUpperCase();
            System.out.println(String.format("#%s%s%s", (R.length() == 1 ? ("0" + R) : R), (G.length() == 1 ? ("0" + G) : G),
                    (B.length() == 1 ? ("0" + B) : B)));
        }
    }
}
