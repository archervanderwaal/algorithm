package me.stormma.leetcode.array;

/**
 * 难度系数: 2星
 * leetcode 88
 * @author stormma
 * @date 2017/12/04
 */
public class Question88 {

    /**
     * 使用辅助数组
     */
    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] ans = new int[m];
            int size = 0, i = 0, j = 0;
            while (i < m || j < n) {
                if (i < m && j < n) {
                    ans[size++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
                } else if (j >= n) {
                    ans[size++] = nums1[i++];
                } else {
                    ans[size++] = nums2[j++];
                }
            }
            for (int t = 0; t < size; t++) {
                nums1[t] = ans[t];
            }
        }
    }

    /**
     * 原地归并，自底向上
     */
    static class Solution2 {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = m - 1, j = n - 1;
            int size = m + n;
            while (i >= 0 || j >= 0) {
                if (i >= 0 && j >= 0) {
                    nums1[--size] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
                } else if (i >= 0) {
                    nums1[--size] = nums1[i--];
                } else {
                    nums1[--size] = nums2[j--];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 5, 6, 0, 0, 0};
        int[] nums2 = {1, 2, 3};
        new Solution2().merge(nums1, 3, nums2, 3);
    }
}
