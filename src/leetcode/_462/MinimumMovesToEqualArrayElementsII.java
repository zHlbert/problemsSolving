package leetcode._462;

import java.util.Arrays;
import java.util.Random;

/**
 * https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/
 */
public class MinimumMovesToEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        // target 选 nums[n / 2]时移动次数最少
        int target = nums[n >> 1];
        int moves = 0;
        for (int num : nums) {
            moves += Math.abs(num - target);
        }
        return moves;
    }

    Random random = new Random();
    public int minMoves2QuickSelection(int[] nums) {
        int n = nums.length;
        int target = quickSelection(nums, 0, n - 1, n / 2);
        int moves = 0;
        for (int num : nums) {
            moves += Math.abs(num - target);
        }
        return moves;
    }

    private int quickSelection(int[] nums, int left, int right, int idx) {
        int i = randomSelection(nums, left, right);
        if (i == idx) {
            return nums[idx];
        }
        return i < idx ? quickSelection(nums, i + 1, right, idx) : quickSelection(nums, left, i - 1, idx);
    }

    private int randomSelection(int[] nums, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(nums, i, r);
        return partition(nums, l, r);
    }

    private int partition(int[] nums, int l, int r) {
        int x = nums[r], i = l - 1;
        for (int j = l; j < r; j++) {
            if (nums[j] <= x) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        MinimumMovesToEqualArrayElementsII mm = new MinimumMovesToEqualArrayElementsII();
        int[] nums = new int[] {1,0,0,8,6};
        System.out.println(mm.minMoves2QuickSelection(nums));
    }
}
