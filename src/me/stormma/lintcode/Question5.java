package me.stormma.lintcode;

/**
 * lintcode 5.
 * @author stormma
 * @date 2018/03/28
 */
public class Question5 {
    static class Solution {
        /*
         * @param k : description of k
         * @param nums : array of nums
         * @return: description of return
         */
        public int kthLargestElement(int k, int[] nums) {
            // write your code here
            return solve(nums, k, 0, nums.length - 1);
        }

        private int solve(int[] nums, int k, int low, int high) {
            int i = low, j = high, len = high - low + 1;
            int pivot = nums[low];
            // 9 3 2 4 8 k = 3
            // 0, 4
            // 8 3 2 4 8 low = 1, high = 4
            // 8 3 2 4 9 low = 4, high = 4   1 < k
            while (low < high) {
                while (low < high && nums[high] >= pivot) {
                    high--;
                }
                nums[low] = nums[high];
                while (low < high && nums[low] <= pivot) {
                    low++;
                }
                nums[high] = pivot;
            }
            nums[low] = pivot;
            // 1 2 3 4 5 6 7 8   length = 8;    k = 4
            // 5 4 3 2 1
            if (len - low == k) return pivot;
            else if (len - low > k) return solve(nums, k, low + 1, j);
            else return solve(nums, k - len + low, i, low - 1);
        }
    }

    public static void main(String... args) {
        int[] nums = {9, 3, 2, 4, 8};
        System.out.println(new Solution().kthLargestElement(3, nums));
    }
}
