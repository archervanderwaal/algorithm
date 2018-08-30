package me.stormma.others;

public class FindSingleChar {

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
        System.out.println(findSingleChar("aabbccdeeffgghhjj".toCharArray(), 0, "aabbccdeeffgghhjj".length() - 1));
    }
}
