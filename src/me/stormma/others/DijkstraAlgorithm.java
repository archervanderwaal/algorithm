package me.stormma.others;

import java.util.Arrays;

/**
 * @brief 重新实现dijkstra算法
 * @author stormma stormmaybin@gmail.com
 */
public class DijkstraAlgorithm {

    /**顶点是否已经访问过*/
    private boolean[] visited;

    /**顶点对应的最短距离*/
    private int[] dist;

    /**图的顶点数*/
    private int v;

    /**图的边数*/
    private int e;

    /**费用*/
    private int[][] cost;

    /**
     * @param v 图的顶点数
     * @param e 图的边数
     * @param cost 费用
     */
    public DijkstraAlgorithm(int v, int e, int[][] cost) {
        this.v = v;
        this.e = e;
        this.cost = cost;
        this.dist = new int[v];
        this.visited = new boolean[v];
    }

    /**
     * dijkstra算法
     * @param source
     */
    public void dijkstra(int source) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(visited, false);
        dist[source] = 0;
        while (true) {
            int tmp = -1;
            // 从没有访问过的顶点选择一个dist最小的
            for (int u = 0; u < this.v; u++) {
                if (!visited[u] && (tmp == -1 || dist[u] < dist[tmp])) {
                    tmp = u;
                }
            }
            if (tmp == -1) break;
            visited[tmp] = true;
            for (int u = 0; u < this.v; u++) {
                dist[u] = Math.min(dist[u], dist[v] + cost[v][u]);
            }
        }
    }
}
