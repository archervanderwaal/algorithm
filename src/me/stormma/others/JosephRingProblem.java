package me.stormma.others;

import java.util.LinkedList;
import java.util.List;
/**
 * @author stormma stormmaybin@gmail.com
 * @berif 约瑟夫环问题: n个数字: 0 -> n-1
 * 删除第m个，接下来从m + 1重新开始编号，接着删除第m个，求出最后剩下的那个
 */
public class JosephRingProblem {

    private static int solve1(int n, int m) {
        if (n < 1 || m < 1) return -1;
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() > 1) {
            for (int i = 1; i < m; i++) {
                index++;
                if (index == list.size()) {
                    index = 0;
                }
            }
            int next = index + 1 == list.size() ? 0 : index;
            list.remove(index);
            index = next;
        }
        return list.get(0);
    }

    private static int solve2(int n, int m) {
        // f(n, m) = [f(n - 1, m) + m] % n
        int res = 0;
        // f(1, m) = 0;
        for (int i = 2; i <= n; i++) {
            res = (res + m) % i;
        }
        return res;
    }

    public static void main(String... args) {
        long start = System.currentTimeMillis();
        long mid;
        System.out.println(solve1(1000000, 3) + " " + (mid = System.currentTimeMillis() - start) + "ms");
        System.out.println(solve2(1000000, 3) + " " + (System.currentTimeMillis() - mid) + "ms");
    }
}
