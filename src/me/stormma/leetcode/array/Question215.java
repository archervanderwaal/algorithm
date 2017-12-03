package me.stormma.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * leetcode 215
 * @author stormma
 * @date 2017/12/03
 */
public class Question215 {

    /**
     * 时间复杂度 O(nlgn)
     */
    static class Solution1 {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> heap = new PriorityQueue<>(k);
            for (int i = 0; i < nums.length; i++) {
                if (heap.size() == k) {
                    if (nums[i] > heap.peek()) {
                        heap.poll();
                        heap.offer(nums[i]);
                    }
                } else {
                    heap.offer(nums[i]);
                }
            }
            return heap.peek();
        }
    }

    static class Solution2 {
        public int findKthLargest(int[] nums, int k) {
            Arrays.sort(nums);
            return nums[nums.length - k];
        }
    }

    /**
     * quick select
     */
    static class Solution3 {
        public int findKthLargest(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int low = 0, high = nums.length - 1;
            while (true) {
                int pos = partition(nums, low, high);
                if (pos + 1 == k) return nums[pos];
                else if (pos + 1 > k) high = pos - 1;
                else low = pos + 1;
            }
        }

        private int partition(int[] nums, int low, int high) {
            int pivot = nums[low], i = low, j = high + 1;
            while (true) {
                while (i < high && nums[++i] > pivot) {
                    if (i == high) break;
                }

                while (j > 0 && nums[--j] < pivot) {
                    if (j == low) break;
                }

                if (i >= j) break;
                swap(nums, i, j);
            }
            swap(nums, low, j);
            return j;
        }

        private void swap(int[] nums, int i, int j) {
            if (i == j) return;
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }


    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        System.out.println(new Solution3().findKthLargest(nums, 3));
    }
}
