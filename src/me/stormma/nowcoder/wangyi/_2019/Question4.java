package me.stormma.nowcoder.wangyi._2019;

import java.util.Scanner;

/**
 * @author stormma stormmaybin@gmail.com
 */
public class Question4 {
    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        String string = in.next();
        int ans = 0;
        char[] chars = {'N', 'E', 'S', 'W'};
        for (char c : string.toCharArray()) {
            ans = (ans + (c == 'L' ? -1 : 1) + 4) % 4;
        }
        System.out.println(chars[ans % 4]);
    }
}
