package leetcode._927;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/three-equal-parts/
 */
public class ThreeEqualParts {
    public int[] threeEqualParts(int[] arr) {
        int n = arr.length;
        // 统计1的数量
        int cnt = 0;
        for (int a : arr) {
            cnt += a;
        }
        if (cnt % 3 != 0) {
            return new int[] {-1, -1};
        }
        if (cnt == 0) {
            return new int[] {0, n - 1};
        }
        // first 第一个 1 下标， second 第二部分 开始的 1 下标，third 第三部分 开始的 1 下标
        int first = -1, second = -1, third = -1, k = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                k++;
                if (first == -1) {
                    first = i;
                }
                if (k == cnt / 3 + 1 && second == -1) {
                    second = i;
                }
                if (k == cnt / 3 * 2 + 1 && third == -1) {
                    third = i;
                }
            }
        }
        int len = n - third;
        for (int i = 0; i < len; i++) {
            if (arr[first + i] != arr[second + i] || arr[second + i] != arr[third + i]) {
                return new int[] {-1, -1};
            }
        }
        return new int[] {first + len - 1, second + len};
    }

    public static void main(String[] args) {
        ThreeEqualParts tep = new ThreeEqualParts();
        System.out.println(Arrays.toString(tep.threeEqualParts(new int[] {1,0,1,0,1})));
        System.out.println(Arrays.toString(tep.threeEqualParts(new int[] {1,1,0,1,1})));
        System.out.println(Arrays.toString(tep.threeEqualParts(new int[] {1,1,0,0,1})));
    }
}
