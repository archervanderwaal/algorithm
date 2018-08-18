package me.stormma.others;

import java.util.*;

public class Main {

    private static int max = 0;

    private static int tmp = 0;

    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        String line1 = in.nextLine();
        int m = Integer.parseInt(line1.split(",")[0]), n = Integer.parseInt(line1.split(",")[1]);
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            String dump = in.nextLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(dump.split(",")[j]);
            }
        }
        int ans = 0;
        boolean[][] mark = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    dfs(map, i, j, m, n);
                    max = Math.max(max, tmp);
                    tmp = 0;
                    ans++;
                }
            }
        }
        System.out.println(ans + "," + max);
    }

    private static void dfs(int[][] map, int i, int j, int m, int n) {
        if (i < 0 || i > m - 1 || j < 0 || j > n - 1 || map[i][j] == 0) return;
        // 上下左右斜上斜下
        tmp++;
        // 上
        dfs(map, i - 1, j, m, n);
        // 下
        dfs(map, i + 1, j, m, n);
        // 左
        dfs(map, i, j - 1, m, n);
        // 右
        dfs(map, i, j + 1, m, n);
        // 斜左上
        dfs(map, i - 1, j - 1, m, n);
        // 斜右下
        dfs(map, i + 1, j + 1, m, n);
        // 斜右上
        dfs(map, i - 1, j + 1, m, n);
        // 斜左下
        dfs(map, i + 1, j - 1, m, n);
    }
}