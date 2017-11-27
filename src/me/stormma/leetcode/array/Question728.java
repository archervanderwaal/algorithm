package me.stormma.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class Question728 {

    static class Solution {
        public List<Integer> selfDividingNumbers(int left, int right) {
            List<Integer> ans = new ArrayList<>();
            for (int i = left; i <= right; i++) {
                boolean valid = true;
                int tmp = i;
                while (tmp != 0) {
                    int x = tmp % 10;
                    tmp = tmp / 10;
                    System.out.println(i+" " + tmp);
                    if (x != 0 && i % x == 0) {
                        continue;
                    } else {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    ans.add(i);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().selfDividingNumbers(1, 22));
    }
}
