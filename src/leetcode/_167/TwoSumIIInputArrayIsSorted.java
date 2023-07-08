package leetcode._167;

import java.util.Arrays;

public class TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j < n && numbers[i] + numbers[j] < target) {
                j++;
            }
            if (j < n && numbers[i] + numbers[j] == target) {
                return new int[] {i + 1, j + 1};
            }

        }
        return new int[0];
    }

    public int[] twoSum1(int[] numbers, int target) {
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            int l = i + 1, r = n - 1;
            while (l < r) {
                int mid = (l + r + 1) >> 1;
                if (numbers[mid] <= target - numbers[i]) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            if (numbers[l] + numbers[i] == target) {
                return new int[] {i + 1, l + 1};
            }
        }
        return new int[0];
    }

    public int[] twoSum2(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                return new int[] {l + 1, r + 1};
            }
            if (numbers[l] + numbers[r] < target) l++;
            else r--;
        }
        return new int[0];
    }

    public static void main(String[] args) {
        TwoSumIIInputArrayIsSorted ts = new TwoSumIIInputArrayIsSorted();
        System.out.println(Arrays.toString(ts.twoSum2(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(ts.twoSum2(new int[]{2, 3, 4}, 6)));
        System.out.println(Arrays.toString(ts.twoSum2(new int[]{-1, 0}, -1)));
        System.out.println(Arrays.toString(ts.twoSum2(new int[]{5, 25, 75}, 100)));
        System.out.println(Arrays.toString(ts.twoSum2(new int[]{3, 24, 50, 79, 88, 150, 345}, 200)));
    }
}
