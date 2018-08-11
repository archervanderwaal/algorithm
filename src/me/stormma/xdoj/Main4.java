package me.stormma.xdoj;

import java.util.*;

public class Main4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        for (int i = 1; i <= count; i++) {
            int a = in.nextInt(), b = in.nextInt(), c = in.nextInt(), n = in.nextInt(), k = in.nextInt();
            int num = 0;
            boolean start = true;
            int init = a;
            List<Integer> integers = new ArrayList<>();
            for (;;) {
                if (!start && a == init) {
                    break;
                }
                num++;
                a = (a * b + c) % 1001;
                integers.add(a);
                start = false;
            }
            Collections.sort(integers);
            int x = n / num;
            if (x != 0) {
                k /= x;
            }
            int ind = (n - k) % num;
            System.out.println(integers.get(ind));
            //59 - 31 + 1 = 29 * 2 = 58;
        }
    }
}