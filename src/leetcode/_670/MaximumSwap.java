package leetcode._670;

import java.util.Arrays;

public class MaximumSwap {
    public int maximumSwap(int num) {
        int n = 0;
        int[] nums = new int[10];
        while (num != 0) {
            nums[n++] = num % 10;
            num /= 10;
        }
        for (int i = n - 1; i >= 0; i--) {
            int k = i;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] > nums[k] || k != i && nums[j] == nums[k]) {
                    k = j;
                }
            }
            if (k != i) {
                int tmp = nums[k];
                nums[k] = nums[i];
                nums[i] = tmp;
                break;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            num *= 10;
            num += nums[i];
        }
        return num;
    }

    public static void main(String[] args) {
        MaximumSwap ms = new MaximumSwap();
        System.out.println(ms.maximumSwap(2736));
        System.out.println(ms.maximumSwap(9973));
        System.out.println(ms.maximumSwap(1993));
    }
}
