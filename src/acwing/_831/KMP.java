package acwing._831;

import java.io.*;

public class KMP {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String ps = " " + reader.readLine();
        char[] p = ps.toCharArray();
        int m = Integer.parseInt(reader.readLine());
        String ss = " " + reader.readLine();
        char[] s = ss.toCharArray();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] ne = new int[n + 1];
        for (int i = 2, j = 0; i <= n; i++) {
            while (j > 0 && p[i] != p[j + 1]) {
                j = ne[j];
            }
            if (p[i] == p[j + 1]) {
                j++;
            }
            ne[i] = j;
        }

        // 匹配
        for (int i = 1, j = 0; i <= m; i++) {
            while (j > 0 && s[i] != p[j + 1]) {
                j = ne[j];
            }
            if (s[i] == p[j + 1]) {
                j++;
            }
            if (j == n) {
                bw.write((i - n) + " ");
                j = ne[j];
            }
        }
        bw.flush();
        reader.close();
    }
}
