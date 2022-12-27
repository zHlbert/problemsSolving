package acwing._841;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 字符串哈希
 * https://www.acwing.com/problem/content/843/
 */
public class StringHash {
    static int N = 100010, P = 131;
    static long[] h = new long[N];
    static long[] p = new long[N];
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = reader.readLine().split(" ");
        int n = Integer.parseInt(nm[0]), m = Integer.parseInt(nm[1]);
        char[] sc = reader.readLine().toCharArray();

        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            h[i] = h[i - 1] * P + sc[i - 1];
            p[i] = p[i - 1] * P;
        }

        for (int i = 0; i < m; i++) {
            String[] lr = reader.readLine().split(" ");
            int l1 = Integer.parseInt(lr[0]), r1 = Integer.parseInt(lr[1]), l2 = Integer.parseInt(lr[2]), r2 = Integer.parseInt(lr[3]);
            System.out.println(get(l1, r1) == get(l2, r2) ? "Yes" : "No");
        }
    }

    private static long get(int l, int r) {
        return h[r] - h[l - 1] * p[r - l + 1];
    }
}
