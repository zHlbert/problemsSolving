package leetcode._1089;

import utils.ArrayUtils;

/**
 * https://leetcode.cn/problems/duplicate-zeros/
 */
public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int zeros = 0;
        int i = 0;
        for (; i < n; i++) {
            if (arr[i] == 0) {
                zeros++;
            }
            // 找到最后一位i, 使 [0, i] 中 0 复写后 总长度 >= n - 1
            // {1,0,2,0,0} arr[3] == 0, 此时 i + zeros > n - 1
            if (i + zeros >= n - 1) {
                break;
            }
        }
        if (zeros == 0) {
            return;
        }
        int index = n - 1;
        while (i >= 0) {
            int iVal = arr[i];
            arr[index--] = arr[i--];
            // arr[i] == 0 且 最后一位不是0
            if (iVal == 0 && i + zeros < n - 1) {
                arr[index--] = iVal;
            }
        }
    }

    public static void main(String[] args) {
        DuplicateZeros dz = new DuplicateZeros();
//        int[] arr = new int[] {1,0,2,3,0,4,5,0};
//        int[] arr = new int[] {1,2,3};
//        int[] arr = new int[] {1,0,2,0,0};
        int[] arr = new int[] {0,1,0,0,0};
        dz.duplicateZeros(arr);
        ArrayUtils.printArray(arr);
    }
}
