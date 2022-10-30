package utils;

public class ArrayUtils {
    public static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void printArray(int[] nums, int start, int end) {
        for (int i = Math.max(0, start); i < Math.min(end, nums.length); i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void print2DArray(int[][] nums) {
        for (int[] ints : nums) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 反转nums的[begin, end)区间内元素
     * @param nums
     * @param begin
     * @param end
     */
    public static void reverse(int[] nums, int begin, int end) {
        for (int i = begin; i < (begin + end) >> 1; i++) {
            swap(nums, i, end - 1 + begin - i);
        }
    }

    public static boolean nextPermutation(int[] nums, int begin, int end) {
        int len = nums.length;
        if (len < end) {
            return false;
        }
        int i = end - 2;
        while (i >= begin && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= begin) {
            int j = end - 1;
            while (i < j && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, end);
        return i >= begin;
    }
}
