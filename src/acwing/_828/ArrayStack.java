package acwing._828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 模拟栈
 */
public class ArrayStack {
    static int N = 10001;

    static int[] stack = new int[N];

    static int top = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(reader.readLine());

        for (int i = 0; i < m; i++) {
            String[] line = reader.readLine().split(" ");
            String op = line[0];
            if (op.equals("push")) {
                int x = Integer.parseInt(line[1]);
                stack[++top] = x;
            } else if (op.equals("pop")) {
                top--;
            } else if (op.equals("empty")) {
                System.out.println(top <= 0 ? "YES" : "NO");
            } else {
                System.out.println(stack[top]);
            }
        }
        reader.close();
    }
}
