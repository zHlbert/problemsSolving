package leetcode._1779;

public class FindNearestPointThatHasTheSameXOrYCoordinate {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int res = -1, md = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int[] p = points[i];
            int px = p[0], py = p[1];
            if (px == x) {
                if (md > Math.abs(py - y)) {
                    md = Math.abs(py - y);
                    res = i;
                }
            } else if (py == y) {
                if (md > Math.abs(px - x)) {
                    md = Math.abs(px - x);
                    res = i;
                }
            }
        }
        return res;
    }

    public int nearestValidPoint1(int x, int y, int[][] points) {
        int res = -1, md = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int px = points[i][0], py = points[i][1];
            if (px == x || py == y) {
                int dis = Math.abs(px - x) + Math.abs(py - y);
                if (res == -1 || dis < md) {
                    res = i;
                    md = dis;
                }
            }
        }
        return res;
    }
}
