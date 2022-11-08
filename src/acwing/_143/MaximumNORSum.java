package acwing._143;

import java.io.*;

/**
 * 最大异或和
 *
 * https://www.acwing.com/problem/content/145/
 */
public class MaximumNORSum {
    static int N = 100010, M = 3000010;

    static int idx = 0;

    static int[][] trie = new int[M][2];

    static int[] a = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        String[] line = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(line[i]);
            insert(a[i]);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, search(a[i]));
        }

//        System.out.println(res);
        writer.write(String.valueOf(res));
        writer.flush();
        reader.close();
    }

    private static int search(int x) {
        int p = 0, res = 0;
        for (int i = 30; i >= 0; i--) {
            int s = x >> i & 1;
            if (trie[p][s ^ 1] != 0) {
                // 存在数与当前数当前位不同,此时当前位异或和为1,进入这一分支
                res |= 1 << i;
                p = trie[p][s ^ 1];
            } else {
                // 不存在数与当前数当前位不同,此时当前位异或和为0,进入这一分支
                p = trie[p][s];
            }
        }
        return res;
    }

    private static void insert(int x) {
        int p = 0;
        for (int i = 30; i >= 0; i--) {
            int s = x >> i & 1;
            if (trie[p][s] == 0) {
                trie[p][s] = ++idx;
            }
            p = trie[p][s];
        }
    }
}
