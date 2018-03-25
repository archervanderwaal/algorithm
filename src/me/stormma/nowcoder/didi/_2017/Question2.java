package me.stormma.nowcoder.didi._2017;

import java.util.*;

public class Question2 {

    static class Main {
        static class Dummy {
            int persons;
            int moneys;
        }
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int m = in.nextInt();
            int[] tables = new int[n];
            for (int i = 0; i < n; i++) {
                tables[i] = in.nextInt();
            }
            Arrays.sort(tables);
            Dummy[] dummies = new Dummy[m];
            for (int i = 0; i < m; i++) {
                dummies[i].persons = in.nextInt();
                dummies[i].moneys = in.nextInt();
            }
            Queue<Dummy> queue = new PriorityQueue<>(new Comparator<Dummy>() {
                @Override
                public int compare(Dummy o1, Dummy o2) {
                    return 0;
                }
            });
        }

    }
}
