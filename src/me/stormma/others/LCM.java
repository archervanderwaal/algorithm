package me.stormma.others;

/**
 * @author stormma stormmaybin@gmail.com
 * @brief
 */
public class LCM {

    /**
     * 最长连续乘积子数组问题
     * @param numbers
     * @return
     */
    public static int solve1(int[] numbers) {
        if (numbers == null || numbers.length == 0) return 0;
        int[] dp1 = new int[numbers.length]; // 以i结尾最大的乘积子数组
        int[] dp2 = new int[numbers.length]; // 以i结尾最小的乘积子数组
        dp1[0] = dp2[0] = numbers[0];
        int res = Integer.MIN_VALUE;
        // 可以使用滚动数组进行状态压缩
        for (int i = 1; i < numbers.length; i++) {
            dp1[i] = Math.max(Math.max(dp1[i - 1] * numbers[i], dp2[i - 1] * numbers[i]), dp1[i]);
            dp2[i] = Math.min(Math.min(dp1[i - 1] * numbers[i], dp2[i - 1] * numbers[i]), dp2[i]);
            res = Math.max(res, dp1[i]);
        }
        return res;
    }

    /**
     * 求一个有n个元素的数组，选出n-1组成乘积最大的结果
     * // 思路分析: 首先我们考虑已经知道 n - 1元素的数组的（还有n-2个元素的最大结果和还有n-1元素的最大结果）, 那么n个元素的结果就显而易见了:
     *
     * @param numbers
     * @return
     */
    public static int solve2(int[] numbers) {
        if (numbers == null || numbers.length < 2) return 0;
        int[] dp1 = new int[numbers.length];
        int[] dp2 = new int[numbers.length];
        // dp1[i]表示前i个元素, i - 1个元素的乘积的最大值
        // dp2[i]表示前i个元素, i个元素的乘积
        // 感觉应该没啥问题
        dp1[0] = 1;
        dp2[0] = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            dp1[i] = Math.max(dp2[i - 1], dp1[i - 1] * numbers[i]);
            dp2[i] = dp2[i - 1] * numbers[i];
        }
        return dp1[numbers.length - 1];
    }
}
