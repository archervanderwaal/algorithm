package me.stormma.others;

import java.util.Scanner;

public class Main1 {

    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] num = new int[n];
        int start = 1;
        // 每堆最大的编号
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = in.nextInt();
            nums[i] = start + num[i] - 1;
            start = start + num[i];
        }
        int queryNum = in.nextInt();
        for (int i = 0; i < queryNum; i++) {
            int query = in.nextInt();
            System.out.println(search(nums, query));
        }
        // 2 9 12 16 25
    }

    private static int search(int[] nums, int query) {
        int low = 0, high = nums.length;
        if (query < nums[0]) return 1;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (query > nums[mid]) {
                low = mid + 1;
            } else if (query < nums[mid]) {
                high = mid - 1;
            } else {
                return mid + 1;
            }
        }
        return low + 2;
    }
}
