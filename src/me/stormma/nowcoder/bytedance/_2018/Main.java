package me.stormma.nowcoder.bytedance._2018;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            Map<Integer, Integer> map = new HashMap<>();
            int n = in.nextInt();
            int k = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            Arrays.sort(nums);
            int pos1 = 0, pos2 = 1, cnt = 0;
            while (pos2 < n) {
                if (nums[pos2] - nums[pos1] < k) {
                    pos2++;
                } else if (nums[pos2] - nums[pos1] > k) {
                    pos1++;
                } else {
                    if (map.get(nums[pos1]) == null || map.get(nums[pos1]) != nums[pos2]) {
                        cnt++;
                        map.put(nums[pos1], nums[pos2]);
                    }
                    pos1++;
                    pos2++;
                }
            }
            System.out.println(cnt);
        }
    }
}