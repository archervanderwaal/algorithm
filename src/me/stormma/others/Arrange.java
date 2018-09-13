package me.stormma.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arrange {

    /*
     * @param numbers
     * @param current
     * @return
     */

    public static void dfs(int[] numbers, List<Integer> current, boolean[] visited, List<List<Integer>> ans, int size) {
        if (size == numbers.length) {
            ans.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                if (i > 0 && numbers[i] == numbers[i - 1] && !visited[i - 1]) {
                    continue;
                }
                current.add(numbers[i]);
                visited[i] = true;
                dfs(numbers, current, visited, ans, size + 1);
                visited[i] = false;
                current.remove(current.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 4};
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, new ArrayList<>(), new boolean[nums.length], ans, 0);
        System.out.println(ans);
    }
}
