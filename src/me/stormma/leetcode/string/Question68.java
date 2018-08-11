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

    /**
     * time running: O(n)
     * space: O(n)
     */
    static class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> ans = new ArrayList<>();
            if (words == null || words.length == 0) return ans;
            int index = 0;
            while (index < words.length) {
                int last = index + 1, cnt = words[index].length();
                while (last < words.length) {
                    if (words[last].length() + cnt + 1 > maxWidth) break;
                    cnt += words[last].length() + 1;
                    last++;
                }
                StringBuilder builder = new StringBuilder();
                builder.append(words[index]);
                int diff = last - index - 1;
                if (diff == 0 || last == words.length) {
                    for (int i = index + 1; i < last; i++) {
                        builder.append(" ").append(words[i]);
                    }
                    for (int i = builder.length(); i < maxWidth; i++) {
                        builder.append(" ");
                    }
                } else {
                    int spaces = (maxWidth - cnt) / diff;
                    int remain = (maxWidth - cnt) % diff;
                    for (int i = index + 1; i < last; i++) {
                        for (int k = spaces; k > 0; k--) {
                            builder.append(" ");
                        }
                        if (remain > 0) {
                            builder.append(" ");
                            remain--;
                        }
                        builder.append(" ").append(words[i]);
                    }
                }
                ans.add(builder.toString());
                index = last;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String[] words = {
                "a","b","c","d","e"
        };
        System.out.println(new Solution().fullJustify(words, 3));
    }
}
