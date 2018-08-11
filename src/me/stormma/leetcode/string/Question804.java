package me.stormma.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 804. Unique Morse Code Words
 * @author stormma
 * @date 2018/03/25
 */
public class Question804 {
    static class Solution {
        static final String[] aux = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        public int uniqueMorseRepresentations(String[] words) {
            Set<String> ans = new HashSet<>();
            if (words == null || words.length == 0) return 0;
            for (String word : words) {
                StringBuilder sb = new StringBuilder();
                for (char ch : word.toCharArray()) {
                    sb.append(aux[ch - 'a']);
                }
                ans.add(sb.toString());
            }
            return ans.size();
        }
    }
}
