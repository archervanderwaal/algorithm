package me.stormma.leetcode.graph;

import java.util.*;

/**
 * 单源有向带权最短路径问题: Dijkstra's Algorithm
 * 难度系数: 三星
 * leetcode 743. Network Delay Time
 * @author stormma
 * @date 2018/03/27
 */
public class Question743 {


    static class Solution {
        public int networkDelayTime(int[][] times, int N, int K) {
            Map<Map<Integer, Integer>, Integer> weight = new HashMap<>();
            for (int i = 0; i < times.length; i++) {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(times[i][0], times[i][1]);
                weight.put(map, times[i][2]);
            }
            List<Integer>[] adj = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                adj[i] = new ArrayList<>();
            }
            for (int i = 0; i < times.length; i++) {
                adj[times[i][0]].add(times[i][1]);
            }
            int[] dist = new int[N + 1];
            int[] path = new int[N + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            Arrays.fill(path, -1);
            dist[K] = 0;
            for (Integer v : adj[K]) {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(K, v);
                dist[v] = weight.get(map);
                path[v] = K;
            }
            Queue<Node> heap = new PriorityQueue<>((a, b) -> {return a.dist - b.dist;});
            for (int i = 1; i <= N; i++) {
                if (i != K) {
                    heap.add(new Node(i, dist[i]));
                }
            }
            boolean[] visited = new boolean[N + 1];
            visited[K] = true;
            dijkstra(K, dist, path, heap, adj, visited, weight);
            int ans = Integer.MIN_VALUE;
            for (int i = 1; i <= N; i++) {
                ans = Math.max(ans, dist[i]);
            }
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }

        private void dijkstra(int source, int[] dist, int[] path, Queue<Node> heap, List<Integer>[] adj
                , boolean[] visited, Map<Map<Integer, Integer>, Integer> weight) {
            while (true) {
                if (heap.isEmpty()) break;
                Node node = heap.poll();
                int v = node.idx;
                visited[v] = true;
                for (Integer w : adj[v]) {
                    if (!visited[w]) {
                        Map<Integer, Integer> map = new HashMap<>();
                        map.put(v, w);
                        if (dist[v] + weight.get(map) < dist[w]) {
                            heap.remove(new Node(w, dist[w]));
                            dist[w] = dist[v] + weight.get(map);
                            path[w] = v;
                            heap.add(new Node(w, dist[w]));
                        }
                    }
                }
            }
        }

        static class Node {
            int idx;
            int dist;

            public Node(int idx, int dist) {
                this.idx = idx;
                this.dist = dist;
            }
        }
    }
}
