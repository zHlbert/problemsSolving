package acwing._800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TargetSumInArr {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nmx = reader.readLine().split(" ");
        int n = Integer.parseInt(nmx[0]);
        int m = Integer.parseInt(nmx[1]);
        int x = Integer.parseInt(nmx[2]);
        String[] As = reader.readLine().split(" ");
        String[] Bs = reader.readLine().split(" ");
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(As[i]);
        }
        int[] B = new int[m];
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(Bs[i]);
        }
        int[] res = findIJ(A, B, x);
        System.out.println(res[0] + " " + res[1]);
        reader.close();
    }

    /**
     * 双指针
     * @param A
     * @param B
     * @param x
     * @return
     */
    private static int[] findIJ(int[] A, int[] B, int x) {
        for (int i = 0, j = B.length - 1; i < A.length; i++) {
            while (j >= 0 && A[i] + B[j] > x) {
                j--;
            }
            if (A[i] + B[j] == x) {
                return new int[] {i, j};
            }
        }
        return new int[0];
    }
}
