package me.stormma.leetcode.array;

/**
 * @author stormma stormmaybin@gmail.com
 */
public class Question845 {

    class Solution {
        public int longestMountain(int[] A) {
            if (A == null || A.length == 0) return 0;
            int base = 0, ans = 0;
            while (base < A.length) {
                int end = base;
                // if base is left-boundary
                if (end + 1 < A.length && A[end] < A[end + 1]) {
                    while (end + 1 < A.length && A[end] < A[end + 1]) end++;
                    // confirm end is peek
                    if (end + 1 < A.length && A[end] > A[end + 1]) {
                        while (end + 1 < A.length && A[end] > A[end + 1]) end++;
                        ans = Math.max(ans, end - base + 1);
                    }
                }
                base = Math.max(base + 1, end);
            }
            return ans;
        }
    }

    class Solution1 {
        public int longestMountain(int[] A) {
            if (A == null || A.length == 0) return 0;
            int ans = 0;
            int[] inc = new int[A.length];
            int[] dec = new int[A.length];
            for (int i = 1; i < A.length; i++) {
                if (A[i] > A[i - 1]) inc[i] = inc[i - 1] + 1;
            }
            for (int i = A.length - 2; i > 0; i--) {
                if (A[i] > A[i + 1]) dec[i] = dec[i + 1] + 1;
            }
            for (int i = 0; i < A.length; i++) {
                if (inc[i] != 0 && dec[i] != 0) {
                    ans = Math.max(ans, inc[i] + dec[i] + 1);
                }
            }
            return ans >= 0 ? ans : 0;
        }
    }
}
