package me.stormma.others;

import me.stormma.leetcode.array.Question56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Bytedance2 {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int x = in.nextInt();
        List<Interval> intervals = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            String[] strings = in.next().split(";");
            for (String str : strings) {
                intervals.add(new Interval(Integer.parseInt(str.split(",")[0]), Integer.parseInt(str.split(",")[1])));
            }
        }
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0; i < n; i++){
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        List<Interval> ans = new ArrayList<>();
        for(int i = 0, startIter = 0; i < n; i++){
            if(i == n - 1 || end[i] < start[i + 1]){
                ans.add(new Interval(start[startIter], end[i]));
                startIter = i + 1;
            }
        }
        boolean sta = true;
        for (Interval interval : ans) {
            if (!sta) System.out.print(";");
            System.out.print(interval.start + "," + interval.end);
            sta = false;
        }
    }

    static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}
