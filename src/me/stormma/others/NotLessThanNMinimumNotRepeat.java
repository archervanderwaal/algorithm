package me.stormma.others;

/**
 * @brief 百度笔试题目
 * 如果一个数字十进制表达时，不存在连续两位相同，则称之为“不重复数”。
 * 例如，105、1234和12121都是“不重复数”，而11、100和1225不是。给定一个正整数A，返回大于A的最小“不重复数”。A小于100000
 * 这个题目是华为编程中的。只是 这里不是大于，而是不小于。处理方式是一样的。
 * @author stormma stormmaybin@gmail.com
 */
public class NotLessThanNMinimumNotRepeat {
    public static int solve(int n) {
        String string = "0" + n;
        boolean first = true;
        int i = 1;
        char[] chars = string.toCharArray();
        while (true) {
            if (i < 0) break;
            while (i + 1 < chars.length && chars[i + 1] != chars[i]) {
                i++;
            }
            // 如果是第一次扫描发现原数本身就是一个不重复数，则在其最低位+1
            // +1时进行判断，如果个位为9，则变为0，再进位，否则直接+1
            // +1后判断会不会跟前一位重复
            if ((i == chars.length - 1) && first) {
                if (chars[i] == '9') {
                    chars[i] = '0';
                    i--;
                }
                chars[i] += 1;
                i--;
                first = false;
                continue;
            } else if (i == chars.length - 1) {
                break;
            }
            if (chars[i + 1] == '9') {
                chars[i + 1] = '0';
                i--;
                chars[i + 1] = '0';
                i--;
                chars[i + 1] += 1;
            } else {
                chars[i + 1] += 1;
                i += 2;
                change(chars, i, chars.length - 1);
                break;
            }
        }
        return Integer.parseInt(new String(chars));
    }

    private static void change(char[] chars, int start, int end) {
        boolean flag = true;
        for (int i = start; i <= end; i++) {
            chars[i] = flag ? '0' : '1';
            flag = !flag;
        }
    }

    public static void main(String[] args) {
        int i = 9;
        System.out.println(solve(i));
    }
}
