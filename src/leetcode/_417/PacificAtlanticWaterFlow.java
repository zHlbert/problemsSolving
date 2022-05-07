package leetcode._417;

import java.util.ArrayList;
import java.util.List;

/**
 * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
 *
 * The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
 *
 * The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.
 *
 * Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pacific-atlantic-water-flow
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode-cn.com/problems/pacific-atlantic-water-flow/
 */
public class PacificAtlanticWaterFlow {
    int[][] dirs = new int[][] {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    int[][] heights;
    int m,n;
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        this.heights = heights;
        boolean[][] pacific = new boolean[m][n]; 
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacific);
        }

        for (int i = 1; i < n; i++) {
            dfs(0, i, pacific);
        }

        for (int i = 0; i < m; i++) {
            dfs(i, n - 1, atlantic);
        }

        for (int i = 0; i < n - 1; i++) {
            dfs(m - 1, i, atlantic);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> coo = new ArrayList<>();
                    coo.add(i);
                    coo.add(j);
                    res.add(coo);
                }
            }
        }

        return res;
    }

    private void dfs(int row, int col, boolean[][] ocean) {
        if (ocean[row][col]) {
            return;
        }
        ocean[row][col] = true;
        for (int[] dir : dirs) {
            int i = row + dir[0];
            int j = col + dir[1];
            if (i >= 0 && i < m && j >= 0 && j < n && heights[i][j] >= heights[row][col]) {
                dfs(i, j, ocean);
            }
        }
    }
}
