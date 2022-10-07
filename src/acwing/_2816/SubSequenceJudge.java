package acwing._2816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubSequenceJudge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = reader.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
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
        boolean isSeq = isSubsequence(A, B);
        System.out.println(isSeq ? "Yes" : "No");
        reader.close();
    }

    /**
     * 双指针
     * @param A
     * @param B
     * @return
     */
    private static boolean isSubsequence(int[] A, int[] B) {
        for (int i = 0, j = 0; i < A.length; i++) {
            while (j < B.length && B[j] != A[i]) {
                j++;
            }
            if (j >= B.length) {
                break;
            }
            if (i == A.length - 1) {
                return true;
            }
            j++;
        }
        return false;
    }
}
