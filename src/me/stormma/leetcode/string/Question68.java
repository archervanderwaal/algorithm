package me.stormma.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 难度系数: 三星
 * leetcode 68. Text Justification
 * @author stormma
 * @date 2018/03/24
 */
public class Question68 {

    static class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> ans = new ArrayList<>();
            if (words == null || words.length == 0) return ans;
            fullJustify(ans, words, 0, maxWidth);
            return ans;
        }

        private void fullJustify(List<String> ans, String[] words, int wi, int maxWidth) {
            if (wi >= words.length) return;
            List<String> list = new ArrayList<>();
            int tmp = maxWidth, ind = wi;
            for (int i = wi; i < words.length && tmp >= (words[i].length() + ind - wi); ind = i, i++) {
                tmp -= words[i].length();
            }
            StringBuilder dummy = new StringBuilder();
            int cnt = (ind - wi) == 0 ? tmp : tmp / (ind - wi);
            int storm = (ind - wi) == 0 ? 0 : tmp % (ind - wi);
            boolean isSingle = true;
            for (int i = wi; i < ind; i++, isSingle = false) {
                dummy.append(words[i]);
                for (int j = 1; j <= (storm == 0 ? cnt : cnt + 1); j++) {
                    dummy.append(" ");
                }
                if (storm != 0) storm--;
            }
            dummy.append(words[ind]);
            if (isSingle) {
                for (int i = 1; i <= tmp; i++) {
                    dummy.append(" ");
                }
            }
            ans.add(dummy.toString());
            fullJustify(ans, words, ind + 1, maxWidth);
        }
    }

    public static void main(String[] args) {
        String[] words = {
                "a","b","c","d","e"
        };
        System.out.println(new Solution().fullJustify(words, 3));
    }
}
