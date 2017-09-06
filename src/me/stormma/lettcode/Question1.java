package me.stormma.lettcode;

import java.util.HashMap;
import java.util.Map;

public class Question1 {

    static class Solution {
        //时间复杂度 N  107ms
        int[] twoSum(int[] nums, int target) {
            int[] result = new int[2];
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums.length; j++) {
                    if (i != j && nums[i] + nums[j] == target) {
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }
                }
            }
            return null;
        }

        //时间复杂度 N 7ms 差距悬殊
        int[] twoSum2(int[] numbers, int target) {
            int[] result = new int[2];
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < numbers.length; i++) {
                if (map.containsKey(target - numbers[i])) {
                    result[1] = i;
                    result[0] = map.get(target - numbers[i]);
                    return result;
                }
                map.put(numbers[i], i);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int [] nums = {1, 2, 3};
        int target = 5;
        int[] result = new Solution().twoSum2(nums, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
