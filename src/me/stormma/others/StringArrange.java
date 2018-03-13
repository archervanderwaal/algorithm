package me.stormma.others;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入abc
 * 输出:
 * abc acb bac bca cab cba
 * 字符串全排列问题
 * @author stormma
 * @date 2018/03/10
 */
public class StringArrange {

    public void search(char[] perm, int from, int to, List<String> ans) {
        if (to <= 0) return;
        if (from == to) {
            ans.add(new String(perm));
        } else {
            for (int i = from; i <= to; i++) {
                swap(perm, i, from);
                search(perm, from + 1, to, ans);
                swap(perm, i, from);
            }
        }
    }

    private void swap(char[] perm, int i, int j) {
        char tmp = perm[i];
        perm[i] = perm[j];
        perm[j] = tmp;
    }

    public static void main(String[] args) {
        char[] perm = "abc".toCharArray();
        List<String> ans = new ArrayList<>();
        new StringArrange().search(perm, 0, perm.length - 1, ans);
        System.out.println(ans);
    }
}
