package me.stormma.others;

import me.stormma.lintcode.Question1;
import sun.reflect.Reflection;

import java.lang.reflect.Field;

/**
 * @author stormma
 * @date 2017/11/28
 */
public class Test {

    private static void swap(Integer a, Integer b) throws NoSuchFieldException, IllegalAccessException {
        Field field = Integer.class.getDeclaredField("value");
        field.setAccessible(true);
        int tmp = new Integer(a);
        field.setInt(a, b);
        field.setInt(b, tmp);
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Integer a  = 12, b = 13;
        swap(a, b);
        System.out.println(a + "-" + b);

        System.out.println(Reflection.getCallerClass(-1));
    }
}
