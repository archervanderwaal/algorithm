package me.stormma.nowcoder.bytedance._2018;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Question4 {

    static class Main {
        static final Scanner in = new Scanner(System.in);
        public static void main(String[] args) {
            while (in.hasNext()) {
                int n = in.nextInt();
                int m = in.nextInt();
                Set<Integer> setN = new HashSet<>();
                Set<Integer> setM = new HashSet<>();
                long sumN = 0;
                for (int i = 0; i < n; i++) {
                    int val = in.nextInt();
                    sumN += val;
                    setN.add(val);
                }
                long sumM = 0;
                double avgN = (sumN * 1.0) / n;
                for (int i = 0; i < m; i++) {
                    int val = in.nextInt();
                    sumM += val;
                    setM.add(val);
                }
                double avgM = (sumM * 1.0) / m;
                int cnt = 0;
                if (avgN < avgM) {
                    for (Integer integer : setM) {
                        if ((integer * 1.0) >= avgN && (integer * 1.0) <= avgM) {
                            if (!setN.contains(integer)) {
                                cnt++;
                            }
                        }
                    }
                } else {
                    for (Integer integer : setN) {
                        if ((integer * 1.0) >= avgM && (integer * 1.0) <= avgN) {
                            if (!setM.contains(integer)) {
                                cnt++;
                            }
                        }
                    }
                }
                System.out.println(cnt);
            }
        }
    }
}
