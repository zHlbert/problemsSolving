package contest.leetcode20220731;

import utils.ArrayUtils;

import java.util.*;

/**
 * https://leetcode.cn/problems/find-closest-node-to-given-two-nodes/
 */
public class FindClosestNodeToGivenTwoNodes {
    /**
     * BFS
     * @param edges
     * @param node1
     * @param node2
     * @return
     */
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] d1 = getDis(node1, edges, n);
        int[] d2 = getDis(node2, edges, n);
//        ArrayUtils.printArray(d1);
//        ArrayUtils.printArray(d2);
        int minD = Integer.MAX_VALUE;
        int minI = -1;
        for (int i = 0; i < n; i++) {
            if (d1[i] != -1 && d2[i] != -1) {
                int d = Math.max(d1[i], d2[i]);
                if (d < minD) {
                    minD = d;
                    minI = i;
                }
            }
        }
        return minI;
    }

    private int[] getDis(int node, int[] edges, int n) {
        boolean[] visited = new boolean[n];
        int[] dis = new int[n];
        Arrays.fill(dis, -1);
        visited[node] = true;
        dis[node] = 0;
        int d = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (edges[u] != -1) {
                int v = edges[u];
                if (v != -1 && !visited[v]) {
                    queue.offer(v);
                    visited[v] = true;
                    dis[v] = d;
                }
                d++;
            }
        }
        return dis;
    }

    public static void main(String[] args) {
        FindClosestNodeToGivenTwoNodes fc = new FindClosestNodeToGivenTwoNodes();
        int[] edges = new int[] {2,2,3,-1};
        int node1 = 0, node2 = 1;
//        int[] edges = new int[] {1,2,-1};
//        int node1 = 0, node2 = 2;
        System.out.println(fc.closestMeetingNode(edges, node1, node2));
    }
}
