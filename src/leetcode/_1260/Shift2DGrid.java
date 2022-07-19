package leetcode._1260;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Shift2DGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[(i + (j + k) / n) % m][(j + k) % n] = grid[i][j];
            }
        }

        List<List<Integer>> s = new ArrayList<>();
        for (int[] re : res) {
            s.add(Arrays.stream(re).boxed().collect(Collectors.toList()));
        }
        return s;
    }
}
