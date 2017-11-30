package me.stormma.xdoj;

import java.util.*;

public class Main2 {

    private static List<Bound> bounds = new ArrayList<>();

    static {
        bounds.add(new Bound(90, 100, 4.0f));
        bounds.add(new Bound(85, 89, 3.7f));
        bounds.add(new Bound(82, 84, 3.3f));
        bounds.add(new Bound(78, 81, 3.0f));
        bounds.add(new Bound(75, 77, 2.7f));
        bounds.add(new Bound(72, 74, 2.3f));
        bounds.add(new Bound(69, 71, 2.0f));
        bounds.add(new Bound(66, 68, 1.7f));
        bounds.add(new Bound(63, 65, 1.5f));
        bounds.add(new Bound(60, 62, 1.0f));
        bounds.add(new Bound(0, 59, 0.0f));
    }

    static class Bound {
        int low;
        int high;
        float gpa;

        public Bound(int low, int high, float gpa) {
            this.low = low;
            this.high = high;
            this.gpa = gpa;
        }
    }

    static class Score {
        String courseName;

        float credits;

        int score;

        public Score(String courseName, float credits, int score) {
            this.courseName = courseName;
            this.credits = credits;
            this.score = score;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        Map<String, Score> courses = new HashMap<>();
        for (int i = 1; i <= count; i++) {
            String[] strings = {in.next(), in.next(), in.next()};
            if (courses.containsKey(strings[0])) {
                if (Integer.parseInt(strings[2]) > courses.get(strings[0]).score) {
                    courses.put(strings[0], new Score(strings[0], Float.parseFloat(strings[1]), Integer.parseInt(strings[2])));
                }
            } else {
                courses.put(strings[0], new Score(strings[0], Float.parseFloat(strings[1]), Integer.parseInt(strings[2])));
            }
        }
        float scoreSum = 0.0f, creditSum = 0.0f, gpa = 0.0f, avScore = 0.0f;
        for (String key: courses.keySet()) {
            scoreSum += courses.get(key).score;
            creditSum += courses.get(key).credits;
        }
        for (String key: courses.keySet()) {
            int score = courses.get(key).score;
            for (Bound bound : bounds) {
                if (score >= bound.low && score <= bound.high) {
                    gpa += courses.get(key).credits * bound.gpa / creditSum;
                    avScore += courses.get(key).credits * score / creditSum;
                }
            }
        }

        System.out.printf("%.1f", avScore);
        System.out.println();
        System.out.printf("%.2f", gpa);
    }
}
