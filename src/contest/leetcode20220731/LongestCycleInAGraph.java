package contest.leetcode20220731;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/longest-cycle-in-a-graph/
 */
public class LongestCycleInAGraph {
    int res = -1;

    /**
     * DFS
     * @param edges
     * @return
     */
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int[] ind = new int[n];
        for (int edge : edges) {
            if (edge != -1) {
                ind[edge]++;
            }
        }
        boolean[] visited = new boolean[n];
        Map<Integer, Integer> dis;
        for (int i = 0; i < n; i++) {
            if (ind[i] != 0 && !visited[i]) {
                dis = new HashMap<>();
                dfs(visited, edges, dis, i, 0);
            }
        }

        return res;
    }

    private void dfs(boolean[] visited, int[] edges, Map<Integer, Integer> dis, int node, int d) {
        if (visited[node]) {
            res = Math.max(res, d - dis.getOrDefault(node, d + 1));
            return;
        }
        visited[node] = true;
        dis.put(node, d);
        if (edges[node] != -1) {
            dfs(visited, edges, dis, edges[node], d + 1);
        }
    }

    // TODO: 2022/7/31 BFS

    public static void main(String[] args) {
        LongestCycleInAGraph lc = new LongestCycleInAGraph();
//        int[] edges = new int[] {3,3,4,2,3};
        int[] edges = new int[] {2,-1,3,1};
//        int[] edges = new int[] {4,3,3,4,7,2,3,3};
        System.out.println(lc.longestCycle(edges));
    }
}