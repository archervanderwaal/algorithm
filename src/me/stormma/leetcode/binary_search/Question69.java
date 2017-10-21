package me.stormma.leetcode.binary_search;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * leetcode 69. Sqrt(x) <a href="https://leetcode.com/problems/sqrtx">题目链接</a>
 *
 * @author stormma
 * @date 2017/10/20
 */
public class Question69 {
    static class Solution {
        public static int mySqrt(int x) {
            int left = 0, right = (x >> 1) + 1;
            while (left <= right) {
                int mid = (left + right) >> 1;
                long sq = (long) mid * (long) mid;
                if (sq < x) {
                    left = mid + 1;
                } else if (sq > x) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            }
            return right;
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.mySqrt(2));
    }
}
