package leetcode;

import java.util.Arrays;

public class CoordinateWithMaximumNetworkQuality {
    public int[] bestCoordinate(int[][] towers, int radius) {
        Arrays.sort(towers, (t, r) -> t[0] == r[0] ? t[1] - r[1] : t[0] - r[0]);
        int maxQ = 0;
        int[] maxP = new int[] {150, 150};
        for (int[] tw0 : towers) {
            for (int x = tw0[0] - radius; x <= tw0[0] + radius; x++) {
                for (int y = tw0[1] - radius; y <= tw0[1] + radius; y++) {
                    int curQ = 0;
                    int[] p = new int[]{x, y};
                    for (int[] tw : towers) {
                        int disSq = getDisSq(p, tw);
//                        System.out.println(Arrays.toString(p) + ", " + Arrays.toString(tw) + ", " + disSq);
                        if (disSq > radius * radius) {
                            continue;
                        }
                        curQ += tw[2] / (1 + Math.sqrt(disSq));
                    }
//                    System.out.println(Arrays.toString(p) + ", " + curQ + ", " + maxQ);
                    if (p[0] >= 0 && p[1] >= 0 && (curQ > maxQ || curQ == maxQ && (p[0] < maxP[0] || p[0] == maxP[0] && p[1] < maxP[1]))) {
                        maxQ = curQ;
                        maxP[0] = p[0];
                        maxP[1] = p[1];
                    }
                }
            }
        }
        return maxP;
    }

    private int getDisSq(int[] p1, int[] p2) {
        int x1 = p1[0], y1 = p1[1], x2 = p2[0], y2 = p2[1];
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }

    public int[] bestCoordinate1(int[][] towers, int radius) {
        int minx = 100, miny = 100, maxx = 0, maxy = 0;
        int maxQ = 0;
        int[] res = new int[2];
        int r2 = radius * radius;
        for (int[] tower : towers) {
            minx = Math.min(minx, tower[0]);
            miny = Math.min(miny, tower[1]);
            maxx = Math.max(maxx, tower[0]);
            maxy = Math.max(maxy, tower[1]);
        }
        for (int i = minx; i <= maxx; i++) {
            for (int j = miny; j <= maxy; j++) {
                int q = 0;
                for (int[] tw : towers) {
                    int disSq = (tw[0] - i) * (tw[0] - i) + (tw[1] - j) * (tw[1] - j);
                    if (disSq <= r2) {
                        q += tw[2] / (1 + Math.sqrt(disSq));
                    }
                }
                if (q > maxQ) {
                    maxQ = q;
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CoordinateWithMaximumNetworkQuality cm = new CoordinateWithMaximumNetworkQuality();
//        int[][] towers = new int[][] {{1,2,5},{2,1,7},{3,1,9}};
//        int radius = 2;
//        int[][] towers = new int[][] {{40,41,12},{18,5,2}};
//        int radius = 35;
//        int[][] towers = new int[][] {{28,6,30},{23,16,0},{21,42,22},{50,33,34},{14,7,50},{40,31,4},{39,45,17},{46,21,12},{45,36,45},{35,43,43},{29,41,48},{22,27,5},{42,44,45},{10,49,50},{47,43,26},{40,36,25},{10,25,6},{27,30,30},{50,35,20},{11,0,44},{34,29,28}};
//        int radius = 12;
        int[][] towers = new int[][] {{4,47,0}};
        int radius = 49;
        System.out.println(Arrays.toString(cm.bestCoordinate(towers, radius)));
    }
}
