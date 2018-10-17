package me.stormma.leetcode.array;

/**
 * @author archer archer.vanderwaal@gmail.com
 */
public class Question922 {

    static class SolutionI {
        public int[] sortArrayByParityII(int[] A) {
            if (A == null || A.length == 0) return A;
            int[] res = new int[A.length];
            int start = 0, end = A.length - 1;
            for (int a : A) {
                if ((a & 1) == 0) {
                    res[start] = a;
                    start += 2;
                } else {
                    res[end] = a;
                    end -= 2;
                }
            }
            return res;
        }
    }

    static class SolutionII {
        public int[] sortArrayByParityII(int[] A) {
            int i = 0;
            int j = 1;
            while (i < A.length) {
                while (j < A.length && A[j] % 2 == 1) {
                    j += 2;
                }
                if (A[i] % 2 == 1) {
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                }
                i += 2;
            }
            return A;
        }
    }
}
