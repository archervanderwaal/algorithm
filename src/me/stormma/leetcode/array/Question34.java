package me.stormma.leetcode.array;

/**
 * 难度系数: 3星
 * leetcode 34
 * @author stormma
 * @date 2017/11/07
 */
public class Question34 {

    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            int index = binary_search(nums, 0, nums.length - 1, target);
            int start = index, end = start;
            int[] ans = new int[2];
            if (index == -1) {
                ans[0] = ans[1] = -1;
                return ans;
            }
            while (end < nums.length) {
                if (nums[end] == target) {
                    end++;
                } else {
                    break;
                }
            }

            while (start >= 0) {
                if (nums[start] == target) {
                    start--;
                } else {
                    break;
                }
            }
            ans[0] = start + 1;
            ans[1] = end - 1;
            return ans;
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
        public int[] searchRange(int[] nums, int target) {
            int[] ans = new int[2];
            ans[0] = searchStart(nums, 0, nums.length - 1, target);
            ans[1] = searchEnd(nums, 0, nums.length - 1, target);
            return ans;
        }

        private int searchStart(int[] nums, int low, int high, int target) {
            int start = -1;
            while (low <= high) {
                int mid = (low + high) >> 1;
                if (nums[mid] >= target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
                if (nums[mid] == target) {
                    start = mid;
                }
            }
            return start;
        }

        private int searchEnd(int[] nums, int low, int high, int target) {
            int end = -1;
            while (low <= high) {
                int mid = (low + high) >> 1;
                if (nums[mid] <= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
                if (nums[mid] == target) {
                    end = mid;
                }
            }
            return end;
        }
    }
}
