package me.stormma.leetcode.string;

import java.sql.Struct;
import java.util.HashMap;

/**
 * 难度系数: 2星
 * leetcode 14
 * @author stormma
 * @date 2017/11/03
 */
public class Question14 {

    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length < 1) {
                return "";
            }
            String result = strs[0];
            int index = 1;
            while (index < strs.length) {
                while (strs[index].indexOf(result) != 0) {
                    result = result.substring(0, result.length() - 1);
                }
                index++;
            }
            return result;
        }
    }
}
