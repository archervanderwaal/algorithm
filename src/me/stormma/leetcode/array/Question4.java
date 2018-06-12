package me.stormma.leetcode.array;

/**
 * 思路分析 https://github.com/StormMaybin/algorithm/blob/master/src/me/stormma/leetcode/array/Question1.java)
 * 难度系数: 5星
 * leetcode 4
 * @author stormma
 * @date 2017/11/05
 */
public class Question4 {

    static class Solution1 {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) {
                int[] temp = nums1; nums1 = nums2; nums2 = temp;
            }
            int m = nums1.length, n = nums2.length;
            int iMin = 0, iMax = m, halfLen = (m + n + 1) >> 1;
            while (iMin <= iMax) {
                int i = (iMin + iMax) >> 1;
                int j = halfLen - i;
                if (i > iMin && nums1[i - 1] > nums2[j]) { // i is too big
                    iMax = i - 1;
                } else if (i < iMax && nums2[j - 1] > nums1[i]) { // i is too small
                    iMin = i + 1;
                } else { // find correct i
                    int maxLeft = 0;
                    if (i == 0) {
                        maxLeft = nums2[j - 1];
                    } else if (j == 0) {
                        maxLeft = nums1[i - 1];
                    } else {
                        maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                    }
                    if ((m + n) % 2 == 1) {
                        return maxLeft;
                    }

                    int minRight = 0;
                    if (i == m) {
                        minRight = nums2[j];
                    } else if (j == n) {
                        minRight = nums1[i];
                    } else {
                        minRight = Math.min(nums1[i], nums2[j]);
                    }
                    return (minRight + maxLeft) / 2.0;
                }
            }
            return 0.0;
        }
    }

    static class Solution2 {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length, n = nums2.length;
            // 1 2 3 4
            if ((m + n) % 2 == 0) {
                return (findKth(nums1, 0, nums2, 0, (m + n) / 2) + findKth(nums1, 0, nums2, 0,
                        (m + n) / 2 + 1)) / 2.0;
            } else {
                return findKth(nums1, 0, nums2, 0, (m + n + 1) / 2);
            }
        }

        /**
         * 寻找合并数组中第k大元素
         * @param a
         * @param aStart
         * @param b
         * @param bStart
         * @param k
         * @return
         */
        private int findKth(int[] a, int aStart, int[] b, int bStart, int k) {
            if (aStart >= a.length) {
                return b[bStart + k - 1];
            }
            if (bStart >= b.length) {
                return a[aStart + k - 1];
            }
            if (k == 1) {
                return Math.min(a[aStart], b[bStart]);
            }
            int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
            if ((aStart + k / 2 - 1) < a.length) {
                aMid = a[aStart + k / 2 - 1];
            }
            if ((bStart + k / 2 - 1 ) < b.length) {
                bMid = b[bStart + k / 2 - 1];
            }
            // a前k / 2个数大于b 前k / 2个元素，
            if (aMid > bMid) {
                return findKth(a, aStart, b, bStart + k / 2, k - k / 2);
            } else {
                return findKth(a, aStart + k / 2, b, bStart, k - k / 2);
            }
        }
    }

    // 1 3
    // 2
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {};
        System.out.println(new Solution2().findMedianSortedArrays(nums1, nums2));
    }
}
