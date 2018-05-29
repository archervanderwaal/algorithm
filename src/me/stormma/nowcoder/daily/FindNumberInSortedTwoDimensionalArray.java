package me.stormma.nowcoder.daily;

/**
 * @brief 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author stormma stormmaybin@gmail.com
 */
public class FindNumberInSortedTwoDimensionalArray {

    public static boolean Find(int target, int [][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) return false;
        int m = array.length, n = array[0].length;
        int row = 0, column = n - 1;
        while (row < m && column >= 0) {
            if (array[row][column] == target) {
                return true;
            }
            if (array[row][column] < target) {
                row++;
            } else {
                column--;
            }
        }
        return false;
    }
}
