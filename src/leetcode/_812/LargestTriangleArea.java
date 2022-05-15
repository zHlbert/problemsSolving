package leetcode._812;

/**
 * https://leetcode.cn/problems/largest-triangle-area/
 */
public class LargestTriangleArea {
    public double largestTriangleArea(int[][] points) {
        int INF = 100;
        int minX = INF, maxX = -INF;
        int minY = INF, maxY = -INF;

        for (int[] point : points) {
            if (point[0] == 0) {
                minX = Math.min(minX, point[1]);
                maxX = Math.max(maxX, point[1]);
            }
            if (point[1] == 0) {
                minY = Math.min(minY, point[0]);
                maxY = Math.max(maxY, point[0]);
            }
        }

        if (minX == INF || minY == INF) {
            return 0.0;
        }
        int x = maxX - minX;
        int h = Math.max(Math.abs(minY), Math.abs(maxY));
        return 0.5 * x * h;
    }

    public static void main(String[] args) {
        LargestTriangleArea lta = new LargestTriangleArea();
//        int[][] points = new int[][] {{0,0},{0,1},{1,0},{0,2},{2,0}};
        int[][] points = new int[][] {{1,0},{0,0},{0,1}};
        System.out.println(lta.largestTriangleArea(points));
    }
}
