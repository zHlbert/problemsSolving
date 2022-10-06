package acwing._796;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubMatrixSum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nmq = reader.readLine().split(" ");
        int n = Integer.parseInt(nmq[0]);
        int m = Integer.parseInt(nmq[1]);
        int q = Integer.parseInt(nmq[2]);
        int[][] matrix = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String[] s = reader.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                matrix[i][j] = Integer.parseInt(s[j - 1]);
            }
        }
        int[][] qa = new int[q][4];
        for (int i = 0; i < q; i++) {
            String[] s = reader.readLine().split(" ");
            qa[i][0] = Integer.parseInt(s[0]);
            qa[i][1] = Integer.parseInt(s[1]);
            qa[i][2] = Integer.parseInt(s[2]);
            qa[i][3] = Integer.parseInt(s[3]);
        }

        int[][] sum = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sum[i][j] = matrix[i][j] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }

        for (int i = 0; i < q; i++) {
            System.out.println(sum[qa[i][2]][qa[i][3]]
                    - sum[qa[i][0] - 1][qa[i][3]]
                    - sum[qa[i][2]][qa[i][1] - 1]
                    + sum[qa[i][0] - 1][qa[i][1] - 1]);
        }
    }
}
