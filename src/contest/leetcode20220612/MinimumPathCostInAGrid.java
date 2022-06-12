package contest.leetcode20220612;

public class MinimumPathCostInAGrid {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] rowCosts = new int[m][n];
        for (int i = 0; i < n; i++) {
            rowCosts[0][i] = grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int minCost = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    minCost = Math.min(minCost, rowCosts[i - 1][k] + moveCost[grid[i - 1][k]][j] + grid[i][j]);
                }
                rowCosts[i][j] = minCost;
            }
        }

        int minTotal = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minTotal = Math.min(minTotal, rowCosts[m - 1][i]);
        }
        return minTotal;
    }

    public static void main(String[] args) {
        MinimumPathCostInAGrid mp = new MinimumPathCostInAGrid();
        int[][] grid = new int[][] {{5,3},{4,0},{2,1}};
        int[][] moveCost = new int[][] {{9,8},{1,5},{10,12},{18,6},{2,4},{14,3}};
        System.out.println(mp.minPathCost(grid, moveCost));
    }
}
