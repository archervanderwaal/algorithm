package me.stormma.others;

import java.util.Scanner;

/**
 * 三角形问题，给定一组从小到大的数组，问组成三角形最大周长是多少，如果没有可以组成三角形的，输出'NO';
 *
 * @author stormma
 * @date 2017/10/21
 */
public class Triangle {

    static class Solution {
        private static int solve(int[] elements) {
            for (int i = elements.length - 1; i > 1; i--) {
                if (elements[i - 1] + elements[i - 2] > elements[i]) {
                    return elements[i - 2] + elements[i - 1] + elements[i];
                }
            }
            return -1;
        }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int count = in.nextInt();
            int[] elements = new int[count];
            for (int i = 0; i < count; i++) {
                elements[i] = in.nextInt();
            }
            int ans = solve(elements);
            if (ans != -1) {
                System.out.println(ans);
            } else {
                System.out.println("NO");
            }
        }
    }
}
