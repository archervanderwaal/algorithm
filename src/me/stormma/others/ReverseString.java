package me.stormma.others;

/**
 * 题目 给定字符串,
 * 如:
 *
 * abcdef
 * 前m个字符旋转到字符串尾部
 *
 * 变成
 * cdefab
 *
 * 要求时间复杂度 O(n)空间复杂度O(1)
 */
public class ReverseString {

    public void reverseString(char[] str, int from, int to) {
        // abcd
        //
        while (from < to) {
           char tmp = str[from];
           str[from++] = str[to];
           str[to--] = tmp;
        }
    }

    public String leftRotateString(String str, int m) {
        m %= str.length();
        char[] res = str.toCharArray();
        reverseString(res, 0, m - 1);
        reverseString(res, m, res.length - 1);
        reverseString(res, 0, res.length - 1);
        return new String(res);
    }

    public static void main(String[] args) {
        String str = "abcdef";
        System.out.println(new ReverseString().leftRotateString(str, 2));
    }
}
