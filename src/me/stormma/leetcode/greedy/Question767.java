package me.stormma.leetcode.greedy;

import java.util.*;

public class Question767 {

    class Solution {
        public String reorganizeString(String S) {
            if (S == null || S.length() == 0) return "";
            Map<Character, Integer> cnt = new HashMap<>();
            for (char c : S.toCharArray()) {
                cnt.put(c, cnt.getOrDefault(c, 0) + 1);
            }
            PriorityQueue<Data> queue = new PriorityQueue<>((data1, data2) -> data2.cnt - data1.cnt);
            for (Character key : cnt.keySet()) {
                if (cnt.get(key) > ((1 + S.length()) >>> 1)) return "";
                queue.add(new Data(key, cnt.get(key)));
            }
            StringBuilder stringBuilder = new StringBuilder();
            while (!queue.isEmpty()) {
                Data first = queue.poll();
                if (stringBuilder.length() == 0 || first.c != stringBuilder.charAt(stringBuilder.length() - 1)) {
                    stringBuilder.append(first.c);
                    if ((first.cnt = first.cnt - 1) > 0) {
                        queue.add(first);
                    }
                } else {
                    if (queue.isEmpty()) return "";
                    Data second = queue.poll();
                    stringBuilder.append(second.c);
                    if ((second.cnt = second.cnt - 1) > 0) {
                        queue.add(second);
                    }
                    queue.add(first);
                }
            }
            return stringBuilder.toString();
        }
    }

    static class Data {
        public Character c;
        public Integer cnt;
        public Data(Character c, Integer cnt) {
            this.c = c;
            this.cnt = cnt;
        }
    }
}
