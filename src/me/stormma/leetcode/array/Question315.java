package me.stormma.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 难度系数: 三星
 * leetcode 315. Count of Smaller Numbers After Self
 * @author stormma
 * @date 2018/03/26
 */
public class Question315 {
    static class Solution1 {
        public List<Integer> countSmaller(int[] nums) {
            Integer[] ans = new Integer[nums.length];
            List<Integer> aux = new ArrayList<>();
            for (int i = nums.length - 1; i >= 0; i--) {
                int index = binarySearch(aux, nums[i]);
                ans[i] = index;
                aux.add(index, nums[i]);
            }
            return Arrays.asList(ans);
        }

        private int binarySearch(List<Integer> list, int target) {
            int low = 0, high = list.size() - 1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                if (target <= list.get(mid)) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }
    }

    /**
     * 暴力算法
     * 提交结果: 超时
     */
    static class Solution2 {
        public List<Integer> countSmaller(int[] nums) {
            List<Integer> ans = new ArrayList<>();
            if (nums == null || nums.length == 0) return ans;
            for (int i = 0; i < nums.length; i++) {
                int cnt = 0;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] < nums[i]) cnt++;
                }
                ans.add(cnt);
            }
            return ans;
        }
    }

    static class Solution3 {
        public List<Integer> countSmaller(int[] nums) {
            return null;
        }
    }

    public static void main(String[] args) {
        int[] nums = {21,84,66,65,36,100,41};
        System.out.println(new Solution1().countSmaller(nums));
    }
}
