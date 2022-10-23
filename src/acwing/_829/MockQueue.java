package acwing._829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MockQueue {

    static int N = 100010;

    static int[] q = new int[N];

    static int head = 0, tail = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(reader.readLine());
        for (int i = 0; i < m; i++) {
            String[] line = reader.readLine().split(" ");
            String op = line[0];
            if (op.equals("push")) {
                int x = Integer.parseInt(line[1]);
                q[++tail] = x;
            } else if (op.equals("pop")) {
                head++;
            } else if (op.equals("empty")) {
                System.out.println(head > tail ? "YES" : "NO");
            } else {
                System.out.println(q[head]);
            }
        }
        reader.close();
    }
}
