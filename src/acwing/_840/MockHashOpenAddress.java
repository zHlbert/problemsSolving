package acwing._840;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MockHashOpenAddress {
    static int N = 200003, nil = 0x3f3f3f3f;

    static int[] h = new int[N];

    public static void main(String[] args) throws IOException {
        Arrays.fill(h, nil);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(reader.readLine());
        for (int i = 0; i < m; i++) {
            String[] line = reader.readLine().split(" ");
            String op = line[0];
            int x = Integer.parseInt(line[1]);
            if (op.equals("I")) {
                h[find(x)] = x;
            } else {
                System.out.println(h[find(x)] == nil ? "No" : "Yes");
            }
        }

        reader.close();
    }

    private static int find(int x) {
        int k = (x % N + N) % N;
        while (h[k] != nil && h[k] != x) {
            k++;
            if (k == N) k = 0;
        }
        return k;
    }
}
