package contest.leetcode20220625;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode.cn/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/
 */
public class CountUnreachablePairsOfNodesInAnUndirectedGraph {
    boolean[] visited;
    List<Integer>[] nodeEdges;
    int n;
    public long countPairs(int n, int[][] edges) {
        this.n = n;
        nodeEdges = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            nodeEdges[i] = new ArrayList<>();
        }

        visited = new boolean[n];

        for (int[] edge : edges) {
            nodeEdges[edge[0]].add(edge[1]);
            nodeEdges[edge[1]].add(edge[0]);
        }

        long total = (long) n * (n - 1) / 2;

        long reachedPairs = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int nodes = bfs(i);
                reachedPairs += (long) nodes * (nodes - 1) / 2;
            }
        }
        return total - reachedPairs;
    }

    private int bfs(int v) {
        int reachedNodes = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(v);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            List<Integer> nodeEdge = nodeEdges[cur];
            if (nodeEdge.isEmpty()) {
                continue;
            }
            for (int nv : nodeEdge) {
                if (!visited[nv]) {
                    queue.offer(nv);
                    visited[nv] = true;
                    reachedNodes++;
                }
            }
        }
        return reachedNodes;
    }

    public static void main(String[] args) {
        CountUnreachablePairsOfNodesInAnUndirectedGraph cup = new CountUnreachablePairsOfNodesInAnUndirectedGraph();
        int n = 7;
        int[][] edges = new int[][] {{0,2},{0,5},{2,4},{1,6},{5,4}};
        System.out.println(cup.countPairs(n, edges));
    }
}
