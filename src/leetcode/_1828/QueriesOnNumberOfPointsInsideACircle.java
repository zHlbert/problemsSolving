package leetcode._1828;

public class QueriesOnNumberOfPointsInsideACircle {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int x0 = query[0], y0 = query[1], r0 = query[2];
            int inside = 0;
            for (int[] point : points) {
                int d2 = (x0 - point[0]) * (x0 - point[0]) + (y0 - point[1]) * (y0 - point[1]);
                inside += d2 <= r0 * r0 ? 1 : 0;
            }
            res[i] = inside;
        }
        return res;
    }
}
