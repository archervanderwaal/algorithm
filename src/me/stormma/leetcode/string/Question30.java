package me.stormma.leetcode.string;

import java.util.*;

/**
 * 难度系数: 4星
 * leetcode 30
 * @author stormma
 * @date 2017/11/07
 */
public class Question30 {

    /**
     * TLE
     */
    static class Solution1 {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> ans = new ArrayList<>();
            int low = 0, high = s.length() - 1;
            int wLen = words.length, weLen = words[0].length();
            while (low + wLen * weLen - 1 <= high) {
                boolean valid = true;
                List<Integer> index = new ArrayList<>();
                String str = s.substring(low, low + wLen * weLen);
                for (int i = 0; i < wLen; i++) {
                    int ind = str.indexOf(words[i]);
                    while (ind != -1) {
                        if (ind % weLen == 0 && !index.contains(ind)) {
                            break;
                        }
                        ind = s.substring(low, low + wLen * weLen).indexOf(words[i], ind + 1);
                    }
                    if (ind == -1 || index.contains(ind) || ind % weLen != 0) {
                        valid = false;
                        break;
                    }
                    index.add(ind);
                }
                if (valid) {
                    ans.add(low);
                }
                low++;
            }
            return ans;
        }
    }

    /**
     * 勉强通过
     */
    static class Solution2 {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> ans = new ArrayList<>();
            int wLen = words.length, weLen = words[0].length();
            Map<String, Integer> map = new HashMap<>(words.length);
            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }

            for (int i = 0; i <= s.length() - wLen * weLen; i++) {
                Map<String, Integer> tmp = new HashMap<>(map);
                for (int j = 0; j < wLen * weLen; j += weLen) {
                     String string = s.substring(i + j, i + j + weLen);
                     if (tmp.containsKey(string)) {
                         if (tmp.get(string) == 1) {
                             tmp.remove(string);
                         } else {
                             tmp.put(string, tmp.get(string) - 1);
                         }
                         if (tmp.isEmpty()) {
                             ans.add(i);
                         }
                     } else {
                         break;
                     }
                }
            }
            return ans;
        }
    }

    /**
     * TLE， DFS深度决定于words大小，words过大，爆栈不可取，这只是一个思路
     */
    static class Solution3 {

        public List<Integer> findSubstring(String s, String[] words) {
            int wLen = words.length, weLen = words[0].length();
            List<Integer> ans = new ArrayList<>();
            if (s.length() < wLen * weLen) {
                return ans;
            }
            Set<String> tmp = new HashSet<>();
            boolean[] visited = new boolean[words.length];
            dfs(tmp, 0, words, "", visited);

            for (int i = 0; i <= s.length() - wLen * weLen; i++) {
                String str = s.substring(i, i + wLen * weLen);
                if (tmp.contains(str)) {
                    ans.add(i);
                }
            }
            return ans;
        }

        private void dfs(Set<String> tmp, int depth, String[] words, String str, boolean[] visited) {
            if (depth == words.length) {
                tmp.add(str);
                return;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    str += words[i];
                    dfs(tmp, depth + 1, words, str, visited);
                    str = str.substring(0, str.length() - words[i].length());
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] words = {"foo", "bar"};
        System.out.println(new Solution3().findSubstring("barfoothefoobarman", words));
    }
}
