package me.stormma.nowcoder.wangyi._2019;

import java.util.Scanner;

/**
 * @author stormma stormmaybin@gmail.com
 */
public class Question3 {

    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int size = in.nextInt();
            in.nextLine();
            String string = in.next();
            int ans = 0;
            for (int i = 0; i < string.length(); ) {
                for (; i < string.length() && string.charAt(i) == 'X'; i++) {}
                for (; i < string.length() && string.charAt(i) == '.'; ans++, i += 3) {}
            }
            System.out.println(ans);
        }
    }
}
