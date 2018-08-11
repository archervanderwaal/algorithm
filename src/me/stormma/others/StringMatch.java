package me.stormma.others;

import java.util.Arrays;

/**
 * 从字符串匹配寻找解决算法
 * @author stormma
 * @date 2018/03/25
 */
public class StringMatch {

    /**
     * 暴力解决
     */
    static class ViolentMatch {
        public static int match(String s, String p) {
            int sLen = s.length(), pLen = p.length();
            int sIndex = 0, pIndex = 0;
            while (sIndex < sLen && pIndex < pLen) {
                if (s.charAt(sIndex) == p.charAt(pIndex)) {
                    sIndex++;
                    pIndex++;
                } else {
                    sIndex = sIndex - pIndex + 1;
                    pIndex = 0;
                }
            }
            if (pIndex == pLen) {
                return sIndex - pIndex;
            }
            return -1;
        }
    }

    static class KMP {
        public static int match(String s, String p) {
            int sLen = s.length(), pLen = p.length();
            int sIndex = 0, pIndex = 0;
            int[] next = next(p);
            while (sIndex < sLen && pIndex < pLen) {
                if (s.charAt(sIndex) == p.charAt(pIndex)) {
                    sIndex++;
                    pIndex++;
                } else {
                    pIndex = next[pIndex];
                }
            }
            if (pIndex == pLen) {
                return sIndex - pIndex;
            }
            return -1;
        }

        private static int[] next(String p) {
            int pLen = p.length();
            int[] next = new int[p.length()];
            next[0] = -1;
            int k = -1, j = 0;
            while (j < pLen - 1) {
                if (k == -1 || p.charAt(j) == p.charAt(k)) {
                    k++;
                    j++;
                    if (p.charAt(j) != p.charAt(k)) {
                        next[j] = k;
                    } else {
                        next[j] = next[k];
                    }
                } else {
                    k = next[k];
                }
            }
            return next;
        }

        public static void main(String[] args) {
            String p = "ABCDAB";
            String txt = "ABABABABCDABABCDDD";
            System.out.println(match(txt, p));
        }
    }
}
