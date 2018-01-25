package me.stormma.leetcode.greedy;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Question767 {

    static class Solution {
        public String reorganizeString(String S) {
            String ans = "$";
            Map<Character, Integer> cnt = new TreeMap<>();
            for (char c : S.toCharArray()) {
                cnt.put(c, cnt.getOrDefault(c, 0) + 1);
            }
            PriorityQueue<Data> queue = new PriorityQueue<>(new Comparator<Data>() {
                @Override
                public int compare(Data o1, Data o2) {
                    return o2.cnt - o1.cnt;
                }
            });
            for (Character key : cnt.keySet()) {
                queue.add(new Data(key, cnt.get(key)));
            }
            boolean flag = false;
            while (!queue.isEmpty()) {
                Data data = queue.peek();
                if (data.c == ans.charAt(ans.length() - 1)) {
                    ;
                } else {
                    ans += data.c;
                }
            }
            return flag ? "" : ans;
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
