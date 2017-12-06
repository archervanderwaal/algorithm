package me.stormma.nowcoder.baidu._2017;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 难度系数: 4星
 * 百度校招笔试题4
 * @author stormma
 * @date 2017/12/05
 */
public class Question4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int[] a = new int[count];
        int[] b = new int[count];
        for (int i = 0; i < count; i++) {
            b[i] = a[i] = in.nextInt();
        }
        Arrays.sort(b);
        int ans = 0, j = 0;
        for (int i = 0; i < count; i++) {
            if (a[i] == b[j]) {
                ans++;
                j++;
            }
            if (j == count) {
                break;
            }
        }
        System.out.println(count - ans);
    }
}
