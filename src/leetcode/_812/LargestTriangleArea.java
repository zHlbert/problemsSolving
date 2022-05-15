package leetcode._812;

/**
 * https://leetcode.cn/problems/largest-triangle-area/
 */
public class LargestTriangleArea {
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0.0;
        for (int i = 0; i < points.length - 2; i++) {
            for (int j = i + 1; j < points.length - 1; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    double area = triangleArea(points[i][0], points[i][1], points[j][0], points[j][1], points[k][0], points[k][1]);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    // 三角形面积公式
    private double triangleArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        return 0.5 * Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
    }

    public static void main(String[] args) {
        LargestTriangleArea lta = new LargestTriangleArea();
        int[][] points = new int[][] {{0,0},{0,1},{1,0},{0,2},{2,0}};
//        int[][] points = new int[][] {{1,0},{0,0},{0,1}};
        System.out.println(lta.largestTriangleArea(points));
    }
}
