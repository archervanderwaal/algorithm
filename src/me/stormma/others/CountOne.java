package me.stormma.others;

/**
 * 统计整数的位数为1的个数
 * @author stormma
 * @date 2018/03/07
 */
public class CountOne {

    public int countOne(int n) {
        int cnt = 0;
        while (n != 0) {
            if (n % 2 == 1) cnt++;
            n >>= 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int n = 227827827;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(new CountOne().countOne(n));
    }
}
