package me.stormma.nowcoder.bytedance._2018;

import java.util.Scanner;
import java.util.Stack;

public class Question3 {
    static class Main {
        static final char[][] num1 = {{'6', '6', '6', '6', '6', '.'},
                                      {'6', '.', '.', '.', '6', '.'},
                                      {'6', '.', '.', '.', '6', '.'}};
        static final Scanner in = new Scanner(System.in);
        public static void main(String[] args) {
            int n = in.nextInt();
            in.nextLine();
            for (int i = 1; i <= n; i++) {
                Stack<Integer> num = new Stack<>();
                Stack<Character> op = new Stack<>();
                String s = in.nextLine();
                char[] chars = s.toCharArray();
                int ind = 0;
                while (ind < chars.length) {
                    if (chars[ind] == '6') {
                        num.push(6);
                    } else if (chars[ind] != '*') {
                        op.push(chars[ind]);
                    } else {
                        Integer pre = num.pop();
                        Integer curr = chars[ind + 1] - '0';
                        ind++;
                        num.push(pre * curr);
                    }
                    ind++;
                }
                while (!num.isEmpty() && !op.isEmpty()) {
                    char oper = op.pop();
                    Integer curr = num.pop();
                    Integer pre = num.pop();
                    if (oper == '-') {
                        num.push(pre - curr);
                    } else {
                        num.push(pre + curr);
                    }
                }
                int ans = num.pop();
                String res = ans+"";
                for (int j = 0; j < res.length(); j++) {
                    if (res.charAt(j) == '0') {
                        System.out.println("66666.");
                        System.out.println("6...6.");
                        System.out.println("6...6.");
                        System.out.println("6...6.");
                        System.out.println("66666.");
                    } else if (res.charAt(j) == '1') {
                        System.out.println("....6.");
                        System.out.println("....6.");
                        System.out.println("....6.");
                        System.out.println("....6.");
                        System.out.println("....6.");
                    } else if (res.charAt(j) == '2') {
                        System.out.println(".66666");
                        System.out.println(".....6");
                        System.out.println(".66666");
                        System.out.println(".6....");
                        System.out.println(".66666");
                    } else if (res.charAt(j) == '3') {
                        System.out.println("66666.");
                        System.out.println("....6.");
                        System.out.println("66666.");
                        System.out.println("....6.");
                        System.out.println("66666.");
                    } else if (res.charAt(j) == '4') {
                        System.out.println("6..6..");
                        System.out.println("6..6..");
                        System.out.println("66666.");
                        System.out.println("...6..");
                        System.out.println("...6..");
                    } else if (res.charAt(j) == '5') {
                        System.out.println(".66666");
                        System.out.println(".6....");
                        System.out.println(".66666");
                        System.out.println(".....6");
                        System.out.println(".66666");
                    } else if (res.charAt(j) == '6') {
                        System.out.println(".66666");
                        System.out.println(".6....");
                        System.out.println(".66666");
                        System.out.println(".6...6");
                        System.out.println(".66666");
                    } else if (res.charAt(j) == '7') {
                        System.out.println(".66666");
                        System.out.println(".....6");
                        System.out.println(".....6");
                        System.out.println(".....6");
                        System.out.println(".....6");
                    } else if (res.charAt(j) == '8') {
                        System.out.println(".66666");
                        System.out.println(".6...6");
                        System.out.println(".66666");
                        System.out.println(".6...6");
                        System.out.println(".66666");
                    } else if (res.charAt(j) == '9') {
                        System.out.println(".66666");
                        System.out.println(".6...6");
                        System.out.println(".66666");
                        System.out.println(".....6");
                        System.out.println(".66666");
                    }
                }
            }
        }
    }
}
