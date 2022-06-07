package leetcode._1037;

/**
 * https://leetcode.cn/problems/valid-boomerang/
 */
public class ValidBoomerang {
    public boolean isBoomerang(int[][] points) {
        int[] p1 = points[0];
        int x1 = p1[0], y1 = p1[1];
        int[] p2 = points[1];
        int x2 = p2[0], y2 = p2[1];
        int[] p3 = points[2];
        int x3 = p3[0], y3 = p3[1];
        if (x1 == x2 && y1 == y2 || x1 == x3 && y1 == y3 || x2 == x3 && y2 == y3) {
            return false;
        }
        return (y2 - y1) * (x3 - x2) != (y3 - y2) * (x2 - x1);
    }

    public static void main(String[] args) {
        ValidBoomerang vb = new ValidBoomerang();
        int[][] points = new int[][] {{1,1},{2,3},{3,2}};
        System.out.println(vb.isBoomerang(points));
    }
}
