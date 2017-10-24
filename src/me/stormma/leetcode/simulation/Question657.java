package me.stormma.leetcode.simulation;

import java.util.HashMap;
import java.util.Map;

/**
 * 难度系数: 1星
 * leetcode 657,
 * @author stormma
 * @date 2017/10/24
 */
public class Question657 {

    static class Solution1 {
        public boolean judgeCircle(String moves) {
            Map<Character, Integer> dx = new HashMap<>();
            dx.put('L', -1);
            dx.put('R', 1);
            dx.put('U', 0);
            dx.put('D', 0);
            Map<Character, Integer> dy = new HashMap<>();
            dy.put('L', 0);
            dy.put('R', 0);
            dy.put('U', 1);
            dy.put('D', -1);
            int x = 0, y = 0;
            for (Character c: moves.toCharArray()) {
                x += dx.get(c);
                y += dy.get(c);
            }
            return x == 0 && y == 0;
        }
    }

    static class Solution2 {
        public boolean judgeCircle(String moves) {
            int[] counts = new int[86];
            for (Character c: moves.toCharArray()) {
                counts[c] ++;
            }
            return counts['L'] == counts['R'] && counts['U'] == counts['D'];
        }
    }
}
