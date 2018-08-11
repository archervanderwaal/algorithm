package me.stormma.nowcoder.wangyi._2019;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author stormma stormmaybin@gmail.com
 */
public class Question1 {

    static class Job {
        int di;
        int pi;
    }

    static class Student {
        int ai;
        int index;
    }

    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(), M = in.nextInt();
        Job[] jobs = new Job[N];
        Student[] students = new Student[M];
        int[] ans = new int[M];
        for (int i = 0; i < N; i++) {
            jobs[i] = new Job();
            jobs[i].di = in.nextInt();
            jobs[i].pi = in.nextInt();
        }
        for (int i = 0; i < M; i++) {
            students[i] = new Student();
            students[i].ai = in.nextInt();
            students[i].index = i;
        }
        Arrays.sort(jobs, (o1, o2) -> {
            if (o1.di == o2.di) return o1.pi - o2.pi;
            return o1.di - o2.di;
        });
        Arrays.sort(students, Comparator.comparingInt(s -> s.ai));
        int res = 0;
        for (int i = 0, j = 0; i < M; i++) {
            while (j < N && students[i].ai >= jobs[j].di) {
                res = Math.max(res, jobs[j].pi);
                j++;
            }
            ans[students[i].index] = res;
        }
        for (int i = 0; i < M; i++) {
            System.out.println(ans[i]);
        }
    }
}
