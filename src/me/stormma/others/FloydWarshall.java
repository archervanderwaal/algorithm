package me.stormma.others;

/**
 * @author stormma stormmaybin@gmail.com
 */
public class FloydWarshall {

    private int[][] cost;

    private int v;

    public void warshallFloyd() {
        for (int k = 0; k < this.v; k++) {
            for (int i = 0; i < this.v; i++) {
                for (int j = 0; j < this.v; j++) {
                    cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
                }
            }
        }
    }
}
