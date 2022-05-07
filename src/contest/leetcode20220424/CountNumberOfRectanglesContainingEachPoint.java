package contest.leetcode20220424;

import utils.ArrayUtils;

import java.util.*;

public class CountNumberOfRectanglesContainingEachPoint {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        int[] ans = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int[] rectangle : rectangles) {
                if (insideRec(points[i], rectangle)) {
                    ans[i]++;
                }
            }
        }
        return ans;
    }

    public int[] countRectangles1(int[][] rectangles, int[][] points) {
        Arrays.sort(rectangles, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
        Map<Integer, List<int[]>> hMap = new HashMap<>();
        for (int[] rectangle : rectangles) {
            int h = rectangle[1];
            if (!hMap.containsKey(h)) {
                hMap.put(h, new ArrayList<>());
            }
            hMap.get(h).add(rectangle);
        }

        int[] ans = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = points[i][1]; j <= 100; j++) {
                if (hMap.containsKey(j)) {
                    List<int[]> recs = hMap.get(j);
                    int size = recs.size();
                    for (int k = 0; k < size; k++) {
                        if (insideRec(points[i], recs.get(k))) {
                            ans[i] += size - k;
                            break;
                        }
                    }
                }
            }

        }
        return ans;
    }

    private boolean insideRec(int[] point, int[] rectangle) {
        int px = point[0];
        int py = point[1];
        return px >= 0 && px <= rectangle[0] && py >= 0 && py <= rectangle[1];
    }

    public static void main(String[] args) {
        CountNumberOfRectanglesContainingEachPoint cnr = new CountNumberOfRectanglesContainingEachPoint();
        int[][] rectangles = new int[][] {{7,1},{2,6},{1,4},{5,2},{10,3},{2,4},{5,9}};
        int[][] points = new int[][] {{10,3},{8,10},{2,3},{5,4},{8,5},{7,10},{6,6},{3,6}};
        ArrayUtils.printArray(cnr.countRectangles1(rectangles, points));
    }

//    [[7,1],[2,6],[1,4],[5,2],[10,3],[2,4],[5,9]]
//            [[10,3],[8,10],[2,3],[5,4],[8,5],[7,10],[6,6],[3,6]]
}
