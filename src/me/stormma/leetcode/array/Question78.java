package me.stormma.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 难度系数: 三星
 * leetcode 78. Subsets
 * @author stormma
 * @date 2018/03/23
 */
public class Question78 {
    static class Solution1 {
        /**
         * 时间复杂度 O(2^n *n)
         * @param nums
         * @return
         */
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            if (nums == null || nums.length == 0) return ans;
            dfs(new ArrayList<>(), ans, 0, nums);
            return ans;
        }

        public void dfs(List<Integer> tmp, List<List<Integer>> ans, int index, int[] nums) {
            ans.add(new ArrayList<>(tmp));
            for (int i = index; i < nums.length; i++) {
                tmp.add(nums[i]);
                dfs(tmp, ans, i + 1, nums);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    /**
     * 若nums数组有n个元素，那么结果集必定是2^n个
     * 现在假定一个n位二进制整数   0000000000  => n位
     * 来标识nums某个下标元素是否取, 以{1, 2, 3}举例说明
     * 我们用一个三位二进制数来做分析:
     * 000 => 表示2下标不取, 1下标不取, 0下标不取 => {}
     * 001 => 表示2下标不取, 1下标不取, 0下标取 => {1}
     * 010 => 表示2下标不取, 1下标取, 0下标不取 =>{2}
     * .... 可得结果
     * 111 => 7 全部取{1, 2, 3}
     */
    static class Solution2 {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            if (nums == null || nums.length == 0) return ans;
            int cnt = (int) Math.pow(2, nums.length);
            for (int i = 0; i < cnt; i++) {
                ans.add(new ArrayList<>());
            }
            for (int i = 0; i < cnt; i++) { // 2^n * n
                for (int j = 0; j < nums.length; j++) {
                    if (((i >> j) & 1) == 1) ans.get(i).add(nums[j]);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        new Solution1().subsets(nums);
    }
}
