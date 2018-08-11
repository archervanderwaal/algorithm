package me.stormma.others;

/**
 * @author stormma stormmaybin@gmail.com
 */
public class LevenshteinDistance {

    /**
     * 返回从源字符串到目标字符串的最小操作数
     * source: 源字符串
     * target：目标字符串
     * 返回：最小操作数
     */
    public int minOperationCount(String source, String target) {
        if (source == null || target == null) return 0;
        if (source.length() == 0 || target.length() == 0) {
            return source.length() == 0 ? source.length() : target.length();
        }
        int sourceLength = source.length(), targetLength = target.length();
        int[][] dp = new int[sourceLength + 1][targetLength + 1];
        // dp[0][0] = 0;
        // dp[0][j] = j;
        // dp[i][0] = 0;
        // start init
        for (int i = 0; i < sourceLength + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < targetLength + 1; j++) {
            dp[0][j] = j;
        }
        // calc
        for (int i = 1; i < sourceLength + 1; i++) {
            for (int j = 1; j < targetLength + 1; j++) {
                int remain = source.charAt(i) == target.charAt(j) ? 0 : 1;
                dp[i][j] = Math.min(dp[i - 1][j - 1] + remain, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
            }
        }
        return dp[sourceLength][targetLength];
    }
}
