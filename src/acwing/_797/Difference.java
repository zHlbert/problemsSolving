package acwing._797;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Difference {
    static int N = 100010;
    static int[] b = new int[N];
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = reader.readLine().split(" ");
        int n = Integer.parseInt(nm[0]), m = Integer.parseInt(nm[1]);
        String[] ns = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int c = Integer.parseInt(ns[i]);
            insert(i + 1, i + 1, c);
        }
        int[][] q = new int[m][3];
        for (int i = 0; i < m; i++) {
            String[] qs = reader.readLine().split(" ");
            q[i][0] = Integer.parseInt(qs[0]);
            q[i][1] = Integer.parseInt(qs[1]);
            q[i][2] = Integer.parseInt(qs[2]);
        }

        for (int i = 0; i < m; i++) {
            insert(q[i][0], q[i][1], q[i][2]);
        }

        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = res[i - 1] + b[i];
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(res[i] + " ");
        }
    }

    private static void insert(int l, int r, int c) {
        b[l] += c;
        b[r + 1] -= c;
    }
}
