package me.stormma.leetcode.binary_indexed_tree;

/**
 * 难度系数: 三星
 * 树状数组问题
 * leetcode 307. Range Sum Query - Mutable
 * @author stormma
 * @date 2018/03/26
 */
public class Question307 {
    static class NumArray {

        private int[] BIT;

        private int[] data;

        public NumArray(int[] data) {
            this.data = new int[data.length];
            BIT = new int[this.data.length + 1];
            for (int i = 0; i < data.length; i++) {
                update(i, data[i]);
            }
        }

        private void buildBIT() {
            for (int i = 1; i < this.BIT.length; i++) {
                BIT[i] = this.data[i - 1];
                for (int j = i - 2; j >= i - lowBit(i); j--) {
                    BIT[i] += this.data[j];
                }
            }
        }

        public void update(int i, int val) {
            int oldVal = this.data[i];
            this.data[i] = val;
            for (int BIT_INDEX = i + 1; BIT_INDEX < this.BIT.length; BIT_INDEX += lowBit(BIT_INDEX)) {
                BIT[BIT_INDEX] += (val - oldVal);
            }
        }

        public int sumRange(int i, int j) {
            return sumRange(j) - sumRange(i - 1);
        }

        private int sumRange(int i) {
            int BIT_INDEX = i + 1, sum = 0;
            while (BIT_INDEX > 0) {
                sum += BIT[BIT_INDEX];
                BIT_INDEX -= lowBit(BIT_INDEX);
            }
            return sum;
        }

        static int lowBit(int x) {
            return x & (-x);
        }
    }
}
