package me.stormma.others;

import java.util.*;

public class DuoMiRuoGuPai {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            List<Integer> id = new ArrayList<>();
            int[] x = new int[n + 1];
            int[] h = new int[n + 1];
            int[] ans = new int[n + 1];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < n; i++) {
                x[i] = in.nextInt();
                h[i] = in.nextInt();
                id.add(i);
            }
            x[n] = 0x7fffffff;
            Collections.sort(id, (i1, i2) -> {
                return x[i1] - x[i2];
            });
            id.add(n);
            stack.push(0);
            for (int i = 1; i <= n; i++) {
                while (!stack.isEmpty() && (x[id.get(stack.peek())] + h[id.get(stack.peek())] - 1) < x[id.get(i)]) {
                    // 无法碰到
                    int j = stack.pop();
                    ans[id.get(j)] = i - j;
                }
                stack.push(i);
            }

            for (int i = 0; i < n; i++) {
                if (i != 0) {
                    System.out.print(" ");
                }
                System.out.print(ans[i]);
            }
            System.out.println();
        }
    }
}
