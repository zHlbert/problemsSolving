package leetcode._1615;

import java.util.HashSet;
import java.util.Set;

public class MaximalNetworkRank {
    /**
     * 邻接表存储
     * @param n
     * @param roads
     * @return
     */
    public int maximalNetworkRank(int n, int[][] roads) {
        Set<Integer>[] g = new Set[n];
        for (int i = 0; i < n; i++) {
            g[i] = new HashSet<>();
        }
        for (int[] road : roads) {
            g[road[0]].add(road[1]);
            g[road[1]].add(road[0]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Integer> r1 = g[i];
                Set<Integer> r2 = g[j];
                res = Math.max(res, r1.size() + r2.size() - (r1.contains(j) ? 1 : 0));
            }
        }
        return res;
    }

    /**
     * 邻接矩阵存储
     * @param n
     * @param roads
     * @return
     */
    public int maximalNetworkRank1(int n, int[][] roads) {
        int[][] g = new int[n][n];
        int[] cnt = new int[n];
        for (int[] road : roads) {
            cnt[road[0]]++;
            cnt[road[1]]++;
            g[road[0]][road[1]] = 1;
            g[road[1]][road[0]] = 1;
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                res = Math.max(res, cnt[i] + cnt[j] - g[i][j]);
            }
        }

        return res;
    }
}
