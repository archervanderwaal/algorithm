package me.stormma.others;

/**
 * @author stormma stormmaybin@gmail.com
 */
public class QuickSort {

    public static void sort(int[] numbers) {
        if (numbers == null || numbers.length < 2) return;
        quickSort(numbers, 0, numbers.length - 1);
    }

    private static void quickSort(int[] numbers, int left, int right) {
        if (left < right) {
            int j = partition(numbers, left, right);
            quickSort(numbers, left, j - 1);
            quickSort(numbers, j + 1, right);
        }
    }

    private static int partition(int[] numbers, int left, int right) {
        int pivot = numbers[left];
        while (left < right) {
            while (left < right && numbers[right] >= pivot) {
                right--;
            }
            numbers[left] = numbers[right];
            while (left < right && numbers[left] <= pivot) {
                left++;
            }
            numbers[right] = numbers[left];
        }
        numbers[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        int[] numbers = {5, 4, 3, 2, 1};
        sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
}
