package acwing._835;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrieStringCount {

    static int N = 100010, idx = 0;

    static int[][] trie = new int[N][26];

    static int[] cnt = new int[N];

    /**
     * 字典树
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" ");
            String op = line[0];
            char[] s = line[1].toCharArray();
            if (op.equals("I")) {
                insert(s);
            } else {
                System.out.println(find(s));
            }
        }
        reader.close();
    }

    private static int find(char[] s) {
        int k = 0;
        for (char c : s) {
            int d = c - 'a';
            if (trie[k][d] == 0) return 0;
            k = trie[k][d];
        }
        return cnt[k];
    }

    private static void insert(char[] s) {
        int k = 0;
        for (char c : s) {
            int d = c - 'a';
            if (trie[k][d] == 0) {
                trie[k][d] = ++idx;
            }
            k = trie[k][d];
        }
        cnt[k]++;
    }
}
