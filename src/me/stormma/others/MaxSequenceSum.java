package me.stormma.others;

/**
 * 最大子序列和
 * @author stormma
 * @date 2018/03/07
 */
public class MaxSequenceSum {

    /**
     * 暴力枚举, 时间复杂度O(n^2)
     * @param array
     * @return
     */
    public int maxSequenceSum1(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = i; j < array.length; j++) {
                sum += array[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    /**
     * 分治算法
     * 时间复杂度O(nlogn)
     * @param array
     * @return
     */
    public int maxSequenceSum2(int[] array) {
        if (array == null || array.length == 0) return 0;
        return maxSequenceSum2(array, 0, array.length - 1);
    }

    public int maxSequenceSum2(int[] array, int low, int high) {
        if (high < low) return 0;
        if (low == high) return array[low];
        int mid = (high + low) >> 1;
        int lMax = array[mid], lSum = 0;
        for (int i = mid; i >= low; i--) {
            lSum += array[i];
            if (lSum > lMax) lMax = lSum;
        }
        int hMax = array[mid + 1], hSum = 0;
        for (int i = mid + 1; i <= high; i++) {
            hSum += array[i];
            if (hSum > hMax) hMax = hSum;
        }
        return Math.max(Math.max(lMax + hMax, maxSequenceSum2(array, low, mid)), maxSequenceSum2(array, mid + 1, high));
    }

    public int maxSequenceSum3(int[] array) {
        if (array == null || array.length == 0) return 0;
        int max = array[0], aux = array[0];
        for (int i = 1; i < array.length; i++) {
            if (aux <= 0) aux = array[i];
            else aux += array[i];
            if (aux > max) max = aux;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, -2, 4, -5};
        System.out.println(new MaxSequenceSum().maxSequenceSum1(array));
        System.out.println(new MaxSequenceSum().maxSequenceSum2(array));
        System.out.println(new MaxSequenceSum().maxSequenceSum3(array));
    }
}
