package me.stormma.nowcoder.bytedance._2018;

import java.util.Scanner;

public class Question2 {

    static class Main {
        private static final Scanner in = new Scanner(System.in);
        public static void main(String[] args) {
//            while (in.hasNext()) {
                // s = "a", m = "a"
                // 操作1: m = s, s = s + s // s = "aa" m = "aa" s = "aaaa"
                // 操作2: s = s + m
                String[] dpS = new String[100];
                String[] dpM = new String[100];
                System.out.println("sss");
                int n = in.nextInt();
                // m = "a", s = "aa"
                // m = "aa", s = "aaaa"
                // s = s + m => s = "aaaaaa";
                dpS[1] = "aa";
                dpM[1] = "a";
                dpS[2] = "aaaa";
                dpM[2] = "aa";
                for (int i = 3; i < dpS.length; i++) {
                    String preS = dpS[i - 1];
                    String preM = dpM[i - 1];
                    String tmp1M = preS;
                    String tmp1S = preS + preS;
                    String tmp2S = preS + preM;
                    String tmp2M = preM;
                    if (tmp1S.length() >= tmp2S.length()) {
                        dpS[i] = tmp1S;
                        dpM[i] = tmp1M;
                    } else {
                        dpS[i] = tmp2S;
                        dpM[i] = tmp2M;
                    }
                }
                System.out.println(dpS[99].length());
//            }
        }

//        private int solve(String s, String m, int n) {
//
//        }

    }
}
