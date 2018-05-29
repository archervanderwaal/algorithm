package me.stormma.nowcoder.daily;

/**
 * @author stormma stormmaybin@gmail.com
 */
public class Manacher {

    public static int[] manacher(String string) {
        if (string == null || string.length() < 1) return null;
        StringBuilder stringBuilder = new StringBuilder("$#");
        for (int i = 0; i < string.length(); i++) {
            stringBuilder.append(string.charAt(i));
            stringBuilder.append("#");
        }
        System.out.println(stringBuilder.toString());
        int[] p = new int[stringBuilder.length()];
        int mx = 0, id = 0;
        for (int i = 1; i < p.length; i++) {
            if (mx > i) {
                p[i] = Math.min(p[2 * id - i], mx - i);
            } else {
                p[i] = 1;
            }
            while (i + p[i] < p.length && i - p[i] >= 0 && stringBuilder.charAt(i + p[i]) == stringBuilder.charAt(i - p[i])) {
                p[i]++;
            }
            if (p[i] + i > mx) {
                mx = p[i] + i;
                id = i;
            }
        }
        return p;
    }

    public static void main(String[] args) {
        String string = "12212321";
        int[] p = manacher(string);
        for (int i = 0; i < p.length; i++) {
            System.out.print(p[i] + " ");
        }
        System.out.println();
    }
}
