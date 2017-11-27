package me.stormma.leetcode.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author stormma
 */
public class Question729 {

    static class MyCalendar {

        private Map<Integer, Integer> memo;
        public MyCalendar() {
            memo = new HashMap<>();
        }

        public boolean book(int start, int end) {
            if (memo.size() == 0) {
                memo.put(start, end);
                return true;
            }
            for (Integer key : memo.keySet()) {
                int value = memo.get(key);
                if ((start >= key && start < value) || (end > key && end < value) || (start < key && end >= value)) {
                    return false;
                }
            }
            memo.put(start, end);
            return true;
        }
    }
}
