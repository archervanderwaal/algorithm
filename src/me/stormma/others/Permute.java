package me.stormma.others;

import java.util.ArrayList;
import java.util.List;

/**
 * 排列问题, dfs
 *
 * @author stormma
 * @date 2017/11/15
 */
public class Permute {

    public List<List<Integer>> permute(int[] numbers) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<>(), numbers, new boolean[numbers.length], 0);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> tmp, int[] numbers, boolean[] visited, int n) {
        if (n == numbers.length) {
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                // 1 2 2 2 3
                // 有重复元素的全排列
                if (i > 0 && numbers[i] == numbers[i - 1] && !visited[i - 1]) {
                    continue;
                }
                tmp.add(numbers[i]);
                visited[i] = true;
                dfs(ans, tmp, numbers, visited, n + 1);
                visited[i] = false;
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 1, 2};
        System.out.println(new Permute().permute(numbers));
    }
}
