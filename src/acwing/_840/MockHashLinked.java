package acwing._840;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MockHashLinked {
    static int N = 100003;

    static int[] e = new int[N], ne = new int[N], h = new int[N];

    static int idx = 0;

    public static void main(String[] args) throws IOException {
        Arrays.fill(h, -1);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(reader.readLine());
        for (int i = 0; i < m; i++) {
            String[] line = reader.readLine().split(" ");
            String op = line[0];
            int x = Integer.parseInt(line[1]);
            if (op.equals("I")) insert(x);
            else System.out.println(find(x) ? "Yes" : "No");
        }

        reader.close();
    }

    private static boolean find(int x) {
        int k = (x % N + N) % N;
        for (int i = h[k]; i != -1; i = ne[i]) {
            if (e[i] == x)
                return true;
        }
        return false;
    }

    private static void insert(int x) {
        int k = (x % N + N) % N;
        e[idx] = x;
        ne[idx] = h[k];
        h[k] = idx++;
    }
}
