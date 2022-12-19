package leetcode._1971;

import java.util.ArrayList;
import java.util.Arrays;

public class FindIfPathExistsInGraph {
    ArrayList<Integer>[] graph;
    boolean[] visited;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[n];

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        return dfs(source, destination);
    }

    private boolean dfs(int source, int destination) {
        visited[source] = true;
        if (source == destination) {
            return true;
        }
        for (int nx : graph[source]) {
            if (!visited[nx] && dfs(nx, destination)) return true;
        }
        return false;
    }

    // 并查集
    int[] p;
    public boolean validPath1(int n, int[][] edges, int source, int destination) {
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }

        for (int[] edge : edges) {
            p[find(edge[0])] = find(edge[1]);
        }

        return find(source) == find(destination);
    }

    private int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    public static void main(String[] args) {
        FindIfPathExistsInGraph fp = new FindIfPathExistsInGraph();
        int n = 3;
        int[][] edges = new int[][] {{0,1},{1,2},{2,0}};
        int source = 0, destination = 2;
        System.out.println(fp.validPath1(n, edges, source, destination));
    }
}
