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
        // 1 2 3 4 <- 5
        // low = 0, high = 3 mid = 1  2 < 5
        // low = 2, high = 3, mid = 2 3 < 5
        // low = 3, high = 3, mid = 3, 4 < 5
        // low = 4, high = 3则 return low;

        // 2 3 4 5 <- 1
        // low = 0, high = 3, mid = 1   3 > 1
        // low = 0, high = 0, mid = 0,  2 > 1
        // low = -1, high = 0;


        // 5 2 2 2
        // 2 2 2
        // 0 0 0


        // 2  <- 2
    }

    public static void main(String[] args) {
        int[] nums = {21,84,66,65,36,100,41};
        System.out.println(new Solution1().countSmaller(nums));
    }
}
