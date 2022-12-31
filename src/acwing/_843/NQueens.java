package acwing._843;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * n-皇后问题
 * https://www.acwing.com/problem/content/845/
 */
public class NQueens {
    static char[][] g;

    static boolean[] col, dg, udg;

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        g = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                g[i][j] = '.';

        col = new boolean[n];
        dg = new boolean[2 * n];
        udg = new boolean[2 * n];

        backtrack(0);
        reader.close();
    }

    private static void backtrack(int r) {
        if (r == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    System.out.print(g[i][j]);
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int c = 0; c < n; c++) {
            if (!col[c] && !dg[r + c] && !udg[r - c + n]) {
                col[c] = dg[r + c] = udg[r - c + n] = true;
                g[r][c] = 'Q';
                backtrack(r + 1);
                g[r][c] = '.';
                col[c] = dg[r + c] = udg[r - c + n] = false;
            }
        }
    }
}
