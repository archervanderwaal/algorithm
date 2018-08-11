package me.stormma.nowcoder.wangyi._2017;

import java.util.Scanner;

/**
 * @author stormma stormmaybin@gmail.com
 */
public class Question1 {

    public static class Main {
        public static void main(String... args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int[] num = new int[n];
            for (int i = 0; i < n; i++) {
                num[i] = in.nextInt();
            }
            int low = 0, high = n - 1, ans = 0;
            int lowVal = num[low], highVal = num[high];
            while (low < high) {
                if (lowVal < highVal) {
                    low++;
                    lowVal += num[low];
                    ans++;
                } else if (lowVal > highVal) {
                    high--;
                    highVal += num[high];
                    ans++;
                } else if (lowVal == highVal) {
                    low++;
                    high--;
                    lowVal = num[low];
                    highVal = num[high];
                }
            }
            System.out.println(ans);
        }
    }
}
