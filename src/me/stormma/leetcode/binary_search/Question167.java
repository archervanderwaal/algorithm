package me.stormma.leetcode.binary_search;

/**
 * leetcode 167. Two Sum II - Input array is sorted <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted">题目链接</a>
 *
 * @author stormma
 * @date 2017/10/19
 */
public class Question167 {

    /**
     * time complexity = O(nLgN)
     * runtime = 3ms
     */
    static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int[] result = new int[2];
            for (int i = 0; i < numbers.length; i++) {
                int searchTarget = target - numbers[i];
                int searchTargetIndex;
                if ((searchTargetIndex = binarySearch(numbers, searchTarget, i + 1)) != -1) {
                    result[0] = i + 1;
                    result[1] = searchTargetIndex + 1;
                    break;
                }
            }
            return result;
        }

        private int binarySearch(int[] numbers, int target, int startPos) {
            int low = startPos, high = numbers.length - 1;
            while (low <= high) {
                int mid = (low + high) >> 1;
                if (target < numbers[mid]) {
                    high = mid - 1;
                } else if (target > numbers[mid]) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            }
            return -1;
        }
    }

    /**
     * time complexity O(N)
     * runtime = 1ms
     */
    static class Solution1 {
        public int[] twoSum(int[] numbers, int target) {
            int[] result = new int[2];
            int left = 0, right = numbers.length - 1;
            while (left <= right) {
                int sum = numbers[left] + numbers[right];
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    result[0] = left + 1;
                    result[1] = right + 1;
                    break;
                }
            }
            return result;
        }
    }
}
