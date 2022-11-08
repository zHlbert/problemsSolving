package acwing._837;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 连通块中点的数量
 *
 * 维护size 并查集
 */
public class CountOfPointsInConnectedComponent {
    static int[] p, sz;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = reader.readLine().split(" ");
        int n = Integer.parseInt(nm[0]), m = Integer.parseInt(nm[1]);
        p = new int[n + 1];
        sz = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            p[i] = i;
            sz[i] = 1;
        }

        for (int i = 0; i < m; i++) {
            String[] line = reader.readLine().split(" ");
            String op = line[0];
            int a = Integer.parseInt(line[1]);
            if (op.equals("C")) {
                int b = Integer.parseInt(line[2]);
                if (find(a) == find(b)) continue;
                sz[find(b)] += sz[find(a)];
                p[find(a)] = p[find(b)];
            } else if (op.equals("Q1")) {
                int b = Integer.parseInt(line[2]);
                System.out.println(find(a) == find(b) ? "Yes" : "No");
            } else {
                System.out.println(sz[find(a)]);
            }
        }
        reader.close();
    }

    private static int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
}
