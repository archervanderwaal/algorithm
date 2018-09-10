package me.stormma.leetcode.array;

/**
 * 896. Monotonic Array
 *
 * @author archer archer.vanderwaal@gmail.com
 */
public class Question896 {

    static class Solution {
        public boolean isMonotonic(int[] A) {
            if (A == null || A.length == 0) return false;
            boolean increase = false;
            int i = 1;
            while (i < A.length) {
                if (A[i] > A[i - 1]) {
                    increase = true;
                } else if (A[i] == A[i - 1]) {
                    i++;
                    continue;
                }
                break;
            }
            for (; i < A.length; i++) {
                if (increase && A[i] < A[i - 1]) {
                    return false;
                }
                if (!increase && A[i] > A[i - 1]) {
                    return false;
                }
            }
            return true;
        }
    }

    static class Solution2 {
        public boolean isMonotonic(int[] A) {
            int trend = 0;
            for (int i = 1; i < A.length; i++) {
                if (A[i - 1] == A[i]) continue;
                if (A[i - 1] < A[i] && trend < 0 ||
                        A[i - 1] > A[i] && trend > 0)
                    return false;
                trend = A[i] - A[i - 1];
            }
            return true;
        }
    }


}
