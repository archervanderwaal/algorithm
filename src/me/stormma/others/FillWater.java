package me.stormma.others;

import java.util.Arrays;

/**
 * @author stormma stormmaybin@gmail.com
 */
public class FillWater {

    /**
     * init array L, V, R => L[0] = R[n - 1] = 0;
     * if L[i - 1] > V[i - 1] => L[i] = L[i - 1]
     * if L[i - 1] <= V[i - 1] => L[i] = V[i - 1]
     * In summary:
     * L[i] = max(L[i - 1], V[i - 1]) (i > 0)
     * R[i] = max(R[i + 1], V[i + 1]) (i < n - 1)
     *
     * @param footstep
     * @return
     */
    public int getResult(int[] footstep) {
        int ans = 0;
        int[] v;
        if ((v = footstep) == null || v.length < 3) {
            return ans;
        }
        int[] l = new int[v.length];
        int[] r = new int[v.length];
        l[0] = r[v.length - 1] = 0;
        for (int i = 1; i < v.length; i++) {
            l[i] = Math.max(l[i - 1], v[i - 1]);
        }
        for (int i = v.length - 2; i > -1; i--) {
            r[i] = Math.max(r[i + 1], v[i + 1]);
        }
        // calculate
        for (int i = 1; i < v.length - 1; i++) {
            ans += (Math.min(l[i] - v[i], r[i] - v[i]) < 0 ? 0 : Math.min(l[i] - v[i], r[i] - v[i]));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] footstep = {2, 5, 1, 3, 1, 2, 1, 7, 7, 6};
        System.out.println(new FillWater().getResult(footstep));
    }
}
