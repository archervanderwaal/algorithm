package me.stormma.xdoj;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        for (int i = 1; i <= count; i++) {
            System.out.println(in.nextInt() - 1);
        }
    }
}
