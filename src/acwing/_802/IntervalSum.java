package acwing._802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 离散化
 */
public class IntervalSum {
    static int N = 300010;

    static List<Integer> alls = new ArrayList<>();

    static int[] A = new int[N];
    static int[] S = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = reader.readLine().split(" ");
        int n = Integer.parseInt(nm[0]), m = Integer.parseInt(nm[1]);
        int[][] add = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] aa = reader.readLine().split(" ");
            add[i][0] = Integer.parseInt(aa[0]);
            add[i][1] = Integer.parseInt(aa[1]);
            alls.add(add[i][0]);
        }

        int[][] query = new int[m][2];
        for (int i = 0; i < m; i++) {
            String[] lr = reader.readLine().split(" ");
            query[i][0] = Integer.parseInt(lr[0]);
            query[i][1] = Integer.parseInt(lr[1]);
            alls.add(query[i][0]);
            alls.add(query[i][1]);
        }

        alls = new ArrayList<>(new HashSet<>(alls));
        alls.sort(Comparator.comparingInt(a -> a));

        for (int i = 0; i < n; i++) {
            int x = find(add[i][0]);
            A[x] += add[i][1];
        }

        for (int i = 1; i <= alls.size(); i++) {
            S[i] = S[i - 1] + A[i];
        }

        for (int i = 0; i < m; i++) {
            int[] q = query[i];
            int l = find(q[0]), r = find(q[1]);
            System.out.println(S[r] - S[l - 1]);
        }
    }

    private static int find(int x) {
        int l = 0, r = alls.size() - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (alls.get(mid) >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l + 1;
    }
}
