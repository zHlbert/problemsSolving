package leetcode._2500;

import utils.ArrayUtils;

import java.util.Arrays;

public class DeleteGreatestValueInEachRow {
    public int deleteGreatestValue(int[][] grid) {
        int n = grid[0].length;
        int res = 0;
        for (int[] g : grid) {
            Arrays.sort(g);
        }
//        ArrayUtils.print2DArray(grid);
        for (int i = 0; i < n; i++) {
            int mx = 0;
            for (int[] g : grid) {
                mx = Math.max(mx, g[i]);
            }
            res += mx;
        }

        return res;
    }

    public static void main(String[] args) {
        DeleteGreatestValueInEachRow dg = new DeleteGreatestValueInEachRow();
        int[][] grid = new int[][] {{1,2,4},{3,3,1}};
        System.out.println(dg.deleteGreatestValue(grid));
    }
}
