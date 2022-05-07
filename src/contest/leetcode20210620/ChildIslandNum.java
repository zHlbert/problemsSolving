package contest.leetcode20210620;

/**
 * You are given two m x n binary matrices grid1 and grid2 containing only 0's (representing water) and 1's (representing land). An island is a group of 1's connected 4-directionally (horizontal or vertical). Any cells outside of the grid are considered water cells.
 *
 * An island in grid2 is considered a sub-island if there is an island in grid1 that contains all the cells that make up this island in grid2.
 *
 * Return the number of islands in grid2 that are considered sub-islands.
 */
public class ChildIslandNum {
    int m, n;
    int[][] g1, g2;
    int[] dx = new int[] {-1, 0, 1, 0};
    int[] dy = new int[] {0, 1, 0, -1};

    private boolean dfs(int x, int y) {
        boolean res = true;
        if (g1[x][y] == 0)
            res = false;
        g2[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i];
            int b = y + dy[i];
            if (a >= 0 && a < n && b >= 0 && b < m && g2[a][b] == 1) {
                if (!dfs(a, b))
                    res = false;
            }
        }
        return res;
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        n = grid1.length;
        m = grid1[0].length;
        g1 = grid1;
        g2 = grid2;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g2[i][j] == 1)
                    if (dfs(i, j))
                        res++;
            }
        }
        return res;
    }

    boolean dfs1(int x, int y) {
        boolean res = true;
        if (g1[x][y] == 0) res = false;
        g2[x][y] = 0;
        for (int i = 0; i < 4; i ++ ) {
            int a = x + dx[i], b = y + dy[i];
            if (a >= 0 && a < n && b >= 0 && b < m && g2[a][b] == 1) {
                if (!dfs(a, b)) res = false;
            }
        }
        return res;
    }

    int countSubIslands1(int[][] grid1, int[][] grid2) {
        g1 = grid1;
        g2 = grid2;
        n = g1.length;
        m = g1[0].length;
        int res = 0;
        for (int i = 0; i < n; i ++ )
            for (int j = 0; j < m; j ++ )
                if (g2[i][j] == 1) {
                    if (dfs1(i, j)) res ++ ;
                }

        return res;
    }

    public static void main(String[] args) {
        ChildIslandNum c = new ChildIslandNum();
        int[][] grid1 = {{1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}};
        int[][] grid2 = {{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}};
        System.out.println(c.countSubIslands(grid1, grid2));
    }
}
