package me.stormma.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 难度系数: 二星
 * leetcode 119.Pascal's Triangle II
 * @author stormma
 * @date 2018/03/23
 */
public class Question119 {
    static class Solution1 {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> ans = new ArrayList<>();
            if (rowIndex < 0) return ans;
            for (int i = 0; i <= rowIndex; i++) {
                ans.add(0, 1);
                for (int j = 1; j < ans.size() - 1; j++) {
                    ans.set(j, ans.get(j) + ans.get(j + 1));
                }
            }
            return ans;
        }
    }

    static class Solution2 {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> ans = new ArrayList<>();
            if (rowIndex < 0) return ans;
            ans.add(1);
            int n = rowIndex, k = 1;
            long val = n / k;
            while (k <= rowIndex) {
                ans.add((int) val);
                n--;
                k++;
                val *= n;
                val /= k;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().getRow(3));
    }
}
