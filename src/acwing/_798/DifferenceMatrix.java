package acwing._798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DifferenceMatrix {
    static int N = 1005, M = 1005;

    static int[][] b = new int[N][M];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nmq = reader.readLine().split(" ");
        int n = Integer.parseInt(nmq[0]);
        int m = Integer.parseInt(nmq[1]);
        int q = Integer.parseInt(nmq[2]);

        for (int i = 1; i <= n; i++) {
            String[] s = reader.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                int c = Integer.parseInt(s[j - 1]);
                insert(i, j, i, j, c);
            }
        }

        int[][] qa = new int[q][5];
        for (int i = 0; i < q; i++) {
            String[] qn = reader.readLine().split(" ");
            qa[i][0] = Integer.parseInt(qn[0]);
            qa[i][1] = Integer.parseInt(qn[1]);
            qa[i][2] = Integer.parseInt(qn[2]);
            qa[i][3] = Integer.parseInt(qn[3]);
            qa[i][4] = Integer.parseInt(qn[4]);
        }

        for (int i = 0; i < q; i++) {
            insert(qa[i][0], qa[i][1], qa[i][2], qa[i][3], qa[i][4]);
        }

        int[][] res = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                res[i][j] = res[i - 1][j] + res[i][j - 1] - res[i - 1][j - 1] + b[i][j];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }

        reader.close();
    }

    private static void insert(int x1, int y1, int x2, int y2, int c) {
        b[x1][y1] += c;
        b[x2 + 1][y1] -= c;
        b[x1][y2 + 1] -= c;
        b[x2 + 1][y2 + 1] += c;
    }
}
