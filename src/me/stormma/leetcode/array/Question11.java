package me.stormma.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 难度系数: 2星
 * leetcode 11
 * @author stormma
 * @date 2017/11/03
 */
public class Question11 {

    static class Solution {
        public int maxArea(int[] height) {
            if (height.length < 2) {
                return 0;
            }
            int low = 0, high = height.length - 1;
            int ans = 0;
            // (hight - low) * Math.min(height[high], height[low])
            while (low < high) {
                ans = Math.max(ans, (high - low) * Math.min(height[high], height[low]));
                if (height[low] > height[high]) {
                    high--;
                } else {
                    low++;
                }
            }
            return ans;
        }
    }

    static class Solution1 {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length < 1) {
                return "";
            }
            StringBuilder ans = new StringBuilder();
            Arrays.sort(strs);
            int n = Math.min(strs[0].length(), strs[strs.length - 1].length());
            for (int i = 0; i < n; i++) {
                if (strs[strs.length - 1].charAt(i) == strs[0].charAt(i)) {
                    ans.append(strs[0].charAt(i));
                } else {
                    break;
                }
            }
            return ans.toString();
        }
    }
}
