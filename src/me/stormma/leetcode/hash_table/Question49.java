package me.stormma.leetcode.hash_table;

import java.util.*;

/**
 * 难度系数: 3星
 * leetcode 49
 * @author stormma
 * @date 2017/11/30
 */
public class Question49 {

    static class Solution1 {
        public List<List<String>> groupAnagrams(String[] strs) {
            int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
            List<List<String>> res = new ArrayList<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            for (String s : strs) {
                int key = 1;
                for (char c : s.toCharArray()) {
                    key *= prime[c - 'a'];
                }
                List<String> t;
                if (map.containsKey(key)) {
                    t = res.get(map.get(key));
                } else {
                    t = new ArrayList<>();
                    res.add(t);
                    map.put(key, res.size() - 1);
                }
                t.add(s);
            }
            return res;
        }
    }

    static class Solution2 {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> ans = new ArrayList<>();
            if (strs == null || strs.length == 0) return ans;

            Map<String, Integer> map = new HashMap<>();

            for (String string : strs) {
                char[] c = string.toCharArray();
                Arrays.sort(c);
                String tmp = new String(c);
                if (map.containsKey(tmp)) {
                    ans.get(map.get(tmp)).add(string);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(string);
                    map.put(tmp, ans.size());
                    ans.add(list);
                }
            }
            return ans;
        }
    }

    static class Solution3 {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> ans = new HashMap<>();
            for (String string : strs) {
                int[] count = new int[26];
                for (char c : string.toCharArray()) {
                    count[c - 'a']++;
                }
                String tmp = "";
                for (int i = 0; i < count.length; i++) {
                    if (count[i] != 0) {
                        tmp += String.valueOf(count[i]) + String.valueOf((char)(i + 'a'));
                    }
                }
                if (ans.containsKey(tmp)) {
                    ans.get(tmp).add(string);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(string);
                    ans.put(tmp, list);
                }
            }
            return new ArrayList<>(ans.values());
        }
    }
}
