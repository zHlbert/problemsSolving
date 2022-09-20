package leetcode._1640;

import java.util.Arrays;

public class CheckArrayFormationThroughConcatenation {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int k = 0, c = -1;
        for (int value : arr) {
            if (c >= 0 && k < pieces[c].length) {
                if (value != pieces[c][k++]) {
                    return false;
                } else {
                    continue;
                }
            }
            k = 0;
            int j = 0;
            for (; j < pieces.length; j++) {
                if (value == pieces[j][k]) {
                    k++;
                    c = j;
                    break;
                }
            }
            if (j == pieces.length) {
                return false;
            }
        }
        return true;
    }

    /**
     * 哈希
     * @param arr
     * @param pieces
     * @return
     */
    public boolean canFormArray1(int[] arr, int[][] pieces) {
        int[] idx = new int[105];
        Arrays.fill(idx, -1);
        for (int i = 0; i < pieces.length; i++) {
            idx[pieces[i][0]] = i;
        }
        for (int i = 0; i < arr.length;) {
            int c = idx[arr[i]];
            if (c == -1) {
                return false;
            }
            for (int j = 0; j < pieces[c].length; j++) {
                if (arr[i++] != pieces[c][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckArrayFormationThroughConcatenation ca = new CheckArrayFormationThroughConcatenation();
//        int[] arr = {15,88};
//        int[][] pieces = {{88},{15}};
//        int[] arr = {49,18,16};
//        int[][] pieces = {{16,18,49}};
        int[] arr = {91,4,64,78};
        int[][] pieces = {{78},{4,64},{91}};
        System.out.println(ca.canFormArray1(arr, pieces));
    }
}
