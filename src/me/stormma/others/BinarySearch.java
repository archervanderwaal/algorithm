package me.stormma.others;

/**
 * @author stormma stormmaybin@gmail.com
 */
public class BinarySearch {
    /**
     * 找出大于等于target的最小索引, numbers[i] >= target, min(i)
     * @param numbers
     * @param target
     * @return
     */
    public static int lowerBound(int[] numbers, int target) {
        // 采用[left, right)区间
        if (numbers == null || numbers.length == 0) return -1;
        int left = 0, right = numbers.length;
        while (left < right) { // left == right跳出循环
            int mid = left + ((right - left) >>> 1);
            if (numbers[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 返回target出现的最后一个位置的下一个位置, 如果target不在数组中, 则返回应该插入的位置
     * 即: numbers[i] > target, min(i)
     * @param numbers
     * @param target
     * @return
     */
    public static int upperBound(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) return -1;
        int left = 0, right = numbers.length;
        while (left < right) {
            int mid = left + ((right - left) >>> 1);
            if (numbers[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 3, 4, 5, 6};
        System.out.println(lowerBound(numbers, 7));
        System.out.println(upperBound(numbers, 3));
    }
}
