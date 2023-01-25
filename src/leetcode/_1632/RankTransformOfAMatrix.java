package leetcode._1632;

import java.util.*;

/**
 * 矩阵转换后的秩
 * https://leetcode.cn/problems/rank-transform-of-a-matrix/
 */
public class RankTransformOfAMatrix {
    //  并查集用于合并行或列相同的元素
    static int LIM = 512;
    static int[] p = new int[LIM * 2];

    /**
     * 并查集
     * https://leetcode.cn/problems/rank-transform-of-a-matrix/solution/python3-mei-sha-ji-zhu-han-liang-de-ti-jie-by-simp/
     * @param matrix
     * @return
     */
    public int[][] matrixRankTransform(int[][] matrix) {
        int R = matrix.length, C = matrix[0].length;
        int[][] res = new int[R][C];
        int[] countR = new int[R], countC = new int[C];
        Map<Integer, List<Integer>> ls = new HashMap<>(), pool = new HashMap<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                List<Integer> points = ls.getOrDefault(matrix[i][j], new ArrayList<>());
                points.add(i * LIM + j);
                ls.put(matrix[i][j], points);
            }
        }

        for (int i = 0; i < LIM * 2; i++) p[i] = i;

        int[] values = new int[ls.size()];
        int i = 0;
        for (Integer val : ls.keySet()) values[i++] = val;
        Arrays.sort(values);
        for (int val : values) {
            // 用并查集合并行和列相同的元素并分组
            for (Integer pt : ls.get(val)) {
                p[find(pt / LIM)] = find((pt % LIM) + LIM);
            }
            pool.clear();
            for (Integer pt : ls.get(val)) {
                List<Integer> points = pool.getOrDefault(find(pt / LIM), new ArrayList<>());
                points.add(pt);
                pool.put(find(pt / LIM), points);
            }

            // 行/列相同的元素，共享相同的 rank
            for (Map.Entry<Integer, List<Integer>> group : pool.entrySet()) {
                int rank = 0;
                for (Integer pt : group.getValue()) {
                    rank = Math.max(rank, Math.max(countR[pt / LIM], countC[pt % LIM]));
                }
                rank++;
                for (Integer pt : group.getValue()) {
                    int r = pt / LIM, c = pt % LIM;
                    countR[r] = countC[c] = res[r][c] = rank;
                    // 重置并查集
                    p[r] = r;
                    p[c + LIM] = c + LIM;
                }
            }
        }
        return res;
    }

    private int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
}
