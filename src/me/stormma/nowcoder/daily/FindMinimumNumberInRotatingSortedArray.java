package me.stormma.nowcoder.daily;

/**
 * @author stormma stormmaybin@gmail.com
 * @brief 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，
 * 该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class FindMinimumNumberInRotatingSortedArray {

    public int minNumberInRotateArray(int[] array) {
        // 边界条件处理, 如果不是有序数组的旋转数组, 也不予处理
        if (array == null || array.length == 0 || array[0] < array[array.length - 1]) return 0;
        int low = 0, high = array.length - 1;
        int res = array[0];
        // bis
        while (low <= high) {
            int mid = low + ((high - low) >>> 1);
            if (array[mid] < res) {
                // 那么mid -> high肯定是有序的, 但是mid不一定是第二个有序数组的最小值, 此时我们应该更新res的值, 并且, 继续向左走
                res = array[mid];
                high = mid;
            } else if (array[mid] > res) {
                low = mid + 1;
            } else {
                for (int i = low; i <= high; i++) {
                    res = Math.min(array[i], res);
                }
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 0, 1, 1, 1, 1};
        System.out.println(new FindMinimumNumberInRotatingSortedArray().minNumberInRotateArray(numbers));
    }
}
