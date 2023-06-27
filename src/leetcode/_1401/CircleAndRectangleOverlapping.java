package leetcode._1401;

public class CircleAndRectangleOverlapping {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        long dist = 0;
        if (xCenter < x1 || xCenter > x2) {
            dist += Math.min((x1 - xCenter) * (x1 - xCenter), (x2 - xCenter) * (x2 - xCenter));
        }
        if (yCenter < y1 || yCenter > y2) {
            dist += Math.min((y1 - yCenter) * (y1 - yCenter), (y2 - yCenter) * (y2 - yCenter));
        }
        return dist <= (long) radius * radius;
    }
}
