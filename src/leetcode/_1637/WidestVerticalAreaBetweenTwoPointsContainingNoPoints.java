package leetcode._1637;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {
    public int maxWidthOfVerticalArea(int[][] points) {
        Set<Integer> set = new TreeSet<>();
        for (int[] p : points) {
            set.add(p[0]);
        }
        int res = 0, pre = -1;
        for (Integer x : set) {
            if (pre == -1) pre = x;
            else {
                res = Math.max(res, x - pre);
                pre = x;
            }
        }
        return res;
    }

    public int maxWidthOfVerticalArea1(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(p -> p[0]));
        int res = 0, pre = -1;
        for (int[] p : points) {
            if (pre == -1) pre = p[0];
            else if (pre != p[0]) {
                res = Math.max(res, p[0] - pre);
                pre = p[0];
            }
        }
        return res;
    }

    public int maxWidthOfVerticalArea2(int[][] points) {
        int n = points.length;
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = points[i][0];
        }
        Arrays.sort(p);
        int res = 0;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, p[i] - p[i - 1]);
        }
        return res;
    }

    public static void main(String[] args) {
        WidestVerticalAreaBetweenTwoPointsContainingNoPoints wv = new WidestVerticalAreaBetweenTwoPointsContainingNoPoints();
        System.out.println(wv.maxWidthOfVerticalArea1(new int[][] {{8,7},{9,9},{7,4},{9,7}}));
        System.out.println(wv.maxWidthOfVerticalArea1(new int[][] {{3,1},{9,0},{1,0},{1,4},{5,3},{8,8}}));
    }
}
