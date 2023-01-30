package acwing._845;

import java.io.*;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * 八数码
 * https://www.acwing.com/problem/content/847/
 */
public class EightDigits {
    static int[] dx = new int[] {1, 0, -1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};
    static String end = "12345678x";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = reader.readLine().split(" ");
        String start = String.join("", s);

        writer.write(String.valueOf(bfs(start)));
        writer.flush();
        reader.close();
    }

    private static int bfs(String start) {
        Map<String, Integer> d = new HashMap<>();
        d.put(start, 0);

        Queue<String> q = new ArrayDeque<>();
        q.offer(start);
        while (!q.isEmpty()) {
            String s = q.poll();
            if (end.equals(s)) return d.get(s);
            int idx = s.indexOf('x');
            int r = idx / 3, c = idx % 3;
            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i], nc = c + dy[i];
                if (nr >= 0 && nr < 3 && nc >= 0 && nc < 3) {
                    String ns = swap(s, idx, nr * 3 + nc);
                    if (!d.containsKey(ns)) {
                        d.put(ns, d.get(s) + 1);
                        q.offer(ns);
                    }

                }
            }
        }
        return -1;
    }

    private static String swap(String str, int s, int t) {
        char[] sc = str.toCharArray();
        char tmp = sc[s];
        sc[s] = sc[t];
        sc[t] = tmp;
        return new String(sc);
    }
}
