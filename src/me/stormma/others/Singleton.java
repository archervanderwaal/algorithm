package me.stormma.others;

import java.util.Arrays;

public class Singleton {

    private static volatile Singleton instance = null;

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static String solve(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }
        String[] strings = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strings[i] = numbers[i] + "";
        }
        Arrays.sort(strings);
        StringBuilder ans = new StringBuilder();
        for (String num : strings) {
            ans.append(num);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
    }
}
