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

    private void reverseString(char[] str, int from, int to) {
        while (from < to) {
           char tmp = str[from];
           str[from++] = str[to];
           str[to--] = tmp;
        }
    }

    /**
     * 将chars的前m个字符移动到字符串后面
     * @param chars
     * @param m
     */
    public String solve1(char[] chars, int m) {
        for (int i = 1; i <= m; i++) {
            char t = chars[0];
            for (int j = 1; j < chars.length; j++) {
                chars[j - 1] = chars[j];
            }
            chars[chars.length - 1] = t;
        }
        return new String(chars);
    }

    public String solve2(char[] chars, int m) {
        m %= chars.length;
        reverseString(chars, 0, m - 1);
        reverseString(chars, m, chars.length - 1);
        reverseString(chars, 0, chars.length - 1);
        return new String(chars);
    }

    public static void main(String[] args) {
        String str = "abcdef";
        System.out.println(new ReverseString().solve2(str.toCharArray(), 3));
        System.out.println(new ReverseString().solve1(str.toCharArray(), 3));
    }
}
