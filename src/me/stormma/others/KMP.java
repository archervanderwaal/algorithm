package me.stormma.others;

/**
 * @author stormma stormmaybin@gmail.com
 */
public class KMP {

    private static void next(String pattern, int[] next) {
        next[0] = -1;
        int i = 0, j = -1;
        while (i < pattern.length()) {
            if (j == -1 || pattern.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
    }

    public static int kmp(String txt, String pattern) {
        int[] next = new int[pattern.length() + 1];
        next(pattern, next);
        int i = 0, j = 0;
        while (i < txt.length()) {
            if (j == -1 || txt.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
            if (j == pattern.length()) {
                return i - pattern.length();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(kmp("123456767", "6767"));
    }
}
