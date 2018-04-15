package me.stormma.nowcoder.bytedance._2019;

import java.util.Scanner;

/**
 * @author stormma stormmaybin@gmail.com
 */
public class Question4 {
    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        while (N-- > 0) {
            int k = in.nextInt();
            String[] s = in.nextLine().split(" ");
            int[] array = new int[s.length - 1];
            for (int i = 1; i < s.length; i++) {
                array[i - 1] = Integer.parseInt(s[i]);
            }
            int i = 0, j = array.length - 1;
            for (int t = 0; t < k - 1; t++) {
                if (i < array.length - 1) {
                    double d1 = 1.0 * array[i] / array[j - 1];
                    double next = 1.0 * array[i + 1] / array[array.length - 1];
                    if (d1 < next) {
                        j--;
                    } else {
                        i++;
                        j = array.length - 1;
                    }
                }
            }
            System.out.println(array[i] + " " + array[j]);
        }
    }
}
