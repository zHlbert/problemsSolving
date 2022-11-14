package acwing._240;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 食物链
 * https://www.acwing.com/problem/content/242/
 * 并查集
 */
public class FoodChain {
    static int[] p, d;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = reader.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
        d = new int[n + 1];
        int res = 0;
        for (int i = 0; i < k; i++) {
            String[] line = reader.readLine().split(" ");
            String op = line[0];
            int x = Integer.parseInt(line[1]);
            int y = Integer.parseInt(line[2]);
            if (x > n || y > n) {
                res++;
                continue;
            }
            int px = find(x), py = find(y);
            if ("1".equals(op)) {
                if (px == py && (d[x] - d[y]) % 3 != 0) {
                    res++;
                } else if (px != py) {
                    p[px] = py;
                    d[px] = d[y] - d[x];
                }
            } else {
                if (px == py && (d[x] - d[y] - 1) % 3 != 0) {
                    res++;
                } else if (px != py) {
                    p[px] = py;
                    d[px] = d[y] + 1 - d[x];
                }
            }
        }
        System.out.println(res);
        reader.close();
    }

    /**
     * 维护到祖宗节点距离的并查集
     * @param x
     * @return
     */
    private static int find(int x) {
        if (p[x] != x) {
            int t = find(p[x]);
            d[x] += d[p[x]];
            p[x] = t;
        }
        return p[x];
    }
}
