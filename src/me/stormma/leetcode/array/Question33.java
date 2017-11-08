package me.stormma.leetcode.array;

/**
 * 难度系数: 3星
 * leetcode 33
 * @author stormma
 * @date 2017/11/07
 */
public class Question33 {

    static class Solution1 {
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            if (nums.length == 1) {
                return nums[0] == target ? 0 : -1;
            }
            int ind = 1;
            while (ind < nums.length) {
                if (nums[ind - 1] > nums[ind]) {
                    break;
                }
                ind++;
            }
            return binary_search(nums, 0, ind - 1, target) == -1 ? binary_search(nums, ind, nums.length - 1, target) : binary_search(nums, 0, ind - 1, target);
        }

        private int binary_search(int[] nums, int low, int high, int target) {
            while (low <= high) {
                int mid = (low + high) >> 1;
                if (target > nums[mid]) {
                    low = mid + 1;
                } else if (target < nums[mid]) {
                    high = mid - 1;
                } else {
                    return mid;
                }
            }
            return -1;
        }
    }

    static class Solution2 {
        public int search(int[] nums, int target) {
            int low = 0, high = nums.length - 1;
            while (low <= high) {
                int mid = (low + high) >> 1;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[mid] >= nums[low]) {
                    if (target >= nums[low] && target < nums[mid]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
                if (nums[mid] <= nums[high]) {
                    if (target <= nums[high] && target > nums[mid]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
            return -1;
        }
    }
}
