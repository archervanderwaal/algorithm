package me.stormma.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @brief 寻找一个区间, 这个区间的sum值乘以区间最小值的最大值,
 * 头条面试题目
 * @author stormma stormmaybin@gmail.com
 */
public class IntervalSumMultiIntervalMinQuestion {

    public static int solve(List<Integer> numbers) {
        if (numbers == null || numbers.size() == 0) return 0;
        /** 单调栈*/
        Stack<Integer> stack = new Stack<>();
        int res = Integer.MIN_VALUE;
        numbers.add(-1);
        // 前缀和
        int[] sum = new int[numbers.size()];
        sum[0] = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            sum[i] = sum[i - 1] + numbers.get(i);
        }
        for (int i = 0; i < numbers.size(); i++) {
            if (stack.isEmpty() || numbers.get(i) >= numbers.get(stack.peek())) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && numbers.get(stack.peek()) >= numbers.get(i)) {
                    int min = numbers.get(stack.peek()), right = i - 1;
                    stack.pop();
                    int left = stack.isEmpty() ? 0 : stack.peek() + 1;
                    res = Math.max(res, (sum[right] - (left == 0 ? 0 : sum[left - 1])) * min);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(6);
        System.out.println(solve(list));
    }
}
