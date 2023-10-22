package leetcode._2316;

/**
 * 并查集
 */
public class CountUnreachablePairsOfNodesInAnUndirectedGraph {
    static int[] p;
    public long countPairs(int n, int[][] edges) {
        p = new int[n];
        int[] sz = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
            sz[i] = 1;
        }

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            int ra = find(a), rb = find(b);
            if (ra != rb) {
                p[ra] = p[rb];
                sz[rb] += sz[ra];
            }
        }

        long res = 0L;
        for (int i = 0; i < n; i++) {
            int r = find(i);
//            System.out.println(r + ", " + sz[i]);
            res += n - sz[r];
        }
        return res / 2;
    }

    private int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    public static void main(String[] args) {
        CountUnreachablePairsOfNodesInAnUndirectedGraph cu = new CountUnreachablePairsOfNodesInAnUndirectedGraph();
        System.out.println(cu.countPairs(7, new int[][] {{0,2},{0,5},{2,4},{1,6},{5,4}}));
        System.out.println(cu.countPairs(3, new int[][] {{0,1},{0,2},{1,2}}));
    }
}
