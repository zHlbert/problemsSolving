package contest.leetcode20220424;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Given a 2D integer array circles where circles[i] = [xi, yi, ri] represents the center (xi, yi) and radius ri of the ith circle drawn on a grid, return the number of lattice points that are present inside at least one circle.
 *
 * Note:
 *
 * A lattice point is a point with integer coordinates.
 * Points that lie on the circumference of a circle are also considered to be inside it.
 */
public class CountLatticePointsInsideACircle {
    public int countLatticePoints(int[][] circles) {
        Set<Point> points = new HashSet<>();
        for (int[] circle : circles) {
            int cx = circle[0];
            int cy = circle[1];
            int r = circle[2];
            for (int i = cx - r; i <= cx + r; i++) {
                for (int j = cy - r; j <= cy + r; j++) {
                    if (disSq(i, j, cx, cy) <= r * r) {
                        points.add(new Point(i, j));
                    }
                }
            }
        }
        return points.size();
    }

    private int disSq(int i, int j, int cx, int cy) {
        return (i - cx) * (i - cx) + (j - cy) * (j - cy);
    }

    public static void main(String[] args) {
        CountLatticePointsInsideACircle clp = new CountLatticePointsInsideACircle();
        int[][] circles = new int[][] {{2,2,2},{3,4,1}};
        System.out.println(clp.countLatticePoints(circles));
    }
}

class Point {
    int x;

    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}