package me.stormma.leetcode.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 难度系数: 2星
 * leetcode 560
 * @author stormma
 * @date 2017/10/23
 */
public class Question560 {
    /**
     * 暴力搜索，时间复杂度O(n^2)
     */
    static class Solution {
        public int subarraySum(int[] nums, int k) {
            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                int sum = 0;
                for (int j = i; j < nums.length; j++) {
                    sum += nums[j];
                    if (sum == k) {
                        ans++;
                    }
                }
            }
            return ans;
        }

        public static void main(String[] args) {
            int[] ss = {1, 1, 1};
            System.out.print(new Solution().subarraySum(ss, 0));
        }
    }

    static class Solution2 {
        public int subarraySum(int[] nums, int k) {
            int sum = 0, result = 0;
            Map<Integer, Integer> preSum = new HashMap<>();
            preSum.put(0, 1);

            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (preSum.containsKey(sum - k)) {
                    result += preSum.get(sum - k);
                }
                preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
            }

            return result;
        }

        public static void main(String[] args) {
            int[] ss = {1, 1, 1};
            System.out.println(new Solution2().subarraySum(ss, 2));
        }
    }
}
