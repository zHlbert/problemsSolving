package leetcode._1697;

import utils.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 检查边长度限制的路径是否存在
 * https://leetcode.cn/problems/checking-existence-of-edge-length-limited-paths/
 */
public class CheckingExistenceOfEdgeLengthLimitedPaths {
    int[] p;

    /**
     * 并查集
     * @param n
     * @param edgeList
     * @param queries
     * @return
     */
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }

        Arrays.sort(edgeList, Comparator.comparingInt(e -> e[2]));

        int m = queries.length;
        Integer[] idx = new Integer[m];
        for (int i = 0; i < m; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, Comparator.comparingInt(i -> queries[i][2]));


        boolean[] exists = new boolean[m];
        int k = 0;
        for (int i : idx) {
//            System.out.println(Arrays.toString(p));
            while (k < edgeList.length && edgeList[k][2] < queries[i][2]) {
                p[find(edgeList[k][0])] = p[find(edgeList[k][1])];
                k++;
            }
//            System.out.println(Arrays.toString(p));
            exists[i] = find(queries[i][0]) == find(queries[i][1]);
        }
        return exists;
    }

    private int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    public static void main(String[] args) {
        CheckingExistenceOfEdgeLengthLimitedPaths ce = new CheckingExistenceOfEdgeLengthLimitedPaths();
        int n = 5;
        int[][] edgeList = new int[][] {{0,1,10},{1,2,5},{2,3,9},{3,4,13}};
        int[][] queries = new int[][] {{0,4,14},{1,4,13}};
        System.out.println(Arrays.toString(ce.distanceLimitedPathsExist(n, edgeList, queries)));
    }
}
