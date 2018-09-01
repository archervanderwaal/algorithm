package me.stormma.others;

/**
 * @author stormma archer.vanderwaal@gmail.com
 * float convert to binary string.
 */
public class FloatToBinaryString {

    //public class FloatToBinary {
    //          public static void main(String[] args) {
    //                  float f1=8.5f;
    //                  System.out.println("f1底层数据(十进制)："+Float.floatToIntBits(f1));
    //          		int int1 = Float.floatToIntBits(f1);
    //                  System.out.println("f1底层数据(二进制)："+Integer.toBinaryString(int1));
    //      	}
    // }
    // 打印结果：f1底层数据(十进制)：1091043328f1底层数据(二进制)：1000001000010000000000000000000

    public static String convert(float f) {

        // float
        // S EEEEEEEE MMMMMMMM MMMMMMMM MMMMMMMM MMMMMMM
        String fString = Float.toString(f);
        int S = f < 0 ? 0 : 1; // sign






        int i;
        System.out.println(i = Float.floatToIntBits(f));
        return Integer.toBinaryString(i);
    }

    public static void main(String[] args) {
        System.out.println(convert(8.5f));
    }
}
