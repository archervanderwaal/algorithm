package me.stormma.others;

public class FindSingleChar {


    //依据题意，我们可以选取任意一个位置，
    // 然后判断是不是满足仅出现一次（和左右相比较），
    // 如果满足，那么即结果。如果并不满足，
    // 那么我们可以以这个位置分成两半来重新查找
    // （依据左右边字符的个数来判断）。

    /**
     * Input:
     * aabbccd
     * Output:
     * d
     * @param chars
     * @param left
     * @param right
     * @return
     */
    public static Character findSingleChar(char[] chars, int left, int right) {
        if (left > right) return null;
        if (chars == null || chars.length == 0) {
            throw new IllegalArgumentException("chars must be not empty!");
        }
        int mid = left + ((right - left) >>> 1);
        // aabbccd
        if (mid + 1 <= right && chars[mid] == chars[mid + 1]) {
            if ((mid - left) % 2 == 0) {
                return findSingleChar(chars, mid + 2, right);
            } else {
                return findSingleChar(chars, left, mid - 1);
            }
        } else if (mid - 1 >= left && chars[mid] == chars[mid - 1]) {
            if ((mid - left) % 2 == 0) {
                return findSingleChar(chars, left, mid - 1);
            } else {
                return findSingleChar(chars, mid + 1, right);
            }
        } else { // hint it
            return chars[mid];
        }
    }

    public static void main(String[] args) {
        System.out.println(Float.floatToIntBits(1.2f));
        System.out.println(Float.MAX_VALUE);
        System.out.println(Float.MIN_VALUE);
        System.out.println(Integer.toBinaryString(1067030938));
        System.out.println(Float.toHexString(1.2f));
        System.out.println(findSingleChar("aabbccdeeffgghhjj".toCharArray(), 0, "aabbccdeeffgghhjj".length() - 1));
    }
}
