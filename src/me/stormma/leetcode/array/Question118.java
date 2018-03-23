package me.stormma.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 难度系数: 二星
 * leetcode 108. Pascal's Triangle
 * @author stormma
 * @date 2018/03/23
 */
public class Question118 {
    static class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> ans = new ArrayList<>();
            if (numRows < 0) return ans;
            ans.add(Arrays.asList(1));
            if (numRows == 1) return ans;
            ans.add(Arrays.asList(1, 1));
            if (numRows == 2) return ans;
            for (int i = 3; i <= numRows; i++) {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                for (int j = 1; j < ans.get(i - 2).size(); j++) {
                    list.add(ans.get(i - 2).get(j - 1) + ans.get(i - 2).get(j));
                }
                list.add(1);
                ans.add(list);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        new Solution().generate(5);
    }
}
