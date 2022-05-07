package leetcode._883;

public class ProjectionAreaOf3DShapes {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int XYArea = 0;
        for (int[] value : grid) {
            for (int j = 0; j < n; j++) {
                if (value[j] > 0) {
                    XYArea++;
                }
            }
        }

        int XZArea = 0;
        for (int[] ints : grid) {
            int maxH = 0;
            for (int j = 0; j < n; j++) {
                maxH = Math.max(maxH, ints[j]);
            }
            XZArea += maxH;
        }

        int YZArea = 0;
        for (int i = 0; i < n; i++) {
            int maxH = 0;
            for (int[] ints : grid) {
                maxH = Math.max(maxH, ints[i]);
            }
            YZArea += maxH;
        }
        return XYArea + XZArea + YZArea;
    }
}
