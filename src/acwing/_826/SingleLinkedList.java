package acwing._826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 数组模拟单链表
 */
public class SingleLinkedList {
    static int N = 100010;

    static int[] ne = new int[N];
    static int[] e = new int[N];

    static int head;
    static int idx;

    private static void init() {
        head = -1;
        idx = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(reader.readLine());
        init();

        for (int i = 0; i < m; i++) {
            String[] line = reader.readLine().split(" ");
            String op = line[0];
            if (op.equals("H")) {
                int x = Integer.parseInt(line[1]);
                add2Head(x);
            } else if (op.equals("D")) {
                int k = Integer.parseInt(line[1]);
                deleteKthNode(k - 1);
            } else {
                int k = Integer.parseInt(line[1]), x = Integer.parseInt(line[2]);
                addAfterKthNode(k - 1, x);
            }
        }

        for (int i = head; i != -1 ; i = ne[i]) {
            System.out.print(e[i] + " ");
        }
        reader.close();
    }

    private static void addAfterKthNode(int k, int x) {
        e[idx] = x;
        ne[idx] = ne[k];
        ne[k] = idx;
        idx++;
    }

    private static void deleteKthNode(int k) {
        if (k == -1) {
            head = ne[head];
        } else {
            ne[k] = ne[ne[k]];
        }
    }

    private static void add2Head(int x) {
        e[idx] = x;
        ne[idx] = head;
        head = idx;
        idx++;
    }

}
