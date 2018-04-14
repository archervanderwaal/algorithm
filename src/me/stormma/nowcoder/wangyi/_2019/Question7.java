package me.stormma.nowcoder.wangyi._2019;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author stormma stormmaybin@gmail.com
 */
public class Question7 {
    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[] clocks = new int[t];
        for (int i = 0; i < t; i++) {
            clocks[i] = in.nextInt() * 60 + in.nextInt();
        }
        Arrays.sort(clocks);
        int x = in.nextInt();
        int data = in.nextInt() * 60 + in.nextInt();
        int res = clocks[binary_search(clocks, data - x + 1) - 1];
        System.out.println(res / 60 + " " + res % 60);
    }

    private static int binary_search(int[] clocks, int target) {
        int low = 0, high = clocks.length - 1, mid = (low + high) >>> 1, pos = 0;
        while (low < high) {
            if (clocks[mid] < target) {
                low = mid + 1;
                pos = low;
            } else {
                high = mid;
                pos = high;
            }
            mid = (low + high) >>> 1;
        }
        return pos;
    }
}


