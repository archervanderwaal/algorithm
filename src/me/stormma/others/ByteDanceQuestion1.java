package me.stormma.others;

import java.util.ArrayList;
import java.util.List;

/**
 * @brief 今日头条面试题目
 * @author stormma stormmaybin@gmail.com
 */
public class ByteDanceQuestion1 {

    private static int i = 0;

    /**
     * 1, 3, 6, 4, 2, 7   sum = 7, [3, 4] [7] [1, 6]
     * 返回数组中元素和等于sum的结果
     * @param numbers
     * @param sum
     * @return
     */
    public static List<List<Integer>> solve(int[] numbers, int sum) {
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, current, 0, numbers, sum);
        return ans;
    }

    /**
     * 深搜答案
     * @param ans
     * @param current
     * @param startIndex
     * @param numbers
     * @param sum
     */
    private static void dfs(List<List<Integer>> ans, List<Integer> current, int startIndex, int[] numbers, int sum) {
        if (sum == 0) {
            ans.add(new ArrayList<>(current));
        }
        for (int i = startIndex; i < numbers.length; i++) {
            current.add(numbers[i]);
            dfs(ans, current, i + 1, numbers, sum - numbers[i]);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        List<List<Integer>> ans = solve(numbers, 7);
        for (List<Integer> list : ans) {
            System.out.println(list);
        }
    }
}

// ======================> 加强版
// 如果一个元素可以选择多次, 那么结果会怎么样呢
