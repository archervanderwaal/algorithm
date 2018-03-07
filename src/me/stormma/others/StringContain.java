package me.stormma.others;

/**
 * 给定字符串A, B
 *
 * 实现方法判断B是否在A中
 */
public class StringContain {

    /**
     * 时间复杂度O(n*m)
     * force solve
     * @param A
     * @param B
     * @return
     */
    public boolean contains1(String A, String B) {

        for (int i = 0; i < B.length(); i++) {
            boolean valid = false;
            for (int j = 0; j < A.length(); j++) {
                if (B.toCharArray()[i] == A.toCharArray()[j]) {
                    valid = true;
                }
            }
            if (!valid) {
                return false;
            }
        }
        return true;
    }

    /**
     * 时间复杂度O(n + m), 空间复杂度O(n)
     * @param A
     * @param B
     * @return
     */
    public boolean contains2(String A, String B) {
        int[] p = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59,61, 67, 71, 73, 79, 83, 89, 97, 101};
        int res = 1;
        for (int i = 0; i < A.length(); i++) {
            int x = p[A.toCharArray()[i] - 'A'];
            if (res % x != 0) {
                res *= x;
            }
        }

        for (int i = 0; i < B.length(); i++) {
            int x = p[B.toCharArray()[i] - 'A'];
            if (res % x != 0) return false;
        }
        return true;
    }

    /**
     * 时间复杂度O(n + m), 空间复杂度O(1)
     * @param A
     * @param B
     * @return
     */
    public boolean contains3(String A, String B) {
        int hash = 0;
        for (int i = 0; i < A.length(); i++) {
            hash |= (1 << (A.toCharArray()[i] - 'A'));
        }
        for (int i = 0; i < B.length(); i++) {
            if ((hash & (1 << (B.toCharArray()[i] - 'A'))) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String A = "ABCDEF";
        String B = "FAB";
        System.out.println(new StringContain().contains1(A, B));
        System.out.println(new StringContain().contains2(A, B));
        System.out.println(new StringContain().contains3(A, B));
    }
}
