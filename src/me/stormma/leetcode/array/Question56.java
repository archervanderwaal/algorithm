package me.stormma.leetcode.array;

import java.util.*;

/**
 * 难度系数: 3星
 * leetcode 56
 * @author stormma
 * @date 2017/12/04
 */
public class Question56 {

    /**
     * from me.
     */
    static class Solution1 {
        public List<Interval> merge(List<Interval> intervals) {
            Stack<Interval> ans = new Stack<>();
            Collections.sort(intervals, new Comparator<Interval>() {
                @Override
                public int compare(Interval o1, Interval o2) {
                    return o1.start - o2.start;
                }
            });
            for (Interval interval : intervals) {
                if (ans.isEmpty()) {
                    ans.push(interval);
                } else {
                    Interval tmp = ans.peek();
                    if (interval.start >= tmp.start && interval.start <= tmp.end) {
                        // combine
                        ans.pop();
                        ans.push(new Interval(tmp.start, tmp.end > interval.end ? tmp.end : interval.end));
                    } else {
                        ans.push(interval);
                    }
                }
            }
            return new LinkedList<>(ans);
        }
    }

    /**
     * from leetcode discuss
     */
    static class Solution2 {
        public List<Interval> merge(List<Interval> intervals) {
            int n = intervals.size();
            int[] start = new int[n];
            int[] end = new int[n];

            for(int i=0;i<n;i++){
                start[i] = intervals.get(i).start;
                end[i] = intervals.get(i).end;
            }

            Arrays.sort(start);
            Arrays.sort(end);

            List<Interval> ans = new ArrayList<>();
            for(int i=0,startIter = 0;i<n;i++){
                if(i == n-1 || end[i] < start[i+1]){
                    ans.add(new Interval(start[startIter],end[i]));
                    startIter = i+1;
                }
            }
            return ans;
        }
    }

    static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}
