package me.stormma.others;

import java.util.ArrayList;
import java.util.List;
/**
 * @brief String 的全排列
 * @author stormma stormmaybin@gmail.com
 */
public class PermutationOfString {

    public static List<String> solve(String s) {
        List<String> res = new ArrayList<>();
        solve(s.toCharArray(), 0, s.length() - 1, res);
        return res;
    }

    private static void solve(char[] array, int start, int end, List<String> res) {
        if (end <= 0) return;
        if (start == end) {
            res.add(String.copyValueOf(array));
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(array, i, start);
            solve(array, start + 1, end, res);
            swap(array, start, i);
        }
    }

    private static void swap(char[] array, int x, int y) {
        char temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public static void main(String[] args) {
        String string = "abc";
        for (String res : solve(string)) {
            System.out.println(res);
        }
    }
}
