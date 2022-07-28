package leetcode._593;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.cn/problems/valid-square/
 */
public class ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] p = new int[4][2];
        p[0] = p1;
        p[1] = p2;
        p[2] = p3;
        p[3] = p4;
        int[] d = new int[3];
        d[0] = (p2[0] - p1[0]) * (p2[0] - p1[0]) + (p2[1] - p1[1]) * (p2[1] - p1[1]);
        d[1] = (p3[0] - p1[0]) * (p3[0] - p1[0]) + (p3[1] - p1[1]) * (p3[1] - p1[1]);
        d[2] = (p4[0] - p1[0]) * (p4[0] - p1[0]) + (p4[1] - p1[1]) * (p4[1] - p1[1]);
        Integer[] di = new Integer[3];
        for (int i = 0; i < 3; i++) {
            di[i] = i;
        }
        Arrays.sort(di, Comparator.comparingInt(a -> d[a]));
        boolean dv = d[di[0]] != 0 && d[di[0]] == d[di[1]] && d[di[0]] + d[di[1]] == d[di[2]];
        if (!dv) {
            return false;
        }
        int x1 = p[di[0] + 1][0] - p[0][0];
        int y1 = p[di[0] + 1][1] - p[0][1];
        int x2 = p[di[1] + 1][0] - p[0][0];
        int y2 = p[di[1] + 1][1] - p[0][1];

        int x3 = p[di[0] + 1][0] - p[di[2] + 1][0];
        int y3 = p[di[0] + 1][1] - p[di[2] + 1][1];
        int x4 = p[di[1] + 1][0] - p[di[2] + 1][0];
        int y4 = p[di[1] + 1][1] - p[di[2] + 1][1];

        return x1 * x2 + y1 * y2 == 0 && x3 * x4 + y3 * y4 == 0;
    }

    public boolean validSquare1(int[] p1, int[] p2, int[] p3, int[] p4) {
        int d1 = distance(p1, p2), d2 = distance(p2, p3), d3 = distance(p3, p4);
        int d4 = distance(p1, p3), d5 = distance(p2, p4), d6 = distance(p1, p4);
        int[] d = new int[] {d1, d2, d3, d4, d5, d6};
        Arrays.sort(d);
        return d[0] != 0 && d[0] == d[1] && d[0] == d[2] && d[0] == d[3] && d[0] + d[0] == d[4] && d[4] == d[5];
    }

    public int distance(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

    public static void main(String[] args) {
        ValidSquare vs = new ValidSquare();
//        int[] p1 = new int[] {0,1};
//        int[] p2 = new int[] {1,2};
//        int[] p3 = new int[] {0,2};
//        int[] p4 = new int[] {0,0};
        int[] p1 = new int[] {1,0};
        int[] p2 = new int[] {-1,0};
        int[] p3 = new int[] {0,1};
        int[] p4 = new int[] {0,-1};
        System.out.println(vs.validSquare(p1, p2, p3, p4));
    }
}
