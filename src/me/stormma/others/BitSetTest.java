package me.stormma.others;

import java.util.BitSet;

public class BitSetTest {

    public static void main(String[] args) {
        int[] sources = {9, 2, 1, 6, 11};
        int max = 0x80000000;
        for (int source : sources) {
            if (source > max) {
                max = source;
            }
        }
        BitSet bitSet = new BitSet(max + 1);
        for (int source : sources) {
            bitSet.set(source, true);
        }
        System.out.println(bitSet);
    }
}
