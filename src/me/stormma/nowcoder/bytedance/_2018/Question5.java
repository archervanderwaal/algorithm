package me.stormma.nowcoder.bytedance._2018;

import java.util.Arrays;
import java.util.Scanner;

public class Question5 {
    static class Main {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            while (in.hasNext()) {
                int n = in.nextInt();
                int k = in.nextInt();
                int h = in.nextInt();
                int[] aux = new int[n];
                for (int i = 0; i < n; i++) {
                    aux[i] = in.nextInt();
                }
                Arrays.sort(aux);
                int start = -1, ans = 0, pre = 0;
                while (start + 1 < n && k >= 1) {
                    if (aux[start + 1] - pre <= h) {
                        start++;
                    } else {
                        ans = pre + (aux[start] - pre) * 2;
                        pre = ans;
                        k--;
                    }
                }
                if (k >= 1) {
                    ans = pre + (aux[start] - pre) * 2;
                }
                System.out.println(ans);
            }
        }
    }
}
