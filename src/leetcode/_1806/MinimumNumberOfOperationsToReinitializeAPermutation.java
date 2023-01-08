package leetcode._1806;

import java.util.Arrays;

public class MinimumNumberOfOperationsToReinitializeAPermutation {
    public int reinitializePermutation(int n) {
        int[] perm = new int[n];
        for (int i = 0; i < n; i++) perm[i] = i;

        int res = 0;
        while (true) {
            boolean done = true;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                if ((i & 1) == 0) arr[i] = perm[i / 2];
                else arr[i] = perm[n / 2 + (i - 1) / 2];
                if (arr[i] != i) done = false;
            }
//            System.out.println(Arrays.toString(arr));
            res++;
            if (done) break;
            perm = arr;
        }
        return res;
    }

    // TODO: 2023/1/8 数学

    public static void main(String[] args) {
        MinimumNumberOfOperationsToReinitializeAPermutation mn = new MinimumNumberOfOperationsToReinitializeAPermutation();
        System.out.println(mn.reinitializePermutation(2));
        System.out.println(mn.reinitializePermutation(4));
        System.out.println(mn.reinitializePermutation(6));
    }
}
