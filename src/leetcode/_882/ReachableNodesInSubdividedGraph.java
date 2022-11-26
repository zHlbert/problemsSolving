package leetcode._882;

import java.util.*;

public class ReachableNodesInSubdividedGraph {

    /**
     * Dijkstra
     * @param edges
     * @param maxMoves
     * @param n
     * @return
     */
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        List<int[]>[] adList = new List[n];
        for (int i = 0; i < n; i++) {
            adList[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], nodes = edge[2];
            adList[u].add(new int[] {v, nodes});
            adList[v].add(new int[] {u, nodes});
        }
        Map<Integer, Integer> used = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        int res = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[] {0, 0});

        while (!pq.isEmpty() && pq.peek()[0] <= maxMoves) {
            int[] pair = pq.poll();
            int step = pair[0], u = pair[1];
            if (!visited.add(u)) {
                continue;
            }
            res++;
            for (int[] next : adList[u]) {
                int v = next[0], nodes = next[1];
                if (nodes + step + 1 <= maxMoves && !visited.contains(v)) {
                    pq.offer(new int[] {nodes + step + 1, v});
                }
                used.put(encode(u, v, n), Math.min(nodes, maxMoves - step));
            }
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], nodes = edge[2];
            res += Math.min(nodes, used.getOrDefault(encode(u, v, n), 0) + used.getOrDefault(encode(v, u, n), 0));
        }
        return res;
    }

    private Integer encode(int u, int v, int n) {
        return n * u + v;
    }
}
