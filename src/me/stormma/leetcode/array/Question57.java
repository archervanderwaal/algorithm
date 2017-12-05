package me.stormma.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 难度系数: 4星
 * leetcode 57
 * @author stormma
 * @date 2017/12/04
 */
public class Question57 {

    static /**
     * Definition for an interval.
     * public class Interval {
     *     int start;
     *     int end;
     *     Interval() { start = 0; end = 0; }
     *     Interval(int s, int e) { start = s; end = e; }
     * }
     */
    class Solution {
        public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
            List<Interval> ans = new ArrayList<>();
            int insertIdx = 0;
            for (int i = 0; i < intervals.size(); i++) {
                Interval interval = intervals.get(i);

                if (interval.end >= newInterval.start) {
                    newInterval.start = Math.min(newInterval.start, interval.start);
                } else {
                    ans.add(interval);
                    insertIdx++;
                }

                if (interval.start <= newInterval.end) {
                    newInterval.end = Math.max(newInterval.end, interval.end);
                } else {
                    ans.add(interval);
                }
            }
            ans.add(insertIdx, newInterval);
            return ans;
        }
    }

    static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(6, 9));
        System.out.println(new Solution().insert(intervals, new Interval(2, 5)));

    }
}
