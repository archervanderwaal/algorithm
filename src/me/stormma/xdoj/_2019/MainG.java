package me.stormma.xdoj._2019;

import java.util.Scanner;

/**
 * @author stormma stormmaybin@gmail.com
 */
public class MainG {
    static final int[][] dd = {
            {-1, 0}, // up
            {0, -1}, // left
            {0, 1}, // right
            {1, 0} // down
    };
    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] map = new int[3][3];
        while (n-- > 0) {
            int z1 = 0, z2 = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    map[i][j] = in.nextInt();
                    if (map[i][j] == 0) {
                        z1 = i;
                        z2 = j;
                    }
                }
            }
            // dfs
            int ans = dfs(map, z1, z2, 0);
            System.out.println(ans == Integer.MAX_VALUE ? "cannot" : ans);
        }
    }

    private static int dfs(int[][] map, int z1, int z2, int ans) {
        if (check(map)) return ans;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            int nextI = dd[i][0] + z1, nextJ = dd[i][1] + z2;
            if (nextI >= 0 && nextI < 3 && nextJ >= 0 && nextJ < 3) {
                if (nextI * 3 + nextJ == map[nextI][nextJ]) continue;
                swap(map, z1, z2, nextI, nextJ);
                int nextAns = dfs(map, nextI, nextJ, ans + 1);
                swap(map, nextI, nextJ, z1, z2);
                res = Math.min(nextAns, res);
            }
        }
        return res;
    }

    private static void swap(int[][] map, int i, int j, int nextI, int nextJ) {
        int temp = map[i][j];
        map[i][j] = map[nextI][nextJ];
        map[nextI][nextJ] = temp;
    }

    private static boolean check(int[][] map) {
        boolean valid = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (map[i][j] != i * 3 + j) {
                    valid = false;
                    break;
                }
            }
        }
        return valid;
    }
}
