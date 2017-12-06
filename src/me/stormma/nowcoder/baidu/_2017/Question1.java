package me.stormma.nowcoder.baidu._2017;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 度度熊想去商场买一顶帽子，商场里有N顶帽子，有些帽子的价格可能相同。度度熊想买一顶价格第三便宜的帽子，问第三便宜的帽子价格是多少？
 输入描述:
 首先输入一个正整数N（N <= 50），接下来输入N个数表示每顶帽子的价格（价格均是正整数，且小于等于1000）

 输出描述:
 如果存在第三便宜的帽子，请输出这个价格是多少，否则输出-1

 输入例子
 10
 10 10 10 10 20 20 30 30 40 40

 输出例子:
 30
 *
 *
 *
 * 难度系数: 1星
 * 百度2017校招笔试第一道
 * @author stormma
 * @date 2017/12/05
 */
public class Question1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < count; i++) {
            int price = in.nextInt();
            if (!queue.contains(price)) {
                if (queue.size() < 3) {
                    queue.offer(price);
                } else {
                    queue.offer(price);
                    queue.poll();
                }
            }
        }
        System.out.println(queue.size() != 3 ? -1 : queue.poll());
    }
}
