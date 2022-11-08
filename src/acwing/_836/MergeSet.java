package acwing._836;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 合并集合
 *
 * 并查集
 */
public class MergeSet {
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = reader.readLine().split(" ");
        int n = Integer.parseInt(nm[0]), m = Integer.parseInt(nm[1]);
        p = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }

        for (int i = 0; i < m; i++) {
            String[] line = reader.readLine().split(" ");
            String op = line[0];
            int a = Integer.parseInt(line[1]);
            int b = Integer.parseInt(line[2]);
            if (op.equals("M")) {
                p[find(a)] = p[find(b)];
            } else {
                String res = find(a) == find(b) ? "Yes" : "No";
                System.out.println(res);
            }
        }
        reader.close();
    }

    private static int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
}
