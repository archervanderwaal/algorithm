package me.stormma.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 难度系数: 3星，
 * 思路分析见 http://blog.csdn.net/strommaybin/article/details/78432438
 * leetcode 15
 * @author stormma
 * @date 2017/11/03
 */
public class Question15 {

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            if (nums.length < 3) {
                return ans;
            }

            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                // the min elemment > 0, break
                if (nums[i] > 0) {
                    break;
                }
                // skip repeat element
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int low = i + 1, high = nums.length - 1, target = 0 - nums[i];
                while (low < high) {
                    if (target < nums[low] + nums[high]) {
                        high--;
                    } else if (target > nums[low] + nums[high]) {
                        low++;
                    } else {
                        ans.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        //eg: -2 0 0 1 1 2 2 and skip repeating elements, and their sum equals target
                        while (low < high && nums[low + 1] == nums[low])  {
                            low++;
                        }
                        while (low < high && nums[high - 1] == nums[high]) {
                            high--;
                        }
                        low++;
                        high--;
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, -2, -2, 0, 1, 1, 2};
        System.out.println(new Solution().threeSum(nums));
    }
}
