package me.stormma.poj;

import java.util.*;

/**
 * 加油站问题 <a href="">题目链接</a>
 *
 * @author stormma
 * @date 2017/10/19
 */
public class Main2431 {

    private static int solve(List<Stop> stops, int L, int P) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        // ans加油次数，pos当前距起点位置，tank当前
        int ans = 0, pos = 0, tank = P;
        for (Stop stop : stops) {
            // 到下一个加油站的距离
            int dis = stop.dis - pos;
            // 如果到不了，加油
            while (tank < dis) {
                if (queue.isEmpty()) {
                    return -1;
                }
                // 加经过的加油站最大加油量的
                tank += queue.poll();
                ans++;
            }
            tank -= dis;
            // 更新当前位置
            pos = stop.dis;
            // 向优先队列中增加这个加油站的油量
            queue.add(stop.tank);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 加油站数量
        int N = in.nextInt();
        // 距离终点的距离
        List<Stop> stops = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            stops.add(new Stop(in.nextInt(), in.nextInt()));
        }
        // 起点到终点的距离
        int L = in.nextInt();
        // 起始油量数
        int P = in.nextInt();
        for (Stop stop: stops) {
            stop.dis = L - stop.dis;
        }
        // 终点当做加油站
        stops.add(new Stop(L, 0));
        Collections.sort(stops, (o1, o2) -> o1.dis - o2.dis);
        System.out.println(solve(stops, L, P));
    }

    static class Stop {
        /**加油站距离起始位置的距离*/
        int dis;

        /**加油站一次可以加的油*/
        int tank;

        public Stop(int dis, int tank) {
            this.dis = dis;
            this.tank = tank;
        }
    }
}