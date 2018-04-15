package me.stormma.nowcoder.bytedance._2019;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author stormma stormmaybin@gmail.com
 */
public class Question2 {
    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt(), n2 = in.nextInt(), m = in.nextInt();
        int[] n1s = new int[n1];
        for (int i = 0; i < n1; i++) {
            n1s[i] = in.nextInt();
        }
        int[] n2s = new int[n2];
        for (int i = 0; i < n2; i++) {
            n2s[i] = in.nextInt();
        }
        //dp[i] 表示组成
        int[] dp1 = new int[m + 1]; // 表示第一种硬币组成面值为i的组合数
        int[] dp2 = new int[m + 1]; //表示第二种硬币组成面值为i的组合数
        dp1[0] = dp2[0] = 0;
        dp1[1] = n1s[0] == 1 ? 1 : 0;
        for (int i = 2; i <= m; i++) {
            dp1[i] = binarySearch(n1s, i) == -1 ? 0 : 1;
            for (int j = 1; j <= i / 2; j++) {
                int cnt = dp1[j] * dp1[i - j];
                dp1[i] += cnt % 1000000007;
            }
            dp1[i] %= 1000000007;
        }
        System.out.println(Arrays.toString(dp1));
    }

    private static int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (array[mid] < target) {
                left = mid + 1;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
