package contest.leetcode20210711;

/**
 * You are given two integers m and n. Consider an m x n grid where each cell is initially white. You can paint each cell red, green, or blue. All cells must be painted.
 *
 * Return the number of ways to color the grid with no two adjacent cells having the same color. Since the answer can be very large, return it modulo 109 + 7.
 */
public class PaintingAGridWithThreeDifferentColors {
//    int[] colors = new int[] {1, 2, 3};
//    int[] dx = new int[] {-1, 0, 1, 0};
//    int[] dy = new int[] {0, 1, 0, -1};
//    int[][] matrix;
//    public int colorTheGrid(int m, int n) {
//        matrix = new int[m][n];
//        int ans = 0;
////        for (int i = 0; i < colors.length; i++) {
////            ans += dfs(matrix, 0, 0, colors[i]);
////        }
//        return 3;
//    }

//    private int dfs(int[][] matrix, int x, int y, int color) {
//        if ()
//    }

    int[][] f = new int[1005][255];
    int mod = 1000000007, M;
    public int colorTheGrid(int m, int n) {
        M = m;
        int total = 1;
        for (int i = 0; i < m; i++)
            total *= 3;
        for (int i = 0; i < total; i++)
            if (check(i))
                f[1][i] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < total; j++) {
                if (check(j)) {
                    for (int k = 0; k < total; k++) {
                        if (check(k)) {
                            if (checkN(j, k)) {
                                f[i][j] = (f[i][j] + f[i - 1][k]) % mod;
                            }
                        }
                    }
                }
            }
        }
        
        int ans = 0;
        for (int i = 0; i < total; i++) {
            ans = (ans + f[n][i]) % mod;
        }
        return ans;
    }

    private boolean checkN(int j, int k) {
        for (int i = 0; i < M; i++) {
            if (j % 3 == k % 3) {
                return false;
            }
            j /= 3;
            k /= 3;
        }
        return true;
    }

    private boolean check(int n) {
        int last = -1;
        for (int j = 0; j < M; j++) {
            if (n % 3 == last) {
                return false;
            }
            last = n % 3;
            n /= 3;
        }
        return true;
    }

    public static void main(String[] args) {
        PaintingAGridWithThreeDifferentColors p = new PaintingAGridWithThreeDifferentColors();
        System.out.println(p.colorTheGrid(5, 5));
        System.out.println(p.colorTheGrid(1, 2));
        System.out.println(p.colorTheGrid(1, 3));
        System.out.println(p.colorTheGrid(1, 4));
        System.out.println(p.colorTheGrid(1, 5));
    }

}
