package me.stormma.others;

/**
 * 树状数组的实现:
 * 场景：query一个数组的区间和，并且支持更改某个元素的和
 * @author stormma
 * @date 2018/03/26
 */
public class BinaryIndexedTree {

    private int[] data;

    private static int[] BIT;

    public BinaryIndexedTree(int[] data) {
        this.data = data;
        build();
    }

    /**
     * 查询start <= i <= end范围的和
     * @param start
     * @param end
     * @return
     */
    public int query(int start, int end) {
        if (start < 0 || start >= this.data.length || end < 0 || end >= this.data.length) {
            throw new IllegalArgumentException("start: " + start + " and end: " + end + " 不合法! " +
                    "合法范围: [" + 0 + ", " + (this.data.length - 1) + "]");
        }
        return query(end) - query(start - 1);
    }

    public boolean update(int pos, int value) {
        int oldValue = this.data[pos];
        this.data[pos] = value;
        for (int i = pos + 1; i < BIT.length; i += lowBit(i)) {
            BIT[i] += (value - oldValue);
        }
        return true;
    }

    public boolean add(int pos, int value) {
        this.data[pos] += value;
        for (int i = pos + 1; i < BIT.length; i += lowBit(i + 1)) {
            BIT[i] += value;
        }
        return true;
    }

    private static int lowBit(int num) {
        return num & (-num);
    }

    /**
     * 构建BIT数组
     */
    private void build() {
        BIT = new int[this.data.length + 1];
        for (int i = 1; i < BIT.length; i++) {
            BIT[i] = this.data[i - 1];
            for (int j = i - 2; j >= i - lowBit(i); j--) {
                BIT[i] += this.data[j];
            }
        }
    }

    /**
     * 查询0 <= i <= pos的区间和
     * @param pos
     * @return
     */
    private int query(int pos) {
        int sum = 0;
        for (int i = pos + 1; i > 0; i -= lowBit(i)) {
            sum += BIT[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        BinaryIndexedTree binaryIndexedTree = new BinaryIndexedTree(nums);
        System.out.println(binaryIndexedTree.query(0, nums.length - 2));
        binaryIndexedTree.update(0, 10);
        System.out.println(binaryIndexedTree.query(0, nums.length - 2));
    }
}
