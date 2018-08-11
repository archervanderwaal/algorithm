package me.stormma.others;

import java.util.*;

/**
 * 变位词问题
 * 如果两个字符串中的字符一样，出现的次数也是一样的，那么认为这两个字符串是兄弟字符串，
 * 例如: bad和abd
 * 现提供一个字符串，请问如何在字典中迅速找到它的兄弟字符串
 * @author stormma
 * @date 2018/03/10
 */
public class DisplacementWord {

    /**
     * 时间复杂度 O(n*mlogm)
     * @param dict
     * @param word
     * @return
     */
    public List<String> findDisplacementWord(String[] dict, String word) {
        final Map<String, List<String>> map = new HashMap<>();
        for (String string : dict) {
            char[] tmp = string.toCharArray();
            Arrays.sort(tmp);
            String aux = new String(tmp);
            if (map.get(aux) == null) {
                List<String> list = new ArrayList<>();
                list.add(string);
                map.put(aux, list);
            } else {
                map.get(aux).add(string);
            }
        }
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return map.get(new String(chars));
    }

    public static void main(String[] args) {
        String[] dict = {"abcd", "dcab", "ssns", "cndj", "cbad"};
        System.out.println(new DisplacementWord().findDisplacementWord(dict, "bcda"));
    }
}
