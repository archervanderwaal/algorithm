package me.stormma.nowcoder.bytedance._2019;

import java.util.Scanner;

/**
 * @author stormma stormmaybin@gmail.com
 */
public class Question1 {

    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int n = in.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = in.nextInt();
            }
            int ans = 1;
            while (true) {
                boolean valid = true;
                for (int i = 0; i < array.length; i++) {
                    if (array[i] + ans <= array[array.length - 1] && binarySearch(array, array[i] + ans) == -1) {
                        valid = false;
                    }
                    if (array[i] - ans >= array[0] && binarySearch(array, array[i] - ans) == -1) {
                        valid = false;
                    }
                }
                if (valid) break;
                ans++;
            }
            System.out.println(ans);
        }
    }

    private static int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (target > array[mid]) {
                left = mid + 1;
            } else if (target < array[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
