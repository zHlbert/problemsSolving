package leetcode._1053;

public class PreviousPermutationWithOneSwap {
    public int[] prevPermOpt1(int[] arr) {
        int fi = -1, n = arr.length;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                fi = i;
                break;
            }
        }

        if (fi == -1) return arr;
        int si = fi + 1;
        for (int i = fi + 2; i < n; i++) {
            if (arr[i] < arr[fi] && arr[i] > arr[si]) {
                si = i;
            }
        }
        int tmp = arr[fi];
        arr[fi] = arr[si];
        arr[si] = tmp;
        return arr;
    }
}
