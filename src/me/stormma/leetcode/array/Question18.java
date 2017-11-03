package me.stormma.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 难度系数: 3星
 * beat 80%
 * http://blog.csdn.net/StromMaybin/article/details/78434177
 * leetcode 18
 * @author stormma
 * @date 2017/11/03
 */
public class Question18 {

    static class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            if (nums.length < 4) {
                return ans;
            }
            Arrays.sort(nums);
            if (4 * nums[0] > target || 4 * nums[nums.length - 1] < target) {
                return ans;
            }
            int max = nums[nums.length - 1];
            // -2 -1 0 0 1 2
            for (int i = 0; i < nums.length - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                if (4 * nums[i] > target) {
                    break;
                }
                // 剪枝
                if (nums[i] + 3 * max < target) {
                    continue;
                }
                for (int j = i + 1; j < nums.length - 2; j++) {
                    // 3
                    // -4 -3 0 5 5 10
                    int low = j + 1, high = nums.length - 1, goal = target - nums[i] - nums[j];
                    // 剪枝
                    if (nums[i] + nums[j] + 2 * max < target) {
                        continue;
                    }
                    // 去重
                    if (j > i + 1 && nums[j - 1] == nums[j]) {
                        continue;
                    }
                    while (low < high) {
                        if (nums[low] + nums[high] < goal) {
                            low++;
                        } else if (nums[low] + nums[high] > goal) {
                            high--;
                        } else {
                            ans.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                            while (low < high && nums[low + 1] == nums[low]) {
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
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-5, -2, -1, 0, 2, 2, 4, 4, 4};
        int target = 12;
        System.out.println(new Solution().fourSum(nums, target));
    }
}
