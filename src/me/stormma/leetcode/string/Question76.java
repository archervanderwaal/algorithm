package me.stormma.leetcode.string;

/**
 * @author stormma stormmaybin@gmail.com
 */
public class Question76 {
    static class Solution {
        public String minWindow(String s, String t) {
            char[] S = s.toCharArray();
            char[] T = t.toCharArray();
            int[] count = new int[256];
            for (int i = 0; i < T.length; i++) count[T[i]]++;
            /** from标记最终结果子串的起始位置, res表示最终结果的长度, total表示剩余匹配字符数*/
            int from = 0, res = Integer.MAX_VALUE, total = T.length;

            /** 使用双指针i, j, i表示子串起始位置, j表示字串结束位置*/
            for (int i = 0, j = 0; j < S.length; j++) {
                if (count[S[j]] > 0) total--;
                count[S[j]]--;
                /**此时, i->j已经是一个有效的匹配, 我们更新答案*/
                while (total == 0) {
                    if (res > j - i + 1) {
                        res = j - i + 1;
                        /**更新最终答案起始位置*/
                        from = i;
                    }
                    /**如果该子串的其实位置是一个有效字符, 要移动i, 我们必须使total++*/
                    if (count[S[i]] == 0) total++;
                    /**更新*/
                    count[S[i]]++;
                    i++;
                }
            }
            return res == Integer.MAX_VALUE ? "" : s.substring(from, from + res);
        }
    }
}
