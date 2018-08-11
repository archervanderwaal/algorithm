package me.stormma.others;

/**
 * 最长公共子序列
 * @author stormma
 * @date 2018/03/27
 */
public class LCS {

    public static String lcs(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        int[][] s = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    s[i][j] = 1;
                } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                    dp[i][j] = dp[i - 1][j];
                    s[i][j] = 2;
                } else {
                    dp[i][j] = dp[i][j - 1];
                    s[i][j] = 3;
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        clcs(dp.length - 1, dp[0].length - 1, a, b, ans, s);
        return ans.toString();
    }

    private static void clcs(int i, int j, String a, String b, StringBuilder ans, int[][] s) {
        if (i == 0 || j == 0) return;
        if (s[i][j] == 1) {
            clcs(i - 1, j - 1, a, b, ans, s);
            ans.append(a.charAt(i - 1));
        } else if (s[i][j] == 2) {
            clcs(i - 1, j, a, b, ans, s);
        } else {
            clcs(i, j - 1, a, b, ans, s);
        }
    }

    public static void main(String[] ars) {
        System.out.println(lcs("ABCBDAB", "BDCABA"));
    }
}
