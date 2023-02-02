package leetcode._1129;

import java.util.*;

public class ShortestPathWithAlternatingColors {
//    List<Integer>[] bg, rg;
//    int n;
//    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
//        this.n = n;
//        bg = new ArrayList[n];
//        rg = new ArrayList[n];
//        for (int i = 0; i < n; i++) {
//            rg[i] = new ArrayList<>();
//            bg[i] = new ArrayList<>();
//        }
//
//        for (int[] e : redEdges)
////            if (e[0] != e[1])
//                rg[e[0]].add(e[1]);
//        for (int[] e : blueEdges)
////            if (e[0] != e[1])
//                bg[e[0]].add(e[1]);
//
//        int[] res = new int[n];
//        int[] d1 = bfs(true);
////        System.out.println();
//        int[] d2 = bfs(false);
//        for (int i = 0; i < n; i++) {
//            int d = Math.min(d1[i], d2[i]);
//            res[i] = (d == Integer.MAX_VALUE ? -1 : d);
//        }
//
//        return res;
//    }
//
//    private int[] bfs(boolean redFirst) {
//        int[] d = new int[n];
//        Arrays.fill(d, Integer.MAX_VALUE);
//        boolean[][][] visited = new boolean[n][n][2];
//        Queue<Integer> q = new ArrayDeque<>();
//        q.offer(0);
//        d[0] = 0;
//        boolean nextRed = redFirst;
////        visited[0][nextRed ? 0 : 1] = true;
//        int step = 0;
//        Set<Integer> nodes = new HashSet<>();
//        nodes.add(0);
//        while (!q.isEmpty() && nodes.size() < n) {
//            int sz = q.size();
//            for (int i = 0; i < sz; i++) {
//                int node = q.poll();
//                List<Integer> nodeList = nextRed ? rg[node] : bg[node];
//                for (Integer nx : nodeList) {
//                    boolean valid = false;
//                    for (int nnx = 0; nnx < n; nnx++) {
//                        if (!visited[nx][nnx][nextRed ? 1 : 0]) {
//                            valid = true;
//                            break;
//                        }
//                    }
//                    if (valid) {
//                        q.offer(nx);
//                        d[nx] = Math.min(d[nx], step + 1);
//                        visited[node][nx][nextRed ? 0 : 1] = true;
//                        nodes.add(nx);
//                    }
//                }
//            }
//            step++;
//            nextRed = !nextRed;
////            System.out.println(q);
//        }
////        System.out.println(Arrays.toString(d));
//        return d;
//    }

    /**
     * bfs
     * @param n
     * @param redEdges
     * @param blueEdges
     * @return
     */
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer>[][] graph = new List[2][n];
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < n; j++)
                graph[i][j] = new ArrayList<>();

        for (int[] e : redEdges)
            graph[0][e[0]].add(e[1]);

        for (int[] e : blueEdges)
            graph[1][e[0]].add(e[1]);

        int[][] d = new int[2][n];
        for (int i = 0; i < 2; i++)
            Arrays.fill(d[i], Integer.MAX_VALUE);

        Queue<int[]> q = new ArrayDeque<>();
        d[0][0] = 0;
        d[1][0] = 0;
        q.offer(new int[] {0, 0});
        q.offer(new int[] {0, 1});
        while (!q.isEmpty()) {
            int[] xt = q.poll();
            int x = xt[0], t = xt[1];
            for (Integer nx : graph[1 - t][x]) {
                if (d[1 - t][nx] != Integer.MAX_VALUE) continue;
                d[1 - t][nx] = d[t][x] + 1;
                q.offer(new int[] {nx, 1 - t});
            }
        }
//        for (int i = 0; i < 2; i++) {
//            System.out.println(Arrays.toString(d[i]));
//        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int dist = Math.min(d[0][i], d[1][i]);
            res[i] = (dist == Integer.MAX_VALUE ? -1 : dist);
        }
        return res;
    }

    public static void main(String[] args) {
        ShortestPathWithAlternatingColors sp = new ShortestPathWithAlternatingColors();
//        int n = 5;
//        int[][] reds = new int[][] {{0,1},{1,2},{2,3},{3,4}};
//        int[][] blues = new int[][] {{1,2},{2,3},{3,1}};
        int n = 5;
        int[][] reds = new int[][] {{2,2},{0,1},{0,3},{0,0},{0,4},{2,1},{2,0},{1,4},{3,4}};
        int[][] blues = new int[][] {{1,3},{0,0},{0,3},{4,2},{1,0}};
        System.out.println(Arrays.toString(sp.shortestAlternatingPaths(n, reds, blues)));
    }
}
