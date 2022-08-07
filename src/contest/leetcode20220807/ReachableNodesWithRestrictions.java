package contest.leetcode20220807;

import java.util.*;

public class ReachableNodesWithRestrictions {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<Integer>[] trees = new List[n];
        for (int i = 0; i < n; i++) {
            trees[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            trees[edge[0]].add(edge[1]);
            trees[edge[1]].add(edge[0]);
        }

        Set<Integer> rSet = new HashSet<>();
        for (int i : restricted) {
            rSet.add(i);
        }

        int res = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer node = queue.poll();
                res++;
                visited[node] = true;
                for (Integer next : trees[node]) {
                    if (rSet.contains(next) || visited[next]) {
                        continue;
                    }
                    queue.offer(next);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ReachableNodesWithRestrictions rn = new ReachableNodesWithRestrictions();
        int n = 10;
        int[][] edges = new int[][] {{4,1},{1,3},{1,5},{0,5},{3,6},{8,4},{5,7},{6,9},{3,2}};
        int[] restricted = new int[] {2,7};
        System.out.println(rn.reachableNodes(n, edges, restricted));
    }
}
