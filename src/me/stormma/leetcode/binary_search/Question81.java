package me.stormma.leetcode.binary_search;

/**
 * 难度系数: 3星
 * leetcode 81
 * @author stormma
 * @date 2017/12/06
 */
public class Question81 {

    static class Solution {
        public boolean search(int[] nums, int target) {
            int low = 0, high = nums.length - 1;
            if (high == -1) return false;
            while (low <= high) {
                int mid = (low + high) >> 1;
                if (nums[mid] == target) return true;
                if (nums[mid] > nums[high]) {
                    if (nums[mid] > target && nums[low] <= target) {
                        high = mid;
                    }
                    else {
                        low = mid + 1;
                    }
                } else if (nums[mid] < nums[high]) {
                    if (nums[mid] < target && nums[high] >= target) {
                        low = mid + 1;
                    }
                    else {
                        high = mid;
                    }
                } else {
                    high--;
                }
            }
            return nums[low] == target;
        }
    }

    static class Solution2 {
        public boolean search(int[] nums, int target) {
            if (nums == null || nums.length == 0) return false;
            int low = 0, high = nums.length - 1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                // low -> mid严格递增
                if (nums[mid] == target) return true;
                if (nums[low] < nums[mid]) {
                    if (target >= nums[low] && target < nums[mid]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                } else if (nums[low] > nums[mid]) {
                    if (target > nums[mid] && target <= nums[high]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                } else {
                    low++;
                }
            }
            return false;
        }
    }
}


// 1 1 3 1
// mid =